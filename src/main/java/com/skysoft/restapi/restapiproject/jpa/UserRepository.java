package com.skysoft.restapi.restapiproject.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skysoft.restapi.restapiproject.socialmedia.User;

public interface UserRepository extends JpaRepository<User,Integer> {

    
} 
