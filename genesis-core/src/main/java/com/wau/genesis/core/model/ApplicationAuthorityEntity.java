package com.wau.genesis.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Josue Barillas (jbarillas)
 */
@Entity
@Table(name = "application_authority")
public class ApplicationAuthorityEntity implements Serializable {
    
    // Unique identifier
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    // Name
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "name")
    private String name;
    
    // Description
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "description")
    private String description;
    
    // Privileges    
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "application_privilege_rel_authority",
            joinColumns = { @JoinColumn(name = "authority")},
            inverseJoinColumns = { @JoinColumn(name = "privilege") }
    )
    private List<ApplicationPrivilegeEntity> privileges;
    
    // Users    
    @JsonIgnore
    @ManyToMany(mappedBy = "authorities")
    private List<ApplicationUserEntity> users;

    public ApplicationAuthorityEntity() {
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

    public List<ApplicationPrivilegeEntity> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<ApplicationPrivilegeEntity> privileges) {
        this.privileges = privileges;
    }

    public List<ApplicationUserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<ApplicationUserEntity> users) {
        this.users = users;
    }
    
}
