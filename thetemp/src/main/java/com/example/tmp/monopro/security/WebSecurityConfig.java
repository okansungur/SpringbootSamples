package com.example.tmp.monopro.security;


import com.example.tmp.monopro.utility.Roles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public HttpFirewall defaultHttpFirewall() {
        return new DefaultHttpFirewall();
    }


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/azspace/**","/authenticate", "/showRegistration","/saveuser","/css/**", "/", "/index.jsp", "/registerUser", "/register",

                        "/login/register", "/login","/logout",  "/index", "/error", "/error.jsp")
                .permitAll().antMatchers("/status",  "/status/*",
                 "/main/*").hasAnyAuthority(""+Roles.ROLE_USER, ""+ Roles.ROLE_ADMIN)
                .antMatchers(HttpMethod.GET, "/encyrpt/**").hasAuthority(""+Roles.ROLE_ADMIN)
                .antMatchers(HttpMethod.GET, "/user/**").hasAuthority(""+Roles.ROLE_ADMIN)
                .antMatchers(HttpMethod.GET, "/updateUser/**").hasAuthority(""+Roles.ROLE_ADMIN)

                .anyRequest().authenticated()

                .and().csrf().disable()
                .logout()
                .logoutSuccessUrl("/");

    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {

        return super.authenticationManagerBean();
    }


}
