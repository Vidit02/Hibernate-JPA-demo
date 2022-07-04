package com.controller;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.UserEntity;
import com.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository userRepo;
	
	@PostMapping
	public UserEntity saveUser(UserEntity user) {
		userRepo.save(user);
		return user;
	}
	
	@GetMapping
	public List<UserEntity> getAllUsers(){
		List<UserEntity> users = userRepo.findAll();
		return users;
	}
}
