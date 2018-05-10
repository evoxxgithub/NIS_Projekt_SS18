package de.unidue.iem.tdr.nis.util.encryption;

import de.unidue.iem.tdr.nis.util.numbers.Encoding;

public class Vigenere implements EncryptionAlgorithm {

    private final String key;
    private static final Encoding ENC = Encoding.ALPHABET_CAPSLOCK;

    public Vigenere(String key) {
        this.key = key;
    }

    @Override
    public String encrypt(String plain) {
        StringBuilder cipherBuilder = new StringBuilder();
        for (int i = 0; i < plain.length(); i++) {
            char keyChar = key.charAt(i % key.length());
            char plainChar = plain.charAt(i);

            char cipherLetter = ENC.getCharacters()[ENC.indexOf(keyChar) + ENC.indexOf(plainChar)
                            % ENC.numofChars()];
            cipherBuilder.append(cipherLetter);
        }
        return cipherBuilder.toString();
    }

    @Override
    @SuppressWarnings("All")
    public String decrypt(String cipherText) {
        StringBuilder plainBuilder = new StringBuilder();
        for (int i = 0; i < cipherText.length(); i++) {
            char keyChar = key.charAt(i % key.length());
            char cipherChar = cipherText.charAt(i);
            int positiveCharCode = ENC.indexOf(cipherChar) - ENC.indexOf(keyChar) + ENC.numofChars();
            char plainLetter = ENC.getCharacters()[positiveCharCode % ENC.numofChars()];
            plainBuilder.append(plainLetter);
        }
        return plainBuilder.toString();
    }
}
