package com.ck007.login.spring_auth_jsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

	@GetMapping("/login")
	public String loginPage() {
		System.out.println("login page comming");
	    return "login";
	}

    @GetMapping("/home")
    public String homePage() {
    	System.out.println("home page comming");
        return "home";
    }
}