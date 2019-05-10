package com.wau.genesis.jwtauthservice.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author Josue Barillas (jbarillas)
 */
@Component
public class ApplicationConfiguration {
 
    @Value("${security.jwt.uri}")
    private String uri;
    
    @Value("${security.jwt.passwordRecoveryUri}")
    private String passwordRecoveryUri;

    @Value("${security.jwt.header}")
    private String header;

    @Value("${security.jwt.prefix}")
    private String prefix;

    @Value("${security.jwt.expiration}")
    private int expiration;

    @Value("${security.jwt.secret}")
    private String secret;

    public String getUri() {
        return uri;
    }

    public String getPasswordRecoveryUri() {
        return passwordRecoveryUri;
    }

    public String getHeader() {
        return header;
    }

    public String getPrefix() {
        return prefix;
    }

    public int getExpiration() {
        return expiration;
    }

    public String getSecret() {
        return secret;
    }
    
}
