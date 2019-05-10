/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wau.genesis.jwtauthservice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.wau.genesis.jwtauthservice.dao.UserRepository;
import com.wau.genesis.core.model.ApplicationAuthorityEntity;
import com.wau.genesis.core.model.ApplicationUserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Josue Barillas (jbarillas)
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
    private Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        this.logger.debug(String.format("@%s::loadUserByUsername(String)", this.getClass().getName()));

        //Iterable<ApplicationUser> users = this.userRepository.findAll();
        
        ApplicationUserEntity appUser = this.userRepository.findByUsername(username);
        
        // hard coding the users. All passwords must be encoded.
        /*final List<ApplicationUser> users = Arrays.asList(
                new ApplicationUser(1, "omar", encoder.encode("12345"), "USER"),
                new ApplicationUser(2, "admin", encoder.encode("12345"), "ADMIN")
        );*/

        if (appUser != null) {
            // Remember that Spring needs roles to be in this format: "ROLE_" + userRole (i.e. "ROLE_ADMIN")
                // So, we need to set it to that format, so we can verify and compare roles (i.e. hasRole("ADMIN")).
                List<ApplicationAuthorityEntity> roles = appUser.getAuthorities();//Arrays.asList(appUser.getRole().split(","));
                
                String authoritiesList = "";
                
                authoritiesList = roles.stream().map((role) -> "ROLE_" + role.getName() + ",").reduce(authoritiesList, String::concat);
                                                
                List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(authoritiesList);

                // The "User" class is provided by Spring and represents a model class for user to be returned by UserDetailsService
                // And used by auth manager to verify and check user authentication.
                return new User(appUser.getUsername(), appUser.getPassword(), grantedAuthorities);
        }
        
        // If user not found. Throw this exception.
        throw new UsernameNotFoundException("Username: " + username + " not found");
    }

}
