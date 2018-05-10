package de.unidue.iem.tdr.nis.util.string;

import de.unidue.iem.tdr.nis.util.numbers.Encoding;

public class EncodedString {

    private final String represenation;
    private final Encoding encoding;

    public EncodedString(String represenation, Encoding encoding) {
        this.represenation = represenation;
        this.encoding = encoding;
    }

    public String getRepresenation() {
        return represenation;
    }

    public Encoding getEncoding() {
        return encoding;
    }
}
