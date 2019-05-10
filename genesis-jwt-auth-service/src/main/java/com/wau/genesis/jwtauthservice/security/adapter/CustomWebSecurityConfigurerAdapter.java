/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wau.genesis.jwtauthservice.security.adapter;

import com.wau.genesis.jwtauthservice.security.filter.CustomOncePerRequestFilter;
import com.wau.genesis.jwtauthservice.security.filter.CustomUsernamePasswordAuthenticationFilter;
import com.wau.genesis.jwtauthservice.util.ApplicationConfiguration;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 *
 * @author Josue Barillas (jbarillas)
 */
@EnableWebSecurity
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
    
    private Logger logger = LoggerFactory.getLogger(CustomWebSecurityConfigurerAdapter.class);

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private ApplicationConfiguration jwtConfig;
    
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        this.logger.debug(String.format("@%s::configure(HttpSecurity)", this.getClass().getName()));
        
        http
                .csrf().disable()
                // make sure we use stateless session; session won't be used to store user's state.
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // handle an authorized attempts 
                .exceptionHandling().authenticationEntryPoint((req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                .and()
                // Add a filter to validate user credentials and add token in the response header
                .addFilterAfter(new CustomOncePerRequestFilter(this.jwtConfig), UsernamePasswordAuthenticationFilter.class)
                // What's the authenticationManager()? 
                // An object provided by WebSecurityConfigurerAdapter, used to authenticate the user passing user's credentials
                // The filter needs this auth manager to authenticate the user.
                .addFilter(new CustomUsernamePasswordAuthenticationFilter(this.authenticationManager(), this.jwtConfig))
                .authorizeRequests()                
                // allow all POST requests 
                .antMatchers(HttpMethod.POST, this.jwtConfig.getUri()).permitAll()
                // allow GET request for password recovery
                .antMatchers(HttpMethod.GET, this.jwtConfig.getPasswordRecoveryUri()).permitAll()
                // allow GET request for swagger UI
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()
                .antMatchers("/v2/**").permitAll()
                .antMatchers("/csrf/**").permitAll()
                .antMatchers("/webjars/springfox-swagger-ui/favicon-16x16.png?v=2.9.2").permitAll()
                // any other requests must be authenticated
                .anyRequest().authenticated();                
    }

    // Spring has UserDetailsService interface, which can be overriden to provide our implementation for fetching user from database (or any other source).
    // The UserDetailsService object is used by the auth manager to load the user from database.
    // In addition, we need to define the password encoder also. So, auth manager can compare and verify passwords.
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        this.logger.debug(String.format("@%s::configure(AuthenticationManagerBuilder)", this.getClass().getName()));
        
        //auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
    }

    /*@Bean
    public JwtConfig jwtConfig() {
        return new JwtConfig();
    }*/
    
}
