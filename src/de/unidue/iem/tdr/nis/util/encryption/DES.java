package de.unidue.iem.tdr.nis.util.encryption;

import de.unidue.iem.tdr.nis.util.numbers.Functions;
import de.unidue.iem.tdr.nis.util.string.StringUtils;

import static de.unidue.iem.tdr.nis.util.encryption.DESConstants.*;

public class DES implements EncryptionAlgorithm {

    private final String masterkey;
    private String c_block;
    private String d_block;
    private int roundsFinished;
    private String l_block;
    private String r_block;

    public DES(String masterkey) {
        this.masterkey = masterkey;
        this.roundsFinished = 1;
        this.buildCBlock();
        this.buildDBlock();
    }

    public String getR_block() {
        return this.r_block;
    }

    public String getL_block() {
        return this.l_block;
    }

    public void setNewInput(String input) {
        final String ip_input = this.performinitialPermutation(input);
        this.l_block = ip_input.substring(0, 32);
        this.r_block = ip_input.substring(32,input.length());
    }

    private String performinitialPermutation(String input) {
        final StringBuilder ipBuilder = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            ipBuilder.append(input.charAt(ip_chooses[i]-1));
        }
        return ipBuilder.toString();
    }

    @Override
    public String encrypt(String plain) {
        return null;
    }

    @Override
    public String decrypt(String cipherText) {
        return null;
    }

    public String getNextKey() {
        for(int j = 0; j < numberOfShifts[this.roundsFinished-1]; j++) {
            c_block = StringUtils.shiftLeft(c_block);
            d_block = StringUtils.shiftLeft(d_block);
        }
        StringBuilder pc2KeyBuilder = new StringBuilder();
        final String pc2KeyBlock = c_block + d_block;
        for (int i = 0; i < 48; i++) {
            pc2KeyBuilder.append(pc2KeyBlock.charAt(pc2_chooses[i]-1));
        }
        this.roundsFinished += 1;
        return pc2KeyBuilder.toString();
    }

    public String getKeyOfRound(int roundNumber) {
        for(int i = 0; i < roundNumber; i++) {
            for(int j = 0; j < numberOfShifts[i]; j++) {
                c_block = StringUtils.shiftLeft(c_block);
                d_block = StringUtils.shiftLeft(d_block);
            }
        }
        StringBuilder pc2KeyBuilder = new StringBuilder();
        final String pc2KeyBlock = c_block + d_block;
        for (int i = 0; i < 48; i++) {
            pc2KeyBuilder.append(pc2KeyBlock.charAt(pc2_chooses[i]-1));
        }
        return pc2KeyBuilder.toString();
    }

    private void buildCBlock() {
        final StringBuilder blockBuilder = new StringBuilder();
        for (int i = 0; i < SUBKEY_BLOCK_LENGTH; i++) {
            blockBuilder.append(this.masterkey.charAt(c_block_chooses[i]-1));
        }
        this.c_block = blockBuilder.toString();
    }

    private void buildDBlock() {
        final StringBuilder blockBuilder = new StringBuilder();
        for (int i = 0; i < SUBKEY_BLOCK_LENGTH; i++) {
            blockBuilder.append(this.masterkey.charAt(d_block_chooses[i]-1));
        }
        this.d_block = blockBuilder.toString();
    }

    public void iterateRound() {
        final String expandedBlock = expand(this.r_block);
        final String feistelResult = feistel(expandedBlock, this.getNextKey());
        final String old_l_block = this.l_block;
        this.l_block = this.r_block;
        this.r_block = Functions.xor(feistelResult, old_l_block);
    }

    public void roundwith(String r_block, String l_block, String round_key) {
        this.r_block = r_block;
        this.l_block = l_block;
        final String expandedBlock = expand(this.r_block);
        final String feistelResult = feistel(expandedBlock, round_key);
        final String old_l_block = this.l_block;
        this.l_block = this.r_block;
        this.r_block = Functions.xor(feistelResult, old_l_block);
    }
}
