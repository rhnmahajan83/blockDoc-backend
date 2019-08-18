package com.blockdock.Interface;

import java.util.List;

import com.deswaef.spring.examples.datajpa.user.model.User;

public interface UserInterface {
	
	 public List<User> getAllUsers();
	 public Boolean validateUser(String email, String password);
	 public Boolean registerUser(User user);
}
