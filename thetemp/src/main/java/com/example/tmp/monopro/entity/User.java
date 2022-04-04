package com.example.tmp.monopro.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "suser", schema = "azspace")
public class User  implements Serializable {
    private static final long serialVersionUID = 1234172041950251807L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
       public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    private String firstName;
    private String lastName;
    private String email;

    private String password;


    private boolean enabled;

    @ManyToMany
   // @JoinTable(name = "azspace.suserrole", joinColumns = @JoinColumn(name = "userid"), inverseJoinColumns = @JoinColumn(name = "roleid"))

    @JoinTable(
            name = "azspace.suserrole",
            joinColumns = @JoinColumn(
                    name = "userid", referencedColumnName = "userid"),
            inverseJoinColumns = @JoinColumn(
                    name = "roleid", referencedColumnName = "roleid"))

    private List<Role> roles;



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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }





    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
