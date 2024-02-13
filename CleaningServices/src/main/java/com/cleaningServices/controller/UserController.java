package com.cleaningServices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cleaningServices.entities.Dummyuser;
import com.cleaningServices.entities.Login;
import com.cleaningServices.entities.Role;
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
    	
    	User logged=uservice.getUserByLoginId(u.getLoginid());
    	System.out.println(logged);
    	return logged;
    }
	/*@PostMapping("/userRegister")
	public User registerCustomer(@RequestBody Dummyuser cr)
	{
    	User a=null;
    	
    	Login c=lservice.saveLogin(new Login(0, cr.getUsername(),cr.getPassword(), null, false));
    	
		a=uservice.saveUser(new User(cr.getName(),cr.getEmail(),cr.getContactno(),cr.getEmail(),c));
    	
	    return a;
	    
	}*/
}
