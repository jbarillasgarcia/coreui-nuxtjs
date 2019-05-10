package com.wau.genesis.jwtauthservice.service;

import com.wau.genesis.jwtauthservice.dao.PrivilegeRepository;
import com.wau.genesis.core.model.ApplicationPrivilegeEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Josue Barillas (jbarillas)
 */
@Service
public class PrivilegeService {
    
    @Autowired
    private PrivilegeRepository privilegeRepository;
    
    public List<ApplicationPrivilegeEntity> getAllPrivileges() {
        return (List<ApplicationPrivilegeEntity>) this.privilegeRepository.findAll();
    }
    
    public List<ApplicationPrivilegeEntity> getAllPrivilegesByUsername(String username) {
        return this.privilegeRepository.findAllByUsername(username);
    }
    
    public List<ApplicationPrivilegeEntity> getPrivilegesByUsername(String username) {
        return this.privilegeRepository.findByUsername(username);
    }
    
}
