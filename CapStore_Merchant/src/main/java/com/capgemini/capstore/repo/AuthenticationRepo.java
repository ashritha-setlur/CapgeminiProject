package com.capgemini.capstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.capstore.beans.Authentication;

public interface AuthenticationRepo extends JpaRepository<Authentication, Integer>{

}
