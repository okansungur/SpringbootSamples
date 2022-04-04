package com.example.tmp.monopro.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name = "srole", schema = "azspace")
public class Role implements GrantedAuthority, Serializable {
    private static final long serialVersionUID = 1234567841950251808L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    private String name;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    // GrantedAuthority security
    @Override
    public String getAuthority() {
        return getName();
    }


}
