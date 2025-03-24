package com.solvd.carina.tests;

import java.security.NoSuchAlgorithmException;

import com.zebrunner.carina.crypto.Algorithm;
import com.zebrunner.carina.crypto.CryptoTool;
import com.zebrunner.carina.crypto.CryptoToolBuilder;
import com.zebrunner.carina.crypto.SecretKeyManager;

/**
 * Hello world!
 *
 */
public class App {
    private final static Algorithm algorithm = Algorithm.AES_ECB_PKCS5_PADDING;

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String a = generateKey();
        String b = encryptData("adam", a);
        System.out.println(a);
        System.out.println(b);
    }

    public static String generateKey() throws NoSuchAlgorithmException {
        String secretKey = SecretKeyManager.generateKeyAsString(algorithm, 128);
        return secretKey;
    }

    public static String encryptData(String data, String secretKey) {
        CryptoTool cryptoTool = CryptoToolBuilder.builder()
                .chooseAlgorithm(algorithm)
                .setKey(secretKey)
                .build();
        return cryptoTool.encrypt(data);
    }
}
