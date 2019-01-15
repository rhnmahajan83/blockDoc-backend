package com.deswaef.spring.examples.datajpa;


import java.awt.PageAttributes.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.deswaef.spring.examples.datajpa.user.model.User;
import com.deswaef.spring.examples.datajpa.user.service.UserService;

@RestController
@RequestMapping("/api")
public class RestApiController {

	@Autowired
	UserService userService;
	
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String validateUser(String email, String password) {
        String responseMessage = userService.validateUser(email, password);
    	return responseMessage;
    }
    
    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String registerUser(User user) {
        String responseMessage = userService.registerUser(user);
    	return responseMessage;
    }
}

