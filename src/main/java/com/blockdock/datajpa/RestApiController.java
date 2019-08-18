package com.blockdock.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD:src/main/java/com/deswaef/spring/examples/datajpa/RestApiController.java
import com.deswaef.spring.examples.datajpa.user.model.User;
import com.deswaef.spring.examples.datajpa.user.service.UserService;
import com.deswaef.spring.examples.datajpa.util.Constants;
=======
import com.blockdock.datajpa.user.model.User;
import com.blockdock.datajpa.user.service.UserService;
>>>>>>> e172a6797dc4618fee2c3dd32588455f7f979f61:src/main/java/com/blockdock/datajpa/RestApiController.java

@RestController
@RequestMapping("/api")
public class RestApiController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String validateUser(@RequestBody User user) {
		if(userService.validateUser(user.getEmail(), user.getPassword()) != null) {
			return Constants.SUCCESSFUL_LOGIN_STATUS;
		}else{
			return Constants.FAILED_LOGIN_STATUS;
		}
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(@RequestBody User user) {	
		if(userService.getUserByEmail(user.getEmail())) {
			return Constants.USER_ALREADY_REGISTERD;
		}
		if(userService.registerUser(user) != null && user !=null) {
			return Constants.SUCCESSFUL_REGISTER_STATUS;
		}else{
			return Constants.FAILED_REGISTER_STATUS;
		}
	}
}
