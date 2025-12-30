package com.ck007.login.spring_auth_jsp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ck007.login.spring_auth_jsp.UserRepository.UserRepository;
import com.ck007.login.spring_auth_jsp.model.User;

@SpringBootApplication
public class SpringAuthJspApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAuthJspApplication.class, args);
	}
	
	@Bean
	CommandLineRunner run(UserRepository repo) {
	    return args -> {
	        repo.save(new User("ck007", "{noop}pass123"));
	    };
	}

}
