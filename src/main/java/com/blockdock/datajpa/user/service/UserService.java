package com.blockdock.datajpa.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blockdock.Interface.UserInterface;
import com.blockdock.datajpa.user.model.File;
import com.blockdock.datajpa.user.model.User;
import com.blockdock.datajpa.user.repository.BaseRepository;
import com.blockdock.datajpa.user.repository.UserRepository;


@Service
@Transactional
public class UserService implements UserInterface{

    @Autowired
    private UserRepository userRepository;

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
	}

    @Override
	public Boolean registerUser(User user) {
		if(userRepository.save(user) != null) {
			return true;
		}
		return false;
	}
	
    @Override
	public User getUserByEmail(String email) {	
    	User user = userRepository.findByEmail(email);
		if(user != null) {
			return user;
		}
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(Long id) {
		User user = userRepository.findById(id);
		if(user != null) {
			return user;
		}
		return null;
	}

}
