package de.unidue.iem.tdr.nis.util.encryption;


public class Message {
    private String plainText;
    private String cipherText;
    private EncryptionAlgorithm encryptionAlgorithm;

    public Message(String plainText, EncryptionAlgorithm encryptionAlgorithm) {
        this.plainText = plainText;
        this.encryptionAlgorithm = encryptionAlgorithm;
    }

    public String getPlainText() {
        return plainText;
    }

    public String getCipherText() {
        return cipherText;
    }

    public EncryptionAlgorithm getEncryptionAlgorithm() {
        return encryptionAlgorithm;
    }

    public void encryptPlain() {
        this.cipherText = this.encryptionAlgorithm.encrypt(this.plainText);
    }

    public void decryptCipher() {
        this.plainText = this.encryptionAlgorithm.decrypt(this.cipherText);
    }
}
