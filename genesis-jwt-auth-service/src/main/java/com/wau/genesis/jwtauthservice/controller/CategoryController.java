package com.wau.genesis.jwtauthservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wau.genesis.core.model.ApplicationPrivilegeCategoryEntity;
import com.wau.genesis.jwtauthservice.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Josue Barillas (jbarillas)
 */
@RestController
@RequestMapping("/privilegeCategory")
public class CategoryController {
    
    private Logger logger = LoggerFactory.getLogger(CategoryController.class);
    
    @Autowired
    private CategoryService categoryService;
    
    @GetMapping("/getAllCategories")
    public ResponseEntity<Object> getAllCategories() {
        this.logger.debug(String.format("@%s::getAllCategories()", this.getClass().getName()));
        
        List<ApplicationPrivilegeCategoryEntity> categories = (List<ApplicationPrivilegeCategoryEntity>) this.categoryService.getAllCategories();
        
        return ResponseEntity.ok(categories);
    }
    
}
