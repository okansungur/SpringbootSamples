package com.example.tmp.monopro.service;



import com.example.tmp.monopro.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

     List<User> getUserList();

     List<User> getOrderedUserList(int limit);

     String addUpdateUser(User user);

     String deleteUser(User user);

     String saveUserRole(User user);

     Optional<User> getUserByID(Long userid);
}






