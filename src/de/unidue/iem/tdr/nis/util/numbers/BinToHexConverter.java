package de.unidue.iem.tdr.nis.util.numbers;

public class BinToHexConverter implements INumConverter {
    @Override
    public String convert(String rep) {
        final StringBuilder conversionBuilder = new StringBuilder();
        final StringBuilder repPreparer = new StringBuilder(rep);
        final int zeros_to_prepend = rep.length() % 4;
        for (int i = 0; i < zeros_to_prepend; i++) {
            repPreparer.insert(0, '0');
        }
        rep = repPreparer.toString();

        for (int i = 0; i < rep.length(); i += 4) {
            final String hexa_character = rep.substring(i, i + 4);
            conversionBuilder.append(
                    Encoding.HEXA.getRepresentationOf(
                            Encoding.BINARY.getValueOf(hexa_character)
                    ));
        }
        String result = conversionBuilder.toString();
        return result;
    }
}
