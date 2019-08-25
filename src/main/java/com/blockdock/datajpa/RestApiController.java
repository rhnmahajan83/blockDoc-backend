package com.blockdock.datajpa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.blockdock.datajpa.user.model.File;
import com.blockdock.datajpa.user.model.User;
import com.blockdock.datajpa.user.service.UserService;
import com.deswaef.spring.examples.datajpa.util.Constants;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api")
public class RestApiController {
	public static String uploadDirectory = System.getProperty("user.dir")+"/uploads";
	ObjectMapper objMapper = new ObjectMapper();
	@Autowired
	UserService userService;
	

	@CrossOrigin
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String validateUser(@RequestBody User user) {
		if(user== null) {
			return Constants.FAILED_LOGIN_STATUS;
		}
		if(userService.validateUser(user.getEmail(), user.getPassword())) {
			return Constants.SUCCESSFUL_LOGIN_STATUS;
		}else{
			return Constants.FAILED_LOGIN_STATUS;
		}
	}

	@CrossOrigin
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
	

	
	@CrossOrigin
	@RequestMapping(value= "/uploadFile", method= RequestMethod.POST, consumes= "multipart/form-data")
	public Object Upload(Model model, @RequestParam("files") MultipartFile[] files, @RequestParam("jsondata") String fileDetails ) {
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
		
		try {
			System.out.println(fileDetails);
			File file= objMapper.readValue(fileDetails, File.class);
			userService.add(file);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ("{\"status\" : \"Successfully uploaded files\"} " + fileNames.toString());
	}
	
	public JsonNode toJSON(String fileDetails) 
			  throws JsonParseException, IOException {
			    ObjectMapper mapper = new ObjectMapper();
			    JsonNode actualObj = mapper.readTree(fileDetails);
			    return actualObj;
			}
}

