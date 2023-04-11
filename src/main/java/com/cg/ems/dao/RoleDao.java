package com.cg.ems.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.ems.entity.Role;

@Repository
public interface RoleDao extends CrudRepository<Role, String> {

	Role save(Role role);

	
}
