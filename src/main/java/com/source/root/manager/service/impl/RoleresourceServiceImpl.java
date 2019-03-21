package com.source.root.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.source.root.framework.template.dao.IBaseDao;
import com.source.root.framework.template.service.BaseServiceImpl;
import com.source.root.manager.dao.RoleresourceDao;
import com.source.root.manager.entity.Roleresource;
import com.source.root.manager.service.RoleresourceService;

@Service("roleresourceService")
public class RoleresourceServiceImpl extends BaseServiceImpl<Roleresource,java.lang.Integer> implements RoleresourceService{

	@Autowired
	private RoleresourceDao roleresourceDao;

	@Override
	protected IBaseDao<?,?> getBaseDao() {
		// TODO Auto-generated method stub
		return roleresourceDao;
	}
}

