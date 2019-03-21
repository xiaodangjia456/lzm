package com.source.root.manager.dao.impl;

import org.springframework.stereotype.Repository;

import com.source.root.framework.template.dao.BaseDaoImpl;
import com.source.root.manager.dao.SiteUserDao;
import com.source.root.manager.entity.SiteUser;

@Repository("siteUserDao")
public class SiteUserDaoImpl extends BaseDaoImpl<SiteUser,java.lang.Integer> implements SiteUserDao {

	// concstructor

	public SiteUserDaoImpl() {
		super(SiteUser.class);
	}

}
