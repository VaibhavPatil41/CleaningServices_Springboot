package com.cleaningServices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cleaningServices.entities.Login;
import com.cleaningServices.entities.User;
import com.cleaningServices.services.LoginService;
import com.cleaningServices.services.UserService;

@RestController
public class UserController {
	 @Autowired
	    LoginService lservice;
	 @Autowired
		UserService uservice;
	@PostMapping("/checkLogin")
    public User checkLogin(@RequestBody Login l)
    {
    	String uname=l.getUsername();
    	String pass=l.getPassword();

    	Login u=lservice.getLoginByUsername(uname, pass);
    	
    	User logged=uservice.getUserByLoginId(u.getLogin_id());
    	System.out.println(logged);
    	return logged;
    }
}
