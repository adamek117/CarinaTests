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
        //CryptoTool cryptoTool = cryptoToolConfig(R.CONFIG.get("crypto_algorithm"), R.CONFIG.get("crypto_key_value"));
        assertEquals(R.TESTDATA.getDecrypted("test_credentials"),"email@test.com/adam");
    }
    
    /*private static CryptoTool cryptoToolConfig(String algorithm, String key) {
        CryptoTool cryptoTool = CryptoToolBuilder.builder()
                .chooseAlgorithm(Algorithm.AES_ECB_PKCS5_PADDING)
                .setKey(key)
                .build();

        return cryptoTool;
    }*/

    

}
