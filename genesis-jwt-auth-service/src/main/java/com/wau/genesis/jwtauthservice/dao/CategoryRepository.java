package com.wau.genesis.jwtauthservice.dao;

import com.wau.genesis.core.model.ApplicationPrivilegeCategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Josue Barillas (jbarillas)
 */
@Repository
public interface CategoryRepository extends CrudRepository<ApplicationPrivilegeCategoryEntity, Integer> {
    
    public ApplicationPrivilegeCategoryEntity findByName(String name);
    
}
