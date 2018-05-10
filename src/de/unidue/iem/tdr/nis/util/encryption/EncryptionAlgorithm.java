package de.unidue.iem.tdr.nis.util.encryption;

public interface EncryptionAlgorithm {

    String encrypt(String plain);

    String decrypt(String cipherText);
}
