package com.cleaningServices.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cleaningServices.entities.ServiceProvider;
import com.cleaningServices.repository.ServiceProviderRepo;

@Service
public class ServiceProviderService {
	@Autowired
	ServiceProviderRepo sprepo;
	
	public ServiceProvider saveSP(ServiceProvider u)
	{
		return sprepo.save(u);
	}
	
	public ServiceProvider getUserById(int id)
	{
		System.out.println(id);
		 Optional<ServiceProvider> or=sprepo.findById(id);
		 ServiceProvider s=null;
		 try
		 {
			 if(or!=null)
			 {
				 s=or.get();
			 }
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
			 
		 }
		 return s;
	}

	public ServiceProvider getUserByLoginId(int id) {
		return sprepo.getSPByLoginId(id);
	}
}
