package de.unidue.iem.tdr.nis.util.numbers;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EncodingTest {

    @Test
    public void toUpperCase() {
        String randomString = "ewofnowefnweofnweofnweofn";
        Assert.assertEquals(randomString.toUpperCase(),
                Encoding.toUpperCase(randomString));
    }
}