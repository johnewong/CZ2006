package com.example.demo.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionUtil {
    /**
     * Method to encrypt password
     * Using SHA-256 algorithm to encrypt
     *
     * @param password  raw password
     * @return encrypted password
     */
    public static String encryptPassword(String password) {
        try {
            // Create MessageDigest instance for Sha-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes()); //Add password bytes to digest
            //get the hash bytes
            byte byteData[] = md.digest();

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            // get complete hash password
            password = sb.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return password;
    }

}
