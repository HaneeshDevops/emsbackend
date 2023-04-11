package com.cg.ems.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.ems.entity.User;

@Repository
public interface UserDao extends CrudRepository<User, String>{

	User findByUserName(String username);
}
