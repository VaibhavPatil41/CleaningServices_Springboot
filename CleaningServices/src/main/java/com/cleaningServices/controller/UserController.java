package com.cleaningServices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cleaningServices.entities.Dummyuser;
import com.cleaningServices.entities.Login;
import com.cleaningServices.entities.Role;
import com.cleaningServices.entities.User;
import com.cleaningServices.services.LoginService;
import com.cleaningServices.services.Role_Service;
import com.cleaningServices.services.UserService;

@RestController
public class UserController {
	 @Autowired
	    LoginService lservice;
	 @Autowired
		UserService uservice;
	 @Autowired
	 	Role_Service rl;
	 
	@PostMapping("/checkLogin")
    public String checkLogin(@RequestParam String uname, @RequestParam String pass)
    {
    	
    	Login L=lservice.getLoginByUsername(uname);
    	if(L.getPassword().equals(pass))
    	{
    		return "Login Successful";
    	}
    	else
    		return "Invalid Credentials";
    	
    	//User logged=uservice.getUserByLoginId(u.getLoginid());
//    	System.out.println(logged);
    	//return logged;
    }
	
	@PostMapping("/userRegister")
	public User registerCustomer(@RequestBody Dummyuser cr)
	{
    	User a=null;
    	Role r=rl.getRole(cr.getRole());
    	Login c=lservice.saveLogin(new Login(cr.getUsername(),cr.getPassword(),r));
    	
    		a=uservice.saveUser(new User(c,cr.getName(),cr.getEmail(),cr.getContactno(),cr.getAddress(),cr.getDob()));
    	
    	/*else if(cr.getRole()==2)
    	{
    		a=uservice.saveUser(new User(cr.getName(),cr.getContactno(),cr.getEmail(),r,c,cr.getShop_name()));
    	}
    	else if(cr.getRole()==3)
    	{
    		a=uservice.saveUser(new User(cr.getName(),cr.getLast_name(),cr.getContactno(),cr.getEmail(),r,c);
    	}*/
		System.out.println(cr.getName()+""+cr.getContactno());
	    return a;
	    
	}
}
