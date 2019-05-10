package com.wau.genesis.jwtauthservice.service;

import com.wau.genesis.jwtauthservice.dao.AuthorityRepository;
import com.wau.genesis.jwtauthservice.dao.PrivilegeRepository;
import com.wau.genesis.jwtauthservice.dao.UserRepository;
import com.wau.genesis.core.model.ApplicationAuthorityEntity;
import com.wau.genesis.jwtauthservice.model.GenericResponseBody;
import com.wau.genesis.core.model.ApplicationPrivilegeEntity;
import com.wau.genesis.jwtauthservice.model.UserData;
import com.wau.genesis.core.model.ApplicationUserEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Josue Barillas (jbarillas)
 */
@Service
public class AuthorityService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private AuthorityRepository authorityRepository;    
    
    @Autowired
    private PrivilegeRepository privilegeRepository;
    
    public GenericResponseBody<UserData> me() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getPrincipal().toString();
        ApplicationUserEntity user = this.userRepository.findByUsername(username);
        List authorities = Arrays.asList(auth.getAuthorities().toArray());        

        List<ApplicationPrivilegeEntity> privilegeEntities = this.privilegeRepository.findAllByUsername(username);
        List<String> privileges = new ArrayList();
        
        for (ApplicationPrivilegeEntity privilegeEntity : privilegeEntities) {
            privileges.add(privilegeEntity.getName());
        }
        
        UserData userData = new UserData();
        userData.setUsername(username);
        userData.setAuthorities(authorities);
        userData.setPrivileges(privileges);
        
        if (user != null) {
            userData.setFirstName(user.getFirstName());
            userData.setLastName(user.getLastName());
        }

        return new GenericResponseBody(userData);
    }
    
    public String getPasswordHint(String username) throws Exception {
        String passwordHint = null;
        
        if (username == null || username.trim().equals("")) {
            throw new Exception("Usuario inválido|Debe especificar un usuario válido.");
        }
        
        ApplicationUserEntity user = this.userRepository.findByUsername(username);
        
        if (user != null) {
            return user.getPasswordHint();
        } else {
            throw new Exception(String.format("Usuario inválido|El usuario %s no existe en el sistema.", username));
        }
    }
    
    public List<ApplicationAuthorityEntity> getAllAuthorities() {
        return (List<ApplicationAuthorityEntity>) this.authorityRepository.findAll();
    }
    
    public ApplicationAuthorityEntity getAuthorityById(Integer id) {
        return this.authorityRepository.findById(id).get();
    }
    
    public ApplicationAuthorityEntity getAuthorityByName(String name) {
        return this.authorityRepository.findByName(name);
    }
    
    public ApplicationAuthorityEntity createAuthority(ApplicationAuthorityEntity authority) throws Exception {
        for (int i = 0; i < authority.getPrivileges().size(); i++) {
            authority.getPrivileges().set(i, this.privilegeRepository.findById(authority.getPrivileges().get(i).getId()).get());
        }
        
        return this.authorityRepository.save(authority);
    }
    
    public ApplicationAuthorityEntity updateAuthority(ApplicationAuthorityEntity authority)  throws Exception {
        for (int i = 0; i < authority.getPrivileges().size(); i++) {
            authority.getPrivileges().set(i, this.privilegeRepository.findById(authority.getPrivileges().get(i).getId()).get());
        }
        
        return this.authorityRepository.save(authority);
    }
}
