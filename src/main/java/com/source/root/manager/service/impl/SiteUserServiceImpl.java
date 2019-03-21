package com.source.root.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.source.root.framework.template.dao.IBaseDao;
import com.source.root.framework.template.service.BaseServiceImpl;
import com.source.root.manager.dao.SiteUserDao;
import com.source.root.manager.entity.SiteUser;
import com.source.root.manager.service.SiteUserService;

@Service("siteuserService")
public class SiteUserServiceImpl extends BaseServiceImpl<SiteUser,java.lang.Integer> implements SiteUserService{

	@Autowired
	private SiteUserDao siteuserDao;

	@Override
	protected IBaseDao<?, ?> getBaseDao() {
		// TODO Auto-generated method stub
		return siteuserDao;
	}
}

