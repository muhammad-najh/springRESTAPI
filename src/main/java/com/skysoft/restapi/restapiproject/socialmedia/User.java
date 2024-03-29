package com.skysoft.restapi.restapiproject.socialmedia;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;


@Entity(name="user_details")
public class User {

@Id
@GeneratedValue
private Integer id;
@OneToMany(mappedBy = "user")
private List<Post> posts;

	public List<Post> getPosts() {
		return this.posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

@Size(min=2, message = "Name should have atleast 2 characters")
private String name;

@Past(message = "Birth Date should be in the past")
private LocalDate birthDay;


public User(Integer id, String name, LocalDate birthDay) {
	this.id = id;
	this.name = name;
	this.birthDay = birthDay;
}

	public User() {
	}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public LocalDate getBirthDay() {
	return birthDay;
}
public void setBirthDay(LocalDate birthDay) {
	this.birthDay = birthDay;
}

@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDay + "]";
}


}
