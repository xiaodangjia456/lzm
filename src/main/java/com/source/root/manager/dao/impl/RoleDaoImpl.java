package com.source.root.manager.dao.impl;

import org.springframework.stereotype.Repository;

import com.source.root.framework.template.dao.BaseDaoImpl;
import com.source.root.manager.dao.RoleDao;
import com.source.root.manager.entity.Role;

@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role,java.lang.Integer> implements RoleDao {

	// concstructor

	public RoleDaoImpl() {
		super(Role.class);
	}

}
