/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wau.genesis.jwtauthservice.model;

/**
 *
 * @author Josue Barillas (jbarillas)
 */
public class AuthenticationData {
    
    private String type;
    private String token;
    private String refreshToken;

    public AuthenticationData(String type, String token, String refreshToken) {
        this.type = type;
        this.token = token;
        this.refreshToken = refreshToken;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
    
    
    
}
