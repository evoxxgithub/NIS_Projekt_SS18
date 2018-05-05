package de.unidue.iem.tdr.nis.util.encryption;

import de.unidue.iem.tdr.nis.util.numbers.EncodedString;
import de.unidue.iem.tdr.nis.util.numbers.Encoding;

public class CaesarCipher implements EncryptionAlgorithm {

    private final int shift_amount;

    public CaesarCipher(int shift_amount) {
        this.shift_amount = shift_amount;
    }

    @Override
    public EncodedString encrypt(String plain) {
        StringBuilder cipherBuilder = new StringBuilder();
        for (int i = 0; i < plain.length(); i++) {
            //next_char =
            //cipherBuilder.append(Encoding.ALPHABET_CAPSLOCK.getRepresentationOf())
        }
        return null; // delete
    }

    @Override
    public String decrypt(EncodedString cipherText) {
        return null;
    }
}
