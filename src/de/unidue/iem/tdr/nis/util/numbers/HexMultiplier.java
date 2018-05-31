package de.unidue.iem.tdr.nis.util.numbers;

import java.util.Arrays;

import static de.unidue.iem.tdr.nis.util.encryption.AESConstants.*;

public class HexMultiplier {


    public String muliply(String hex1, String hex2) {
        final StringBuilder solutionBuilder = new StringBuilder();
        final HexToBinConverter hex_to_bin = new HexToBinConverter();
        final String bin1 = hex_to_bin.convert(hex1);
        final String bin2 = hex_to_bin.convert(hex2);
        System.out.println("aes-bin1: " + bin1);
        System.out.println("aes-bin2: " + bin2);
        int[] mult_result = new int[bin1.length()+bin2.length()];
        for (int i = 0; i < bin1.length(); i++) {
            for (int j = 0; j < bin2.length(); j++) {
                if (bin1.charAt(bin1.length()-1-i) == '1' && bin2.charAt(bin2.length()-1-j) == '1')
                    mult_result[mult_result.length-1-i-j] += 1;
            }
        }
        System.out.println(Arrays.toString(mult_result));
        mult_result = removeFirstZeros(mult_result);
        System.out.println(Arrays.toString(mult_result));
        final String result = calculatePolMod(mult_result);
        return result;
    }

    private int[] removeFirstZeros(int[] mult_result) {
        int numberOfDigits = mult_result.length;
        while(mult_result[mult_result.length  - numberOfDigits] == 0 && numberOfDigits > 8) {
            numberOfDigits -= 1;
        }
        int[] result = new int[numberOfDigits];
        for (int i = 0; i < result.length; i++) {
            result[i] = mult_result[mult_result.length - numberOfDigits + i];
        }
        return result;
    }

    private String calculatePolMod(int[] mult_result) {
        for (int i = mult_result.length-1; i >= mod_polynom.length-1; i--) {
            for (int j = 0; j < mod_polynom.length; j++) {
                mult_result[i-j] =
                        (mult_result[i-j]
                        + mod_polynom[mod_polynom.length-1-j]) % 2;
            }
        }
        final StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < mod_polynom.length-1; i++) {
            resultBuilder.append(mult_result[i]);
        }
        final String result = resultBuilder.toString();
        System.out.println("calc-result: " + result);
        return new BinToHexConverter().convert(result);
    }
}
