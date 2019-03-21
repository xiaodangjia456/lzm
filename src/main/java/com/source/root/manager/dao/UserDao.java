package com.source.root.manager.dao;

import java.util.List;

import com.source.root.framework.comm.pager.Query;
import com.source.root.framework.template.dao.IBaseDao;
import com.source.root.manager.entity.User;

public interface UserDao extends IBaseDao<User,java.lang.Integer>{

	List<User> getListUserByRole(Query query);

}
