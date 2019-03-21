package com.source.root.manager.dao.impl;

import org.springframework.stereotype.Repository;

import com.source.root.framework.template.dao.BaseDaoImpl;
import com.source.root.manager.dao.GroupresourceDao;
import com.source.root.manager.entity.Groupresource;

@Repository("groupresourceDao")
public class GroupresourceDaoImpl extends BaseDaoImpl<Groupresource,java.lang.Long> implements GroupresourceDao {

	// concstructor

	public GroupresourceDaoImpl() {
		super(Groupresource.class);
	}

}
