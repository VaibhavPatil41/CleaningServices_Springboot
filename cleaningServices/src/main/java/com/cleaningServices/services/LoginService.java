package com.cleaningServices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cleaningServices.entities.Login;
import com.cleaningServices.repository.Login_repo;

@Service
public class LoginService {

		@Autowired
		Login_repo lrepo;
		
		
		public Login saveLogin(Login u)
		{
			return lrepo.save(u);
		}
		
		public Login getLoginByUsername(String uname,String pass)
		{
			System.out.println(uname+" "+pass);
			
			 return lrepo.getUserByUsername(uname,pass);
		}
		
		/*public int getLoginByUsernamepass(String uname,String pass)
		{
			System.out.println(uname+" "+pass);
			
			 return lrepo.getUserByUsernamepass(uname,pass);
		}
		public Login getLoginByUserpass(String uname,String pass)
		{
			System.out.println(uname+" "+pass);
			
			 return lrepo.getUserByUserpass(uname,pass);
		}
		
		*/
	}


