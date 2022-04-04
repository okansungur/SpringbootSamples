package com.example.tmp.monopro.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailsSvc extends org.springframework.security.core.userdetails.UserDetailsService {

    UserDetails loadUserByUsername(String mailadress) throws UsernameNotFoundException;



}
