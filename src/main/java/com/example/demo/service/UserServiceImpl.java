package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository)
	{
		
		this.userRepository=userRepository;
	}

	@Override
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		return userRepository.getUserById(id);
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.saveUser(user);
	}

}
