package com.wau.genesis.jwtauthservice.controller;

import com.wau.genesis.jwtauthservice.model.GenericResponseBody;
import com.wau.genesis.jwtauthservice.model.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wau.genesis.jwtauthservice.service.AuthorityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Josue Barillas (jbarillas)
 */
@RestController
public class DefaultController {
    
    private Logger logger = LoggerFactory.getLogger(DefaultController.class);
    
    @Autowired
    private AuthorityService authorityService;    

    @GetMapping("/me")
    public ResponseEntity<Object> me() {
        this.logger.debug(String.format("@%s::me()", this.getClass().getName()));
        
        GenericResponseBody<UserData> responseBody = this.authorityService.me();

        return ResponseEntity.ok(responseBody);
    }
    
    @GetMapping("/passwordRecovery")
    public ResponseEntity<Object> passwordRecovery(@RequestParam(required = true) String username) throws Exception {
        this.logger.debug(String.format("@%s::passwordRecovery(%s)", this.getClass().getName(), username));
        
        String passwordHint = this.authorityService.getPasswordHint(username);
        
        return ResponseEntity.ok(passwordHint);
    }
}
