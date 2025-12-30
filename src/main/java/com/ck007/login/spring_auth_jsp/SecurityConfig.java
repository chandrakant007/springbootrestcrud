package com.ck007.login.spring_auth_jsp;

import java.util.Collections;
import java.util.List;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ck007.login.spring_auth_jsp.UserRepository.UserRepository;
import com.ck007.login.spring_auth_jsp.model.User;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserRepository repo;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	System.out.println("configure111");
        auth.userDetailsService(username -> {
            User user = repo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))//compilation error SimpleGrantedAuthority undefined
            );
        });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	System.out.println("configure222");
        http .csrf().disable() //  .csrf().disable() //  
            .authorizeRequests()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/home", true) // 
                .permitAll()
            .and()
            .logout()
                .logoutSuccessUrl("/login?logout");
    }
}