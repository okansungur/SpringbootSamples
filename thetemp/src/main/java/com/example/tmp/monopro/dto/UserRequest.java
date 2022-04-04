package com.example.tmp.monopro.dto;


import com.example.tmp.monopro.entity.User;
import com.example.tmp.monopro.entity.UserRole;
import org.springframework.transaction.annotation.Transactional;
import java.util.logging.Logger;
@Transactional
public class UserRequest {


private UserRole userRole;
    private User user;

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
