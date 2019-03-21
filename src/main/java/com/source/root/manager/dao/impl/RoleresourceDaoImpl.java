package com.source.root.manager.dao.impl;

import org.springframework.stereotype.Repository;

import com.source.root.framework.template.dao.BaseDaoImpl;
import com.source.root.manager.dao.RoleresourceDao;
import com.source.root.manager.entity.Roleresource;

@Repository("roleresourceDao")
public class RoleresourceDaoImpl extends BaseDaoImpl<Roleresource,java.lang.Integer> implements RoleresourceDao {

	// concstructor

	public RoleresourceDaoImpl() {
		super(Roleresource.class);
	}

}
