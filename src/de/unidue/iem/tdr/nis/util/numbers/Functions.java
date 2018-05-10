package de.unidue.iem.tdr.nis.util.numbers;

public interface Functions {

    static String xor(String a, String b) {
        assert a.length() == b.length();
        StringBuilder xorBuilder = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            char first = a.charAt(i);
            char second = b.charAt(i);
            if (first == second) {
                xorBuilder.append('0');
            } else {
                xorBuilder.append('1');
            }
        }
        return xorBuilder.toString();
    }

    static int mod(int a, int b) {
        assert b > 0;
        int result =  a - (b * (a / b));
        if (result  < 0) { result += b; } //positify
        return result;
    }
}
