package com.planmate.config;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author : leeyounggyo
 * @package : com.planmate.config
 * @since : 2024. 10. 14.
 */
public class PasswordEncryptor implements PwEncoder {

    @Override
    public String encryptPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error while hashing password", e);
        }
    }

    @Override
    public boolean validatePassword(String rawPassword, String encryptedPassword) {
        String hashedInputPassword = encryptPassword(rawPassword);
        return hashedInputPassword.equals(encryptedPassword);
    }
}
