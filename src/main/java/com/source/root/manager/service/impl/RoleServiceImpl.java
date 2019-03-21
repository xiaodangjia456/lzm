package com.source.root.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.source.root.framework.template.dao.IBaseDao;
import com.source.root.framework.template.service.BaseServiceImpl;
import com.source.root.manager.dao.RoleDao;
import com.source.root.manager.entity.Role;
import com.source.root.manager.service.RoleService;

@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role,java.lang.Integer> implements RoleService{

	@Autowired
	private RoleDao roleDao;

	@Override
	protected IBaseDao<?,?> getBaseDao() {
		// TODO Auto-generated method stub
		return roleDao;
	}
}

