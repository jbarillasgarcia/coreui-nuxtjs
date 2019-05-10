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
public class UnsuccessfulAuthData {
    
    private String message;

    public UnsuccessfulAuthData(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }    
    
}
