package com.wau.genesis.jwtauthservice.controller;

import com.wau.genesis.core.model.ApplicationPrivilegeEntity;
import com.wau.genesis.jwtauthservice.service.PrivilegeService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Josue Barillas (jbarillas)
 */
@RestController
@RequestMapping("/privilege")
public class PrivilegeController {
    
    private Logger logger = LoggerFactory.getLogger(PrivilegeController.class);
    
    @Autowired
    private PrivilegeService privilegeService;
    
    @GetMapping("/getAllPrivileges")
    public ResponseEntity<Object> getAllPrivileges() {
        this.logger.debug(String.format("@%s::getAllPrivileges()", this.getClass().getName()));
        
        List<ApplicationPrivilegeEntity> privileges = (List<ApplicationPrivilegeEntity>) this.privilegeService.getAllPrivileges();
        
        return ResponseEntity.ok(privileges);
    }
    
    @GetMapping("/getAllPrivilegesByUsername")
    public ResponseEntity<Object> getAllPrivilegesByUsername(@RequestParam(required = true) String username) {
        this.logger.debug(String.format("@%s::getAllPrivilegesByUsername(%s)", this.getClass().getName(), username));
        
        List<ApplicationPrivilegeEntity> privileges = this.privilegeService.getAllPrivilegesByUsername(username);
        
        return ResponseEntity.ok(privileges);
    }
    
    @GetMapping("/getPrivilegesByUsername")
    public ResponseEntity<Object> getPrivilegesByUsername(@RequestParam(required = true) String username) {
        this.logger.debug(String.format("@%s::getPrivilegesByUsername(%s)", this.getClass().getName(), username));
        
        List<ApplicationPrivilegeEntity> privileges = this.privilegeService.getPrivilegesByUsername(username);
        
        return ResponseEntity.ok(privileges);
    }
    
}
