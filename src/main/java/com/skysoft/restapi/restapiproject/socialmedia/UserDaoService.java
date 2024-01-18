package com.skysoft.restapi.restapiproject.socialmedia;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class UserDaoService {

	 public static List<User>users = new ArrayList<User>();
	 private static int id =3;
	 static {
		 
		 users.add(new User(1, "hama", LocalDate.now().minusYears(25)));
		 users.add(new User(2, "karzan", LocalDate.now().minusYears(10)));
		 users.add(new User(3, "abdulla", LocalDate.now().minusYears(40)));
	 }
	
	 
	
	public List<User> findAll(){
		
		return users;
		
	}
	
	
	public User findUserByID(int id) {
		Predicate<? super User>pre=user-> user.getId()==id;
		
	    User user =  users.stream().filter(pre).findFirst().get();
	    
	    return user;
	}
	
	public void deleteByID(int id) {
		Predicate<? super User>pre=user-> user.getId()==id;
	    users.removeIf(pre);
	}
	
	public User addUser(User user) {
		user.setId(++id);
	   users.add(user);
	   return user;
	}
	
	
	

}
