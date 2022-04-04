package com.example.tmp.monopro.service;


import com.example.tmp.monopro.entity.Role;
import com.example.tmp.monopro.entity.User;
import com.example.tmp.monopro.repo.RoleRepository;
import com.example.tmp.monopro.repo.UserRepository;
import com.example.tmp.monopro.utility.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class UserServiceImpl implements   UserService {
    private static final java.util.logging.Logger LOGGER = Logger.getLogger(UserServiceImpl.class.getName());
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;



    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getOrderedUserList(int limit) {
        return entityManager.createQuery("SELECT p FROM  User p ORDER BY p.userId",
                User.class).setMaxResults(limit).getResultList();
    }

    @Override
    public String addUpdateUser(User user) {
         userRepository.save(user);
        LOGGER.log(Level.INFO, "user-saved {0}.", user.getUserId());
        return "Successfully saved : " ;
    }

    @Override
    public String deleteUser(User user) {
        LOGGER.log(Level.INFO, "user-deleting {0}.", user.getUserId());
        userRepository.delete(user);
        LOGGER.log(Level.INFO, "user deleted");
        return "Successfully deleted ";
    }

    @Override
     public String saveUserRole( User user){
        Role roleUser = roleRepository.findByName(Roles.ROLE_USER+"");
        user.setRoles((Arrays.asList(roleUser)));
       userRepository.save(user);
        LOGGER.log(Level.INFO, "user  {0} saved.", user.getUserId());
        return "Success. Please contact your administrator to enable your account ";
    }

    @Override
    public Optional<User> getUserByID(Long userid) {

        return userRepository.findById(userid);

    }

}
