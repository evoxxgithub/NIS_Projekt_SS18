package de.unidue.iem.tdr.nis.util.encryption;

import de.unidue.iem.tdr.nis.util.numbers.EncodedString;

public interface EncryptionAlgorithm {

    EncodedString encrypt(String plain);

    String decrypt(EncodedString cipherText);
}
