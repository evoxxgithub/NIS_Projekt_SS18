package de.unidue.iem.tdr.nis.util.numbers;

public interface Functions {

    static HexToBinConverter hextobin = new HexToBinConverter();
    static BinToHexConverter bintohex = new BinToHexConverter();

    static String binaryXor(String a, String b) {
        while(a.length() > b.length()) {
            b = "0" + b;
        }
        while(b.length() > a.length()) {
            a = "0" + a;
        }
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

    static String hexXor(String a, String b) {
        System.out.println("hexxor1: " + a);
        System.out.println("hexxor2: " + b);
        a = hextobin.convert(a);
        b = hextobin.convert(b);
        System.out.println("binxor1: " + a);
        System.out.println("binxor2: " + b);
        String xorresult = binaryXor(a, b);
        System.out.println("xor-result: " + xorresult);
        String result = bintohex.convert(xorresult);
        System.out.println("xorresult: " + result);
        return result;
    }

    static int mod(int a, int b) {
        assert b > 0;
        int result =  a - (b * (a / b));
        if (result  < 0) { result += b; } //positify
        return result;
    }
}
