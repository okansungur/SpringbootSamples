package com.example.tmp.monopro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.logging.Level;

@Service
public class SecurityServiceImpl implements SecurityService {


    private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(SecurityServiceImpl.class.getName());

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Override
    public boolean login(String usermail, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(usermail);
        UsernamePasswordAuthenticationToken token = null;


        boolean result = false;
        try {
            if (userDetails != null) {

                token = new UsernamePasswordAuthenticationToken(userDetails, password,
                        userDetails.getAuthorities());

               authenticationManager.authenticate(token);

            }


            if (token != null)
                result = token.isAuthenticated();


            if (result) {
                SecurityContextHolder.getContext().setAuthentication(token);
            }
        } catch (Exception ex) {

            LOGGER.log(Level.SEVERE, "Result {0}.", ex.toString());

        }

        return result;
    }


}
