package com.wau.genesis.apiservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Josue Barillas (jbarillas)
 */
@Entity
public class TransactionEntity {
    
    @Id    
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }    
    
}
