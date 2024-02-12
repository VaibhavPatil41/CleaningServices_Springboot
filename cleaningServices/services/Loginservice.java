package com.cleaningServices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cleaningServices.entities.Login;
import com.cleaningServices.repository.LoginRepository;

@Service
public class Loginservice {
	 @Autowired
	    private LoginRepository loginRepository;

	    public void save(Login login) {
	        loginRepository.save(login);
	    }

	    public Login findByUsername(String username) {
	        return loginRepository.findByUsername(username);
	    }

}
