package com.wau.genesis.jwtauthservice.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Josue Barillas (jbarillas)
 */
public class PasswordEncoder {
    
    private Logger logger = LoggerFactory.getLogger(PasswordEncoder.class);

    private static final String RAW_PASSWORD = "12345";
    
    public static void main(String[] args) {
        new PasswordEncoder().doEncode();
    }
    
    public void doEncode() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        this.logger.info("**************************************************************************");
        this.logger.info(String.format("RAW = %s", RAW_PASSWORD));
        this.logger.info(String.format("ENCODED = %s", encoder.encode(RAW_PASSWORD)));
        this.logger.info("**************************************************************************");
    }
    
}
