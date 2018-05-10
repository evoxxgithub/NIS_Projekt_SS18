package de.unidue.iem.tdr.nis.util.numbers;

public enum Encoding {

    BINARY(new char[]{'0', '1'}, 2, new BinToHexConverter()),
    HEXA(new char[]{
            '0', '1','2', '3','4', '5','6', '7','8', '9','a', 'b','c', 'd','e', 'f'
        }, 16, new HexToBinConverter()),
    DEC(new char[]{
            '0', '1','2', '3','4', '5','6', '7','8', '9'
    }, 10, null),
    ALPHABET_CAPSLOCK(new char[]{
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
            }, 26, null);


    private final char[] characters;
    private final int numOfCharacters;
    private final INumConverter converter;

    Encoding(char[] characters, int numOfCharacters, INumConverter converter) {
        this.characters = characters;
        this.numOfCharacters = numOfCharacters;
        this.converter = converter;
    }

    public static String toUpperCase(String text) {
        StringBuilder upperCaseBuilder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            int charCode = (int) currentChar;
            if (charCode >= 96 && charCode <= 122) {
                char upperCase = (char) (charCode-32);
                upperCaseBuilder.append(upperCase);
            } else {
                upperCaseBuilder.append(currentChar);
            }
        }
        return upperCaseBuilder.toString();
    }

    public char[] getCharacters() {
        return characters;
    }

    public int numofChars() {
        return numOfCharacters;
    }

    public String getRepresentationOf(int i) {
        final StringBuilder representationBuilder = new StringBuilder();
        if (i == 0) return representationBuilder.append(this.characters[0]).toString();
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
            value += indexOf(representation.charAt(i)) * Math.pow(this.numOfCharacters,(rep_digits - i - 1));
        }
        return value;
    }

    public int indexOf(char c) {
        int idx = 0;
        while(idx < this.characters.length) {
            if (this.characters[idx] == c) return idx;
            idx += 1;
        }
        throw new RuntimeException("invalid character code for NumberEncoding");
    }

    String changeEncoding(String rep) {
      if (converter == null) throw new RuntimeException("unable to convert encoding "  + this.toString());
      return this.converter.convert(rep);
    }

}
