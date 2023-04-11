package com.cg.ems.service;

import java.util.HashSet;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.ems.dao.RoleDao;
import com.cg.ems.dao.UserDao;
import com.cg.ems.entity.Role;
import com.cg.ems.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleDao roleDao;

	public User registerNewUser(User user) throws Exception {

		User local = this.userDao.findByUserName(user.getUserName());
		if (local != null) {
			System.out.println("User already exists");
			throw new Exception("user already present");
		} else {
			Role role = roleDao.findById("User").get();
			Set<Role> roles = new HashSet<>();
			roles.add(role);
			user.setRole(roles);
			user.setUserPassword(getEncodedPassword(user.getUserPassword()));
			return userDao.save(user);
		}
	}

	public void initRolesAndUser() {
		Role adminRole = new Role();
		adminRole.setRoleName("Admin");
		adminRole.setRoleDescription("Admin role");
		roleDao.save(adminRole);

		Role userRole = new Role();
		userRole.setRoleName("User");
		userRole.setRoleDescription("Default role for newly created record");
		roleDao.save(userRole);

		User adminUser = new User();
		adminUser.setUserFirstName("admin");
		adminUser.setUserLastName("admin");
		adminUser.setUserName("admin123");
		adminUser.setUserPassword(getEncodedPassword("admin@pass"));
		adminUser.setMobileNumber(7992006277L);
		Set<Role> adminRoles = new HashSet<>();
		adminRoles.add(adminRole);
		adminUser.setRole(adminRoles);
		userDao.save(adminUser);

		//
		// User user=new User();
		// user.setUserFirstName("raj");
		// user.setUserLastName("sharma");
		// user.setUserName("raj123");
		// user.setUserPassword(getEncodedPassword("raj@pass"));
		// Set<Role> userRoles = new HashSet<>();
		// userRoles.add(userRole);
		// user.setRole(userRoles);
		// userDao.save(user);
		//

	}

	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}

	public User getUserByName(String username) {
		return userDao.findByUserName(username);
	}
	
	public User updateUser(String username, User user) throws Exception {
	    User existingUser = userDao.findByUserName(username);
	    if (existingUser == null) {
	        System.out.println("User not found");
	        throw new Exception("user not found");
	    }
	    existingUser.setUserFirstName(user.getUserFirstName());
	    existingUser.setUserLastName(user.getUserLastName());
	    //existingUser.setEmail(user.getEmail());
	    existingUser.setMobileNumber(user.getMobileNumber());
	    //existingUser.setAddress(user.getAddress());
	   // existingUser.setDateOfBirth(user.getDateOfBirth());
	   // existingUser.setGender(user.getGender());
	   // existingUser.setAbout(user.getAbout());
	    return userDao.save(existingUser);
	}

}
