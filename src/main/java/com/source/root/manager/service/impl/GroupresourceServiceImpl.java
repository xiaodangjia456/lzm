package com.source.root.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.source.root.framework.template.dao.IBaseDao;
import com.source.root.framework.template.service.BaseServiceImpl;
import com.source.root.manager.dao.GroupresourceDao;
import com.source.root.manager.entity.Groupresource;
import com.source.root.manager.service.GroupresourceService;

@Service("groupresourceService")
public class GroupresourceServiceImpl extends BaseServiceImpl<Groupresource,java.lang.Long> implements GroupresourceService{

	@Autowired
	private GroupresourceDao groupresourceDao;

	@SuppressWarnings("rawtypes")
	@Override
	protected IBaseDao getBaseDao() {
		// TODO Auto-generated method stub
		return groupresourceDao;
	}
}

