package com.wau.genesis.core.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author Josue Barillas (jbarillas)
 */
@Entity
@Table(name = "application_user")
public class ApplicationUserEntity implements Serializable {

    // Unique identifier
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    // First name
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "first_name")
    private String firstName;

    // Last name
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "last_name")
    private String lastName;

    // Email
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;

    // Address
    @Basic(optional = false)    
    @Size(min = 1, max = 50)
    @Column(name = "address")
    private String address;

    // Phone
    @Basic(optional = false)
    @Size(min = 1, max = 25)
    @Column(name = "phone")
    private String phone;

    // Birth date
    @Column(name = "birth_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;
    
    // Picture
    @Lob
    @Basic(optional = false)    
    @Column(name = "picture")
    private byte[] picture;

    // Username
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "username")
    private String username;

    // Password
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "password")
    private String password;

    // Password hint
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "password_hint")
    private String passwordHint;

    // Enabled
    @Basic(optional = false)
    @NotNull
    @Column(name = "enabled")
    private Boolean enabled = Boolean.TRUE;
    
    // Default system user
    @Basic(optional = false)
    @NotNull
    @Column(name = "default_system_user")
    private Boolean defaultSystemUser = Boolean.FALSE;
    
    // Removable
    @Basic(optional = false)
    @NotNull
    @Column(name = "removable")
    private Boolean removable = Boolean.FALSE;

    // Created by
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private ApplicationUserEntity createdBy;

    // Created date
    @NotNull
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate = new Date();

    // Last modified by
    @JoinColumn(name = "last_modified_by", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ApplicationUserEntity lastModifiedBy;

    // Last modified date
    @Column(name = "last_modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    // Authorities    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "application_authority_rel_user",
            joinColumns = {
                @JoinColumn(name = "user")},
            inverseJoinColumns = {
                @JoinColumn(name = "authority")}
    )
    private List<ApplicationAuthorityEntity> authorities;
    
    // Privileges    
    @Fetch(value = FetchMode.SUBSELECT)
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "application_privilege_rel_user",
            joinColumns = {
                @JoinColumn(name = "user")},
            inverseJoinColumns = {
                @JoinColumn(name = "privilege")}
    )
    private List<ApplicationPrivilegeEntity> privileges;

    public ApplicationUserEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordHint() {
        return passwordHint;
    }

    public void setPasswordHint(String passwordHint) {
        this.passwordHint = passwordHint;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getDefaultSystemUser() {
        return defaultSystemUser;
    }

    public void setDefaultSystemUser(Boolean defaultSystemUser) {
        this.defaultSystemUser = defaultSystemUser;
    }

    public Boolean getRemovable() {
        return removable;
    }

    public void setRemovable(Boolean removable) {
        this.removable = removable;
    }

    public ApplicationUserEntity getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(ApplicationUserEntity createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public ApplicationUserEntity getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(ApplicationUserEntity lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public List<ApplicationAuthorityEntity> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<ApplicationAuthorityEntity> authorities) {
        this.authorities = authorities;
    }

    public List<ApplicationPrivilegeEntity> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<ApplicationPrivilegeEntity> privileges) {
        this.privileges = privileges;
    }
    
}
