package com.solvd.carina.tests;

import org.testng.annotations.Test;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.crypto.Algorithm;
import com.zebrunner.carina.crypto.CryptoTool;
import com.zebrunner.carina.crypto.CryptoToolBuilder;
import com.zebrunner.carina.utils.R;

import static org.testng.Assert.assertEquals;

public class CryptoTests implements IAbstractTest {
    
    private static CryptoTool cryptoToolConfig(String algorithm, String key) {
        CryptoTool cryptoTool = CryptoToolBuilder.builder()
                .chooseAlgorithm(Algorithm.AES_ECB_PKCS5_PADDING)
                .setKey(key)
                .build();

        return cryptoTool;
    }

    @Test
    public void testEncryption() {
        CryptoTool cryptoTool = cryptoToolConfig(R.CONFIG.get("crypto_algorithm"), R.CONFIG.get("crypto_key_value"));
        assertEquals(cryptoTool.decrypt(R.CONFIG.get("password"), R.CONFIG.get("crypto_pattern")), "adam");
    }

    @Test
    void testPlaceholdersWithEncryption() {
        CryptoTool cryptoTool = cryptoToolConfig(R.CONFIG.get("crypto_algorithm"), R.CONFIG.get("crypto_key_value"));
        assertEquals(cryptoTool.decrypt(R.CONFIG.get("credentials"), R.CONFIG.get("crypto_pattern")),
                "email@test.com/adam");
    }

    @Test
    public void testPlaceholdersWithEncryptionTestData() {
        CryptoTool cryptoTool = cryptoToolConfig(R.CONFIG.get("crypto_algorithm"), R.CONFIG.get("crypto_key_value"));
        assertEquals(cryptoTool.decrypt(R.TESTDATA.get("test_credentials"), R.CONFIG.get("crypto_pattern")),
                "email@test.com/adam");
    }

}
