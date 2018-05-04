package de.unidue.iem.tdr.nis.util.numbers;

public class HexToBinConverter implements INumConverter {
    @Override
    public String convert(String rep) {
        StringBuilder conversionBuilder = new StringBuilder();
        for (int i = 0; i < rep.length(); i++) {
            conversionBuilder.append(
              NumEncoding.BINARY.getRepresentationOf(
                      NumEncoding.HEXA.getValueOf(rep.substring(i, i + 1))
              )
            );
        }
        return conversionBuilder.toString();
    }
}