package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
//	@GetMapping	
//	public List<UserEntity> getAllUsersByStatus(@RequestParam("active") Boolean active){
//		List<UserEntity> users = userRepo.getAllUsersByActiveStatus(active);
//		return users;
//	}
	
	@DeleteMapping
	public boolean removeUser(@RequestParam("userid") int userid) {
		Optional<UserEntity> user = userRepo.findById(userid);
		if(user.isPresent()) {
			userRepo.deleteById(userid);
			return true;
		} else {
			return false;
		}
	}
	
	@PutMapping
	public UserEntity updateUser(UserEntity user) {
		userRepo.save(user);
		return user;
	}
}
