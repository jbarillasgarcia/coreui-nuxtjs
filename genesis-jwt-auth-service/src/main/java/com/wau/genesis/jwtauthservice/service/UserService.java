package com.wau.genesis.jwtauthservice.service;

import com.wau.genesis.jwtauthservice.dao.AuthorityRepository;
import com.wau.genesis.jwtauthservice.dao.PrivilegeRepository;
import com.wau.genesis.jwtauthservice.dao.UserRepository;
import com.wau.genesis.core.model.ApplicationUserEntity;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Josue Barillas (jbarillas)
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private AuthorityRepository authorityRepository;
    
    @Autowired
    private PrivilegeRepository privilegeRepository;
    
    @Autowired
    private BCryptPasswordEncoder encoder;
        
    public List<ApplicationUserEntity> getAllUsers() {        
        List<ApplicationUserEntity> allUsers = (List<ApplicationUserEntity>) this.userRepository.findAll();
        
        allUsers.forEach((user) -> {
            user.setPassword("*****");
        });
        
        return allUsers;
    }
    
    public ApplicationUserEntity getUserByUsername(String username) throws Exception {
        ApplicationUserEntity user = this.userRepository.findByUsername(username);
        
        user.setPassword("*****");
        
        return user;
    }
    
    public ApplicationUserEntity createUser(ApplicationUserEntity user) throws Exception {
        String createUsername = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        ApplicationUserEntity createUser = this.userRepository.findByUsername(createUsername);
        
        if (user.getPassword() == null || user.getPassword().trim().equals("")) {
            throw new Exception("Contraseña vacía|Debe especificar una contraseña válida.");
        }
        
        if (user.getAuthorities().isEmpty()) {
            throw new Exception("Rol no seleccionado|Debe seleccionar al menos un rol.");
        }
                
        for (int i = 0; i < user.getAuthorities().size(); i++ ) {
            user.getAuthorities().set(i, this.authorityRepository.findById(user.getAuthorities().get(i).getId()).get());
        }
        
        for (int i = 0; i < user.getPrivileges().size(); i++) {
            user.getPrivileges().set(i, this.privilegeRepository.findById(user.getPrivileges().get(i).getId()).get());
        }
        
        user.setPassword(this.encoder.encode(user.getPassword()));                
        user.setCreatedBy(createUser);
        user.setCreatedDate(new Date());
        
        try {
            user = this.userRepository.save(user);
        } catch (Exception icve) {
            throw icve;
            
            /*if (icve.getCause().getCause().getMessage().matches("Duplicate entry (.*) for key 'application_user_username_uindex'")) {
                throw new Exception(String.format("Usuario ya existe|El usuario que intenta crear ya existe en el sistema."));
            }
            
            throw new Exception("Exception|" + icve.getCause().getCause().getMessage());*/
        }
        
        return this.userRepository.save(user);
    }
    
    public ApplicationUserEntity updateUser(ApplicationUserEntity user) throws Exception {
        String updateUsername = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();                
        ApplicationUserEntity updateUser = this.userRepository.findByUsername(updateUsername);
        
        ApplicationUserEntity currentUser = this.userRepository.findById(user.getId()).get();

        if (user.getPassword() == null || user.getPassword().trim().equals("")) {
            throw new Exception("Contraseña vacía|Debe especificar una contraseña válida.");
        }
        
        if (user.getAuthorities().isEmpty()) {
            throw new Exception("Rol no seleccionado|Debe seleccionar al menos un rol.");
        }
                
        for (int i = 0; i < user.getAuthorities().size(); i++ ) {
            user.getAuthorities().set(i, this.authorityRepository.findById(user.getAuthorities().get(i).getId()).get());
        }
        
        for (int i = 0; i < user.getPrivileges().size(); i++) {
            user.getPrivileges().set(i, this.privilegeRepository.findById(user.getPrivileges().get(i).getId()).get());
        }
        
        user.setPassword(user.getPassword().equals("*****") ? currentUser.getPassword() : this.encoder.encode(user.getPassword()));
        user.setCreatedDate(currentUser.getCreatedDate());
        user.setCreatedBy(currentUser.getCreatedBy());
        user.setLastModifiedBy(updateUser);
        user.setLastModifiedDate(new Date());
                
        return this.userRepository.save(user);
    }
}
