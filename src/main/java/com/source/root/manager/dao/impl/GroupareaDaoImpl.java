package com.source.root.manager.dao.impl;

import org.springframework.stereotype.Repository;

import com.source.root.framework.template.dao.BaseDaoImpl;
import com.source.root.manager.dao.GroupareaDao;
import com.source.root.manager.entity.Grouparea;

@Repository("groupareaDao")
public class GroupareaDaoImpl extends BaseDaoImpl<Grouparea,java.lang.Long> implements GroupareaDao {

	// concstructor

	public GroupareaDaoImpl() {
		super(Grouparea.class);
	}

}
