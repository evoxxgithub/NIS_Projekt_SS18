package de.unidue.iem.tdr.nis.util.numbers;

public enum NumEncoding {

    BINARY(new char[]{'0', '1'}, 2, new INumConverter[]{
            new BinToBinConverter(),
            new BinToDecConverter(),
            new BinToHexConverter()
    }),
    DEC(new char[]{'0', '1','2', '3','4', '5','6', '7','8', '9'}, 10, new INumConverter[]{
            new DecToBinConverter(),
            new DecToDecConverter(),
            new DecToHexConverter()
    }),
    HEXA(new char[]{'0', '1','2', '3','4', '5','6', '7','8', '9','a', 'b','c', 'd','e', 'f'}, 16, new INumConverter[]{
            new HexToBinConverter(),
            new HexToDecConverter(),
            new HexToHexConverter()
    });

    private final char[] characters;
    private final int numOfCharacters;
    private final INumConverter[] converters;

    private interface ConverterNumbers {
        int BINARY = 0;
        int DEC = 1;
        int HEXA = 2;
    }

    NumEncoding(char[] characters, int numOfCharacters, INumConverter[] converters) {
        this.characters = characters;
        this.numOfCharacters = numOfCharacters;
        this.converters = converters;
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
            value += getIndexOf(representation.charAt(i)) * Math.pow(this.numOfCharacters,(rep_digits - i - 1));
            System.out.println("i: " + i + " value: " + value + " rep: " + representation);
        }
        return value;
    }

    private int getIndexOf(char c) {
        int idx = 0;
        while(idx < this.characters.length) {
            if (this.characters[idx] == c) return idx;
            idx += 1;
        }
        throw new RuntimeException("invalid character code for NumberEncoding");
    }

    String toEncoding(NumEncoding enc, String rep) {
        switch (enc) {
            case BINARY: return this.converters[ConverterNumbers.BINARY].convert(rep);
            case DEC:    return this.converters[ConverterNumbers.DEC].convert(rep);
            case HEXA:   return this.converters[ConverterNumbers.HEXA].convert(rep);
        }
        throw new RuntimeException("illegal encoding");
    }

}
