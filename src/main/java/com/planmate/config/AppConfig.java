package com.planmate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author : leeyounggyo
 * @package : com.planmate.config
 * @since : 2024. 10. 14.
 */
@Configuration
public class AppConfig {

    @Bean
    public PwEncoder passwordEncoder() {
        return new PasswordEncryptor();
    }


}
