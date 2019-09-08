package com.blockdock.Interface;

import java.util.List;

import com.blockdock.datajpa.user.model.User;

public interface UserInterface {
	
	 public List<User> getAllUsers();
	 public Boolean validateUser(String email, String password);
	 public Boolean registerUser(User user);
	 public User getUserByEmail(String email);
	 public User getUserById(Long id);
}
