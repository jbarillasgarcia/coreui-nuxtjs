/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wau.genesis.jwtauthservice.model;

import java.util.List;

/**
 *
 * @author Josue Barillas (jbarillas)
 */
public class UserData {
    
    private String username;
    private String firstName;
    private String lastName;
    private List authorities;
    private List privileges;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List authorities) {
        this.authorities = authorities;
    }    

    public List getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List privileges) {
        this.privileges = privileges;
    }
    
}
