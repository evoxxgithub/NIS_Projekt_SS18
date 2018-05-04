package de.unidue.iem.tdr.nis.util;

public class Number {

    private final NumEncoding encoding;
    private final String represenation;
    private final int value;

    public Number(NumEncoding encoding, String represenation) {
        this.encoding = encoding;
        this.represenation = represenation;
        this.value = this.encoding.getValueOf(this.represenation);
    }

    public Number(NumEncoding encoding, int value) {
        this.encoding = encoding;
        this.value = value;
        this.represenation = this.encoding.getRepresentationOf(this.value);
    }

    public NumEncoding getEncoding() {
        return encoding;
    }

    public String getRepresenation() {
        return represenation;
    }

    public int getValue() {
        return value;
    }
}
