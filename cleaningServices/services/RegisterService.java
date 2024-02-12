package com.cleaningServices.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.cleaningServices.entities.Register;
import com.cleaningServices.repository.RegisterRepository;


public class RegisterService {
		
	@Autowired
	RegisterRepository rrepo;
	public Register save(Register rs) {
		
		return rrepo.save(rs);
	}

}
