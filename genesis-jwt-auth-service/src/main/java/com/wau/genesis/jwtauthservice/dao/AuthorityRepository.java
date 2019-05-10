package com.wau.genesis.jwtauthservice.dao;

import com.wau.genesis.core.model.ApplicationAuthorityEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Josue Barillas (jbarillas)
 */
@Repository
public interface AuthorityRepository extends CrudRepository<ApplicationAuthorityEntity, Integer> {
    
    public ApplicationAuthorityEntity findByName(String name);
    
}
