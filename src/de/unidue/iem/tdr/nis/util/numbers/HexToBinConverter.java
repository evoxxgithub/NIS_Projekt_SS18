package de.unidue.iem.tdr.nis.util.numbers;

public class HexToBinConverter implements INumConverter {
    @Override
    public String convert(String rep) {
        StringBuilder conversionBuilder = new StringBuilder();
        for (int i = 0; i < rep.length(); i++) {
            String bin = Encoding.BINARY.getRepresentationOf(Encoding.HEXA.getValueOf(rep.substring(i, i+1)));
            System.out.println("pre_bin: " + bin);
            for (int j = 0; j < 4 - bin.length(); j++) {
                conversionBuilder.append('0');
            }
            conversionBuilder.append(bin);
        }
        System.out.println("bin: " + conversionBuilder.toString());
        return conversionBuilder.toString();
    }
}