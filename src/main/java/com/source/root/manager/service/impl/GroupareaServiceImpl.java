package com.source.root.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.source.root.framework.template.dao.IBaseDao;
import com.source.root.framework.template.service.BaseServiceImpl;
import com.source.root.manager.dao.GroupareaDao;
import com.source.root.manager.entity.Grouparea;
import com.source.root.manager.service.GroupareaService;

@Service("groupareaService")
public class GroupareaServiceImpl extends BaseServiceImpl<Grouparea,java.lang.Long> implements GroupareaService{

	@Autowired
	private GroupareaDao groupareaDao;

	@SuppressWarnings("rawtypes")
	@Override
	protected IBaseDao getBaseDao() {
		// TODO Auto-generated method stub
		return groupareaDao;
	}
}

