package com.source.root.manager.dao.impl;

import org.springframework.stereotype.Repository;

import com.source.root.framework.template.dao.BaseDaoImpl;
import com.source.root.manager.dao.GroupDao;
import com.source.root.manager.entity.Group;

@Repository("groupDao")
public class GroupDaoImpl extends BaseDaoImpl<Group,java.lang.Long> implements GroupDao {

	// concstructor

	public GroupDaoImpl() {
		super(Group.class);
	}

}
