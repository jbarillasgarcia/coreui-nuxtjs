package com.wau.genesis.zuulgateway.util;

import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author Josue Barillas (jbarillas)
 */
public class JwtConfig {
    
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

    public String getHeader() {
        return header;
    }

    public String getPasswordRecoveryUri() {
        return passwordRecoveryUri;
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
