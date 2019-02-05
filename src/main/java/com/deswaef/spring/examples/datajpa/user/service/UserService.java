package com.deswaef.spring.examples.datajpa.user.service;

import com.blockdock.Interface.UserInterface;
import com.deswaef.spring.examples.datajpa.user.model.User;
import com.deswaef.spring.examples.datajpa.user.repository.UserRepository;
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

    public String validateUser(String email, String password) {
    	String responseMessage = null;	
    	User user = userRepository.findByEmailAndPassword(email, password);
    	String userEmail = user.getEmail().trim();
    	String userPassword = user.getPassword().trim();
    	
//    	String us = "rhnmahajan83@gmail.com";
//    	String ps = "blockdock123$";
//    	String dbn = "rhnmahajan83@gmail.com";
//    	String dbp = "blockdock123$";
    	
    	if(userEmail.equals(email) && userPassword.equals(password)) {
    		responseMessage = user.getName();
    	}else {
    		responseMessage = "0";
    	}
    	
    	return responseMessage;
    }

	@Override
	public String registerUser(User user) {
		String responseMessage = null;
		
		userRepository.save(user);
		
		responseMessage = "1";
		return responseMessage;
	}
    
    
}
