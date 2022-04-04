package com.example.tmp.monopro.service;


import com.example.tmp.monopro.entity.User;
import com.example.tmp.monopro.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsSvc {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)  {
        LOGGER.info("loadUserByUsername");
        User user = userRepository.findByEmail(username);
        if (user == null) {
            return null;
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                user.getRoles());

    }



}
