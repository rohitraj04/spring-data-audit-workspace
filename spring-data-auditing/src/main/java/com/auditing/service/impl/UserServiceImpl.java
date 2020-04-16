package com.auditing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auditing.model.User;
import com.auditing.repository.UserRepository;
import com.auditing.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	@Override
	public User create(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

}
