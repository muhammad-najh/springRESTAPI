package com.skysoft.restapi.restapiproject.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skysoft.restapi.restapiproject.socialmedia.Post;

public interface PostRepository extends JpaRepository<Post,Integer> {

    
} 
