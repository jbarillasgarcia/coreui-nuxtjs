package com.wau.genesis.jwtauthservice.dao;

import com.wau.genesis.core.model.ApplicationUserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Josue Barillas (jbarillas)
 */
@Repository
public interface UserRepository extends CrudRepository<ApplicationUserEntity, Integer> {
    
    public ApplicationUserEntity findByUsername(String username);
    
}
