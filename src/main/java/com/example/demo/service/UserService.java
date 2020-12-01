package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {

	User getUserById(Integer id);

	User saveUser(User user);

}
