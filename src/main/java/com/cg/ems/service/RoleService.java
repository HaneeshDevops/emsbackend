package com.cg.ems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ems.dao.RoleDao;
import com.cg.ems.entity.Role;

@Service
public class RoleService {
	
	@Autowired
	private RoleDao roleDao;
   
	public Role createNewRole(Role role) {
		return roleDao.save(role);
		
	}
}
