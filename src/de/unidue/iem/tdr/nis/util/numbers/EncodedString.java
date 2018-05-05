package de.unidue.iem.tdr.nis.util.numbers;

public class EncodedString {

    private final String represenation;
    private final Encoding encoding;

    public EncodedString(String represenation, Encoding encoding) {
        this.represenation = represenation;
        this.encoding = encoding;
    }
}
