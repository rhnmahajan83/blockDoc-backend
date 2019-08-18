package com.blockdock.datajpa.user.service;

import com.blockdock.Interface.UserInterface;
import com.blockdock.datajpa.user.model.User;
import com.blockdock.datajpa.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserService implements UserInterface{

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

<<<<<<< HEAD:src/main/java/com/deswaef/spring/examples/datajpa/user/service/UserService.java
    public Boolean validateUser(String email, String password) {
    	User user = userRepository.findByEmailAndPassword(email, password);
    	if(user != null) {
        	String userEmail = user.getEmail().trim();
        	String userPassword = user.getPassword().trim();
    		if(userEmail.equals(email) && userPassword.equals(password)) {
        		return true;
        	}else {
        		return false;
        	}
    	} else {
			return false;
		}
=======

    public String validateUser(String email, String password) {
    	String responseMessage = null;	
    	User user = userRepository.findByEmailAndPassword(email, password);
    	String userEmail = user.getEmail().trim();
    	String userPassword = user.getPassword().trim();
    	
    	if(userEmail.equals(email) && userPassword.equals(password)) {
    		responseMessage = user.getName();
    	}else {
    		responseMessage = "0";
    	}
    	
    	return responseMessage;
>>>>>>> e172a6797dc4618fee2c3dd32588455f7f979f61:src/main/java/com/blockdock/datajpa/user/service/UserService.java
    }

	@Override
	public Boolean registerUser(User user) {
		if(userRepository.save(user) != null) {
			return true;
		}
		return false;
	}
	
	public Boolean getUserByEmail(String email) {	
		if(userRepository.findByEmail(email) != null) {
			return true;
		}
		return false;
	}
    
    
}
