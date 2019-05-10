package com.wau.genesis.jwtauthservice.controller;

import com.wau.genesis.core.model.ApplicationUserEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wau.genesis.jwtauthservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Josue Barillas (jbarillas)
 */
@RestController
@RequestMapping("/user")
public class UserController {
    
    private Logger logger = LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    private UserService userService;
            
    @GetMapping("/getAllUsers")
    public ResponseEntity<Object> getAllUsers() {
        this.logger.debug(String.format("@%s::getAllUsers()", this.getClass().getName()));
           
        List<ApplicationUserEntity> users = (List<ApplicationUserEntity>) this.userService.getAllUsers(); 
        
        return ResponseEntity.ok(users);
    }
    
    @GetMapping("/getUserByUsername")
    public ResponseEntity<Object> getUserByUsername(@RequestParam(name = "username", required = true) String username) throws Exception {
        this.logger.debug(String.format("@%s::getUserByUsername(%s)", this.getClass().getName(), username));
        
        return ResponseEntity.ok(this.userService.getUserByUsername(username));
    }
    
    @PostMapping("/createUser")
    public ResponseEntity<Object> createUser(@RequestBody ApplicationUserEntity user) throws Exception {
        this.logger.debug(String.format("@%s::createUser(UserEntity)", this.getClass().getName()));
                
        return ResponseEntity.ok(this.userService.createUser(user));
    }
    
    @PutMapping("/updateUser")
    public ResponseEntity<Object> updateUser(@RequestBody ApplicationUserEntity user) throws Exception {
        this.logger.debug(String.format("@%s::updateUser(UserEntity)", this.getClass().getName()));
        
        return ResponseEntity.ok(this.userService.updateUser(user));
    }
    
}
