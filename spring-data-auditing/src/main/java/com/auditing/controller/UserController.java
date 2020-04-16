package com.auditing.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auditing.model.User;
import com.auditing.service.UserService;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/userApi")
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;

	@PostMapping("/users")
	public ResponseEntity<Map<String, String>> createUser(@Valid @RequestBody User user) {
		Map<String, String> response = new HashMap<>();
		try {
		userService.create(user);
		}catch (Exception e) {
			logger.error("Exception occured while saving "+ e);
			
		}
		response.put("status", "Event added successfully");
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
