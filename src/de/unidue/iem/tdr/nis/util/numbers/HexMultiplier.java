package de.unidue.iem.tdr.nis.util.numbers;

import java.util.Arrays;

import static de.unidue.iem.tdr.nis.util.encryption.AESConstants.*;

public class HexMultiplier {


    public String multiply(String hex1, String hex2) {
        final StringBuilder solutionBuilder = new StringBuilder();
        final HexToBinConverter hex_to_bin = new HexToBinConverter();
        System.out.println("multhex1: " + hex1);
        System.out.println("multhex2: " + hex2);
        final BinToHexConverter bin_to_hex = new BinToHexConverter();
        final String bin1 = hex_to_bin.convert(hex1);
        final String bin2 = hex_to_bin.convert(hex2);
        System.out.println("multbin1: " + bin1);
        System.out.println("multbin2: " + bin2);
        int[] mult_result = new int[bin1.length()+bin2.length()];
        for (int i = 0; i < bin1.length(); i++) {
            for (int j = 0; j < bin2.length(); j++) {
                if (bin1.charAt(bin1.length()-1-i) == '1' && bin2.charAt(bin2.length()-1-j) == '1')
                    mult_result[mult_result.length-1-i-j] += 1;
                if (mult_result[mult_result.length-1-i-j] > 1) {
                    mult_result[mult_result.length-1-i-j] = 0;
                    for (int z = mult_result.length-2-i-j; z > 0; z--) {
                        if (mult_result[z] == 1 ) mult_result[z] = 0;
                        else {
                            mult_result[z] = 1;
                            break;
                        }
                    }
                }
            }
        }
        mult_result = removeFirstZeros(mult_result);
        System.out.println("Mult-unmodded");
        System.out.println(Arrays.toString(mult_result));
        final String bin_result = calculatePolMod(mult_result);
        System.out.println("mult-result-binary");
        System.out.println(bin_result);
        String result = bin_to_hex.convert(bin_result);
        System.out.println("hex-result: " + result);
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
        for (int i = 0; i <= mult_result.length - mod_polynom.length; i++) {
            if (mult_result[i] == 0) continue;
            for (int j = 0; j < mod_polynom.length; j++) {
                mult_result[i+j] = (mult_result[i+j] + mod_polynom[j]) % 2;
            }
        }
        final StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            resultBuilder.append(mult_result[mult_result.length - 8 + i]);
        }
        final String result = resultBuilder.toString();
        return result;
    }
}
