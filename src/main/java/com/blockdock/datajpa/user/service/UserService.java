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



    public String validateUser(String email, String password) {
    	User emailUser = userRepository.findByEmail(email);
    	
    	String response = null;
    	
    	if(emailUser != null) {
    		if((emailUser.getEmail().equals(email) && emailUser.getPassword().equals(password))) {
        		response = emailUser.getName();
        	}
    	} else {
    		response = "0";
    	}
		return response;
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

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
