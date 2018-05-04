package de.unidue.iem.tdr.nis.util;

public enum NumEncoding {

    BINARY(new char[]{'0', '1'}, 2),
    OCTA(new char[]{'0', '1','2', '3','4', '5','6', '7'}, 8),
    DEC(new char[]{'0', '1','2', '3','4', '5','6', '7','8', '9'}, 10),
    HEXA(new char[]{'0', '1','2', '3','4', '5','6', '7','8', '9','a', 'b','c', 'd','e', 'f'}, 16);

    private final char[] characters;
    private final int numOfCharacters;

    NumEncoding(char[] characters, int numOfCharacters) {
        this.characters = characters;
        this.numOfCharacters = numOfCharacters;
    }

    public char[] getCharacters() {
        return characters;
    }

    public int getNumOfCharacters() {
        return numOfCharacters;
    }

    public String getRepresentationOf(int i) {
        final StringBuilder representationBuilder = new StringBuilder();

        while (i > 0) {
            representationBuilder.insert(0, characters[i % this.numOfCharacters]);
            i /= this.numOfCharacters;
        }
        return representationBuilder.toString();
    }

    public int getValueOf(String representation) {
        final int rep_digits = representation.length();
        int value = 0;

        for (int i = rep_digits-1; i >= 0; i--) {
            value += this.characters[representation.charAt(i)] * this.numOfCharacters * (rep_digits - i);
        }
        return value;
    }

}
