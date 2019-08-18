package com.blockdock.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blockdock.datajpa.user.model.User;
import com.blockdock.datajpa.user.service.UserService;

@RestController
@RequestMapping("/api")
public class RestApiController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String validateUser(@RequestBody User user) {
		String responseMessage = userService.validateUser(user.getEmail(), user.getPassword());
		return responseMessage;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(@RequestBody User user) {
		String responseMessage = userService.registerUser(user);
		return responseMessage;
	}
}
