package de.unidue.iem.tdr.nis.util.numbers;

public class Number {

    private final Encoding encoding;
    private final String represenation;
    private final int value;

    public Number(Encoding encoding, String represenation) {
        this.encoding = encoding;
        this.represenation = represenation;
        this.value = this.encoding.getValueOf(this.represenation);
    }

    public Number(Encoding encoding, int value) {
        this.encoding = encoding;
        this.value = value;
        this.represenation = this.encoding.getRepresentationOf(this.value);
    }

    public Encoding getEncoding() {
        return encoding;
    }

    public String getRepresenation() {
        return represenation;
    }

    public int getValue() {
        return value;
    }

    public int mod(int n) {
        return this.value - (n * (this.value / n));
    }
}
