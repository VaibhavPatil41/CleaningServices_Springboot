package com.cleaningServices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cleaningServices.entities.Register;
import com.cleaningServices.services.RegisterService;

@RestController
public class RegisterController {
	
	
	@Autowired
	RegisterService rservice;
	
	@PostMapping("/savecontact")
	public Register save(@RequestBody Register rs)
	{
		return rservice.save(rs);
	}

}
