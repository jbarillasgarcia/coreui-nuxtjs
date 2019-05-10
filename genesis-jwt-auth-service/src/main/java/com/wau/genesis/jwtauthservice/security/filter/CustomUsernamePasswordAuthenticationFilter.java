package com.wau.genesis.jwtauthservice.security.filter;

import com.wau.genesis.jwtauthservice.util.ApplicationConfiguration;
import com.wau.genesis.jwtauthservice.model.AuthenticationData;
import com.wau.genesis.jwtauthservice.model.GenericResponseBody;
import com.wau.genesis.jwtauthservice.model.UnsuccessfulAuthData;
import com.wau.genesis.jwtauthservice.model.UserCredentials;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.stream.Collectors;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 *
 * @author Josue Barillas (jbarillas)
 */
public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    
    private Logger logger = LoggerFactory.getLogger(CustomUsernamePasswordAuthenticationFilter.class);

    private final AuthenticationManager authManager;

    private final ApplicationConfiguration jwtConfig;

    public CustomUsernamePasswordAuthenticationFilter(AuthenticationManager authManager, ApplicationConfiguration jwtConfig) {
        this.authManager = authManager;
        this.jwtConfig = jwtConfig;

        // By default, UsernamePasswordAuthenticationFilter listens to "/login" path. 
        // In our case, we use "/auth". So, we need to override the defaults.
        this.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher(jwtConfig.getUri(), "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        this.logger.debug(String.format("@%s::attemptAuthentication(HttpServletRequest, HttpServletResponse)", this.getClass().getName()));
        
        try {

            // 1. Get credentials from request
            UserCredentials creds = new ObjectMapper().readValue(request.getInputStream(), UserCredentials.class);

            // 2. Create auth object (contains credentials) which will be used by auth manager
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    creds.getUsername(), creds.getPassword(), Collections.emptyList());

            // 3. Authentication manager authenticate the user, and use UserDetialsServiceImpl::loadUserByUsername() method to load the user.
            return authManager.authenticate(authToken);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Upon successful authentication, generate a token.
    // The 'auth' passed to successfulAuthentication() is the current authenticated user.
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication auth) throws IOException, ServletException {

        this.logger.debug(String.format("@%s::successfulAuthentication(HttpServletRequest, HttpServletResponse, FilterChain, Authentication)", this.getClass().getName()));

        Long now = System.currentTimeMillis();
        String token = Jwts.builder()
                .setSubject(auth.getName())
                // Convert to list of strings. 
                // This is important because it affects the way we get them back in the Gateway.
                .claim("authorities", auth.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + jwtConfig.getExpiration() * 1000)) // in milliseconds
                .signWith(SignatureAlgorithm.HS512, jwtConfig.getSecret().getBytes())
                .compact();

        // Add token to header
        response.addHeader(jwtConfig.getHeader(), jwtConfig.getPrefix() + token);

        // Allow CORS
        //response.addHeader("Allow-Control-Allow-Origin", "*");

        //response.getOutputStream().write("Hola mundo...".getBytes());
        //response.getOutputStream().flush();
        AuthenticationData authData = new AuthenticationData("bearer", token, null);

        GenericResponseBody<AuthenticationData> body = new GenericResponseBody<>(authData);

        response.setContentType("application/json");

        Gson gson = new Gson();
        response.getWriter().print(gson.toJson(body));
        response.getWriter().flush();
    }
    
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        
        this.logger.debug(String.format("@%s::unsuccessfulAuthentication(HttpServletRequest, HttpServletResponse, AuthenticationException)", this.getClass().getName()));
        
        UnsuccessfulAuthData authData = new UnsuccessfulAuthData(authException.getMessage());
        
        GenericResponseBody<UnsuccessfulAuthData> body = new GenericResponseBody<>(authData);
        
        response.setContentType("application/json");
        
        Gson gson = new Gson();
        response.getWriter().print(gson.toJson(body));
        response.getWriter().flush();
    }

}
