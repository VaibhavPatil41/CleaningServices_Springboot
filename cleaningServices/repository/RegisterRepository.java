package com.cleaningServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cleaningServices.entities.Register;

@Repository
public interface RegisterRepository extends JpaRepository<Register,Integer>
{
	
}
