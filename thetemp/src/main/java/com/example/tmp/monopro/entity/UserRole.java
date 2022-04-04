package com.example.tmp.monopro.entity;



import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "suserrole", schema = "azspace")
public class UserRole   implements Serializable {
    private static final long serialVersionUID = 1235172041950251802L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sid;

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    private Long userId;
    private Long roleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
