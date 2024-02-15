package com.cleaningServices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cleaningServices.Dummy.DummyServiceProvider;
import com.cleaningServices.Dummy.Dummyuser;
import com.cleaningServices.Dummy.LoginRequest;
import com.cleaningServices.entities.Login;
import com.cleaningServices.entities.Role;
import com.cleaningServices.entities.ServiceProvider;
import com.cleaningServices.entities.User;
import com.cleaningServices.services.LoginService;
import com.cleaningServices.services.Role_Service;
import com.cleaningServices.services.ServiceProviderService;
import com.cleaningServices.services.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	 @Autowired
	    LoginService lservice;
	 @Autowired
		UserService uservice;
	 @Autowired
		ServiceProviderService spservice;
	 @Autowired
	 	Role_Service rl;
	 
	 
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
	
	@PostMapping("/spRegister")
	public ServiceProvider registerServiceProvider(@RequestBody DummyServiceProvider dr)
	{
		ServiceProvider sp=null;
    	Role r=rl.getRole(dr.getRole_id());
    	Login c=lservice.saveLogin(new Login(dr.getUsername(),dr.getPassword(),r));
    	
    	System.out.println("Email : "+dr.getEmail() + "Role_id:"+dr.getRole_id());
    	sp=spservice.saveSP(new ServiceProvider(c,dr.getName(),dr.getEmail(),dr.getContactno(),dr.getAddress(),dr.getLicense_id()));
    	
		//System.out.println(dr.getName()+""+dr.getContactno());
	    return sp;
	}
}
