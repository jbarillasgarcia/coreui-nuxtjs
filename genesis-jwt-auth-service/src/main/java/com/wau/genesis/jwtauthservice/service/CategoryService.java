package com.wau.genesis.jwtauthservice.service;

import com.wau.genesis.jwtauthservice.dao.CategoryRepository;
import com.wau.genesis.core.model.ApplicationPrivilegeCategoryEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Josue Barillas (jbarillas)
 */
@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<ApplicationPrivilegeCategoryEntity> getAllCategories() {
        return (List<ApplicationPrivilegeCategoryEntity>) this.categoryRepository.findAll();
    }
}
