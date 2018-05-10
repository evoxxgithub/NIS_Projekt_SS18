package de.unidue.iem.tdr.nis.util.encryption;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DESTest {

    private DES des;

    @Before
    public void setUp() {
        this.des = new DES("1110010010001011101010110101110010100000100000100001100010000001");
    }

    @Test
    public void encrypt() {
    }

    @Test
    public void decrypt() {
    }

    @Test
    public void getKeyOfRound() {
        System.out.println("key: " + "1110010010001011101010110101110010100000100000100001100010000001");
        String key1 = des.getKeyOfRound(3);
    }
}