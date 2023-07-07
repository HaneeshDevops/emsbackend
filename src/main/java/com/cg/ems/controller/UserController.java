package com.cg.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.entity.User;
import com.cg.ems.service.UserService;

import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;

@CrossOrigin(origins = "http://frontend-container:4200")
@RestController

//@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/registerNewUser")
	public User registerNewUser(@RequestBody User user) {
		try {
			return userService.registerNewUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@GetMapping("/getUserByName/{username}")
	public User getUserByName(@PathVariable String username) {
		return userService.getUserByName(username);
	}

	@PostConstruct
	public void initRolesAndUsers() {
		userService.initRolesAndUser();
	}

	@GetMapping({ "/forAdmin" })
	@PreAuthorize("hasRole('Admin')")
	public String forAdmin() {
		return "This URL is only accessible to admin";
	}

	@GetMapping({ "/forUser" })
	@PreAuthorize("hasRole('User')")
	public String forUser() {
		return "This URL is only accessible to the user";
	}

	@PutMapping("/update/{username}")
	public ResponseEntity<User> updateUser(@PathVariable("username") String username, @RequestBody User user)
			throws Exception {
		User updatedUser = userService.updateUser(username, user);
		return ResponseEntity.ok().body(updatedUser);
	}

}
