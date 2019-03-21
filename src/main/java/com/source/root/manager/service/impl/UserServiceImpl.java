package com.source.root.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.source.root.framework.comm.pager.Query;
import com.source.root.framework.template.dao.IBaseDao;
import com.source.root.framework.template.service.BaseServiceImpl;
import com.source.root.manager.dao.UserDao;
import com.source.root.manager.entity.User;
import com.source.root.manager.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User, java.lang.Integer> implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	protected IBaseDao<?,?> getBaseDao() {
		// TODO Auto-generated method stub
		return userDao;
	}

	public List<User> getListUserByRole(Query query) {
		return userDao.getListUserByRole(query);
	}
}
