package com.cleaningServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cleaningServices.entities.Login;


@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
    Login findByUsername(String username);
}
