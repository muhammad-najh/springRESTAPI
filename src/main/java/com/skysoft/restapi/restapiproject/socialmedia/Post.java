package com.skysoft.restapi.restapiproject.socialmedia;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post {

@Id
@GeneratedValue
 private int id;
 
 private String content;


 // forign key
 @ManyToOne(fetch = FetchType.LAZY)
  @JsonIgnore

 private User user;


    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post() {
    }

    public Post(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    @Override
	public String toString() {
		return "Post [id=" + id + ", description=" + content + "]";
	}
}
