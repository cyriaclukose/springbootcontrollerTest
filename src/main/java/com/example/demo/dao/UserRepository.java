package com.example.demo.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public class UserRepository {
	
	
	private static Map<Integer, User> map; 
	
	
	
	  static
	    { 
	        map = new HashMap<>(); 
	        map.put(1, new User(1,"john","luke")); 
	        map.put(2, new User(1,"james","franc")); 
	        map.put(3, new User(1,"louis","lane")); 
	    } 

	public User getUserById(Integer id) {
		
		return map.get(id);
	}

	public User saveUser(User user) {
		
		map.put(user.getId(), user);
		return user;
	}

}
