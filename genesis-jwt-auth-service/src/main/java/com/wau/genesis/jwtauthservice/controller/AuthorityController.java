package com.wau.genesis.jwtauthservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wau.genesis.core.model.ApplicationAuthorityEntity;
import com.wau.genesis.jwtauthservice.service.AuthorityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Josue Barillas (jbarillas)
 */
@RestController
@RequestMapping("/authority")
@Api("Authority Management System")
public class AuthorityController {
    
    private Logger logger = LoggerFactory.getLogger(AuthorityController.class);
            
    @Autowired
    private AuthorityService authService;    
    
    @ApiOperation(value = "View a list of available authorities.")
    @GetMapping("/getAllAuthorities")
    public ResponseEntity<Object> getAllAuthorities() {
        this.logger.debug(String.format("@%s::getAllAuthorities()", this.getClass().getName()));
        
        List<ApplicationAuthorityEntity> authorities = (List<ApplicationAuthorityEntity>) this.authService.getAllAuthorities();
        
        return ResponseEntity.ok(authorities);
    }
    
    @ApiOperation(value = "View a specific authority filtered by identifier.")
    @GetMapping("/getAuthorityById")
    public ResponseEntity<Object> getAuthorityById(@RequestParam(required = true) Integer authorityId) {
        this.logger.debug(String.format("@%s::getAuthorityById(%d)", this.getClass().getName(), authorityId));
        
        ApplicationAuthorityEntity authority = this.authService.getAuthorityById(authorityId);
        
        return ResponseEntity.ok(authority);
    }
    
    @ApiOperation(value = "View a specific authority filtered by name.")
    @GetMapping("/getAuthorityByName")
    public ResponseEntity<Object> getAuthorityByName(@RequestParam(required = true) String authorityName) {
        this.logger.debug(String.format("@%s::getAuthorityByName(%s)", this.getClass().getName(), authorityName));
        
        ApplicationAuthorityEntity authority = this.authService.getAuthorityByName(authorityName);
        
        return ResponseEntity.ok(authority);
    }
    
    @ApiOperation(value = "Create a new authority.")
    @PostMapping("/createAuthority")
    public ResponseEntity<Object> createAuthority(@RequestBody ApplicationAuthorityEntity authority) throws Exception {
        this.logger.debug(String.format("@%s::createAuthority(AuthorityEntity)", this.getClass().getName()));
                
        return ResponseEntity.ok(this.authService.createAuthority(authority));
    }
    
    @ApiOperation(value = "Update an existing authority.")
    @PutMapping("/updateAuthority")
    public ResponseEntity<Object> updateAuthority(@RequestBody ApplicationAuthorityEntity authority) throws Exception {
        this.logger.debug(String.format("@%s::updateAuthority(AuthorityEntity)", this.getClass().getName()));
                
        return ResponseEntity.ok(this.authService.updateAuthority(authority));
    }
}
