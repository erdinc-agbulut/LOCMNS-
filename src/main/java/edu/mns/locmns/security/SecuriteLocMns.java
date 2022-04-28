package edu.mns.locmns.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecuriteLocMns extends WebSecurityConfigurerAdapter {

    @Override
<<<<<<< HEAD
    protected  void configure(AuthenticationManagerBuilder auth) throws Exception{
=======
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
>>>>>>> origin/erdinc

    }
}
