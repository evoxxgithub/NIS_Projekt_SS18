package de.unidue.iem.tdr.nis.util.string;

public interface StringUtils {

    static String shiftLeft(String input) {
        char lastChar = input.charAt(0);
        StringBuilder shiftBuilder = new StringBuilder();
        shiftBuilder.append(input.substring(1, input.length()));
        shiftBuilder.append(lastChar);
        return shiftBuilder.toString();
    }

    static void shiftLeft(char[] input) {

    }

    static void shiftRight(String input) {

    }

    static void shiftRight(char[] input) {

    }
}
