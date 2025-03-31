package com.solvd.carina.tests;

import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.R;

import static org.testng.Assert.assertEquals;

public class CryptoTests implements IAbstractTest {

    @Test
    public void testEncryption() {
        assertEquals(R.CONFIG.getDecrypted("password"), "adam");
    }

    @Test
    void testPlaceholdersWithEncryption() {
        assertEquals(R.CONFIG.getDecrypted("credentials"),"email@test.com/adam");
    }

    @Test
    public void testPlaceholdersWithEncryptionTestData() {
        assertEquals(R.TESTDATA.getDecrypted("test_credentials"),"email@test.com/adam");
    }  

}
