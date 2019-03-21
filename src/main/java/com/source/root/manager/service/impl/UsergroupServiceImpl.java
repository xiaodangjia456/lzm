package com.source.root.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.source.root.framework.template.dao.IBaseDao;
import com.source.root.framework.template.service.BaseServiceImpl;
import com.source.root.manager.dao.UsergroupDao;
import com.source.root.manager.entity.Usergroup;
import com.source.root.manager.service.UsergroupService;

@Service("usergroupService")
public class UsergroupServiceImpl extends BaseServiceImpl<Usergroup,java.lang.Long> implements UsergroupService{

	@Autowired
	private UsergroupDao usergroupDao;

	@SuppressWarnings("rawtypes")
	@Override
	protected IBaseDao getBaseDao() {
		// TODO Auto-generated method stub
		return usergroupDao;
	}
}

