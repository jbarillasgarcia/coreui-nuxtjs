package com.wau.genesis.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Josue Barillas (jbarillas)
 */
@Entity
@Table(name = "application_privilege")
public class ApplicationPrivilegeEntity implements Serializable {
    
    // Unique identifier
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    // Name
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    
    // Description
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "description")
    private String description;
    
    // Authorities
    @JsonIgnore
    @ManyToMany(mappedBy = "privileges")
    private List<ApplicationAuthorityEntity> authorities;
    
    // Categories
    @JsonIgnore
    @ManyToMany(mappedBy = "privileges")
    private List<ApplicationPrivilegeCategoryEntity> categories;

    public ApplicationPrivilegeEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ApplicationAuthorityEntity> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<ApplicationAuthorityEntity> authorities) {
        this.authorities = authorities;
    }

    public List<ApplicationPrivilegeCategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(List<ApplicationPrivilegeCategoryEntity> categories) {
        this.categories = categories;
    }
    
}
