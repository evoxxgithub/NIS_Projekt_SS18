package de.unidue.iem.tdr.nis.util.encryption;

import de.unidue.iem.tdr.nis.util.numbers.BinToHexConverter;
import de.unidue.iem.tdr.nis.util.numbers.Encoding;
import de.unidue.iem.tdr.nis.util.numbers.Functions;
import de.unidue.iem.tdr.nis.util.numbers.HexMultiplier;

public class AES {

    public static BinToHexConverter converter = new BinToHexConverter();

    public static String[] keyexpandsion(String key) {
        String[] words = new String[44];
        StringBuilder builder = new StringBuilder();
        words[0] = key.substring(0, 8);
        words[1] = key.substring(8, 16);
        words[2] = key.substring(16, 24);
        words[3] = key.substring(24, 32);
        for (int i = 4; i < 44; i+= 4) {
            String g = getGFromWord(words[i-1], i);
            words[i] = Functions.hexXor(words[i-4], g);
            words[i+1] = Functions.hexXor(words[i-3], words[i]);
            words[i+2] = Functions.hexXor(words[i-2], words[i+1]);
            words[i+3] = Functions.hexXor(words[i-1], words[i+2]);
        }
        return words;
    }

    public static String shiftRows(String words) {
        String row1 = words.substring(0, 8);
        String row2 = words.substring(8, 16);
        String row3 = words.substring(16, 24);
        String row4 = words.substring(24, 32);
        row2 = row2.substring(2, 8) + row2.substring(0, 2);
        row3 = row3.substring(4, 8) + row3.substring(0, 4);
        row4 = row4.substring(6, 8) + row4.substring(0, 6);
        return row1 + row2 + row3 + row4;
    }

    public static String mixColumns(String words) {
        StringBuilder resultBuilder = new StringBuilder();
        HexMultiplier hexMultiplier = new HexMultiplier();
        String column;
        for (int i = 0; i < 8; i += 2) {
            for( int j = 0; j < AESConstants.c_matrix.length; j++) {
                String columnbyte = Functions.hexXor(
                        Functions.hexXor(
                                hexMultiplier.multiply(words.substring(i,i + 2), AESConstants.c_matrix[j][0]),
                                hexMultiplier.multiply(words.substring(i + 8,i + 10), AESConstants.c_matrix[j][1])),
                        Functions.hexXor(
                                hexMultiplier.multiply(words.substring(i + 16,i + 18), AESConstants.c_matrix[j][2]),
                                hexMultiplier.multiply(words.substring(i + 24,i + 26), AESConstants.c_matrix[j][3])));
                resultBuilder.append(columnbyte);
            }
        };


    return resultBuilder.toString();
    }

    private static String getGFromWord(String word, int i) {
        return Functions.hexXor(subWord(rotWord(word)), AESConstants.rcon(i / 4) + "000000");
    }

    private static String subWord(String s) {
        StringBuilder wordBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2) {
            wordBuilder.append(AESConstants.sbox[Encoding.HEXA.getValueOf(s.substring(i, i +1))][Encoding.HEXA
                    .getValueOf(s.substring(i+1, i+2))]);
        }
        return wordBuilder.toString();
    }

    private static String rotWord(String word) {
        return word.substring(2,8) + word.substring(0, 2);
    }
}
