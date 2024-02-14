package com.cleaningServices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cleaningServices.entities.Dummyuser;
import com.cleaningServices.entities.Login;
import com.cleaningServices.entities.LoginRequest;
import com.cleaningServices.entities.Role;
import com.cleaningServices.entities.User;
import com.cleaningServices.services.LoginService;
import com.cleaningServices.services.Role_Service;
import com.cleaningServices.services.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	 @Autowired
	    LoginService lservice;
	 @Autowired
		UserService uservice;
	 @Autowired
	 	Role_Service rl;
	 
//	 @ResponseBody
//	 @PostMapping("/checkLogin")
//	 
	 ///@RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
	 
	@PostMapping("/checkLogin")
    public int checkLogin(@RequestBody LoginRequest lr)
    {
		System.out.println(lr);
    	Login L=lservice.getLoginByUsername(lr.getUname());
    	
    	//return L;
    	if(L.getPassword().equals(lr.getPass()))
    	{
    		//return Role id of that user
    		Role r = L.getRole();
    		return r.getRole_id();
       	}
    	else
    	{
    		return -1;
    		//return "Invalid Credentials";
    	}
    	
    	//User logged=uservice.getUserByLoginId(u.getLoginid());
    	//return logged;
    }
	
	@PostMapping("/userRegister")
	public User registerCustomer(@RequestBody Dummyuser cr)
	{
    	User a=null;
    	Role r=rl.getRole(cr.getRole_id());
    	Login c=lservice.saveLogin(new Login(cr.getUsername(),cr.getPassword(),r));
    	
    	System.out.println("Email : "+cr.getEmail() + "Role_id:"+cr.getRole_id());
    	a=uservice.saveUser(new User(c,cr.getName(),cr.getEmail(),cr.getContactno(),cr.getAddress(),cr.getDob()));
    	
		System.out.println(cr.getName()+""+cr.getContactno());
	    return a;
	    
	}
}
