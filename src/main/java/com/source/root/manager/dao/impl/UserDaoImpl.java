package com.source.root.manager.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.source.root.framework.comm.pager.Query;
import com.source.root.framework.template.dao.BaseDaoImpl;
import com.source.root.manager.dao.UserDao;
import com.source.root.manager.entity.User;

@Repository("userDao")
@SuppressWarnings({"deprecation","unchecked" })
public class UserDaoImpl extends BaseDaoImpl<User, java.lang.Integer> implements UserDao {

	// concstructor

	public UserDaoImpl() {
		super(User.class);
	}

	public List<User> getListUserByRole(Query query) {
		List<User> list = new ArrayList<User>();
		try {
			list = this.getSqlMapClientTemplate().getSqlMapClient().queryForList("User.getListUserByRole", query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
