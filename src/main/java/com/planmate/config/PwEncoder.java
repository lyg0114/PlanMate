package com.planmate.config;

/**
 * @author : leeyounggyo
 * @package : com.planmate.config
 * @since : 2024. 10. 14.
 */
public interface PwEncoder {
    String encryptPassword(String password);
    boolean validatePassword(String rawPassword, String encryptedPassword);
}
