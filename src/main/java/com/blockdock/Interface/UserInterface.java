package com.blockdock.Interface;

import java.util.List;

import com.deswaef.spring.examples.datajpa.user.model.User;

public interface UserInterface {
	
	 public List<User> getAllUsers();
	 public String validateUser(String email, String password);
	 public String registerUser(User user);
}
