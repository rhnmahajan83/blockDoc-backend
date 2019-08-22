package com.blockdock.datajpa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.blockdock.datajpa.user.model.User;
import com.blockdock.datajpa.user.service.UserService;
import com.deswaef.spring.examples.datajpa.util.Constants;

@RestController
@RequestMapping("/api")
public class RestApiController {
	public static String uploadDirectory = System.getProperty("user.dir")+"/uploads";
	@Autowired
	UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String validateUser(@RequestBody User user) {
		if(userService.validateUser(user.getEmail(), user.getPassword())) {
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
	

	
	
	@RequestMapping("/uploadFile")
	public String Upload(Model model, @RequestParam("files") MultipartFile[] files) {
		StringBuilder fileNames = new StringBuilder();
		for(MultipartFile file : files) {
			Path filenameAndpath = Paths.get(uploadDirectory, file.getOriginalFilename());
			fileNames.append(file.getOriginalFilename()+" ");
			try {
				Files.write(filenameAndpath, file.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ("{\"status\" : \"Successfully uploaded files\"} " + fileNames.toString());
	}
}
