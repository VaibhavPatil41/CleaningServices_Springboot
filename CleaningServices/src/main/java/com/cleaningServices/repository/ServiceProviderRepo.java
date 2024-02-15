package com.cleaningServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cleaningServices.entities.ServiceProvider;

@Repository
public interface ServiceProviderRepo extends JpaRepository<ServiceProvider , Integer> {

	@Query("select sp from ServiceProvider sp where login_id =:id")
	public ServiceProvider getSPByLoginId(int id);
}
