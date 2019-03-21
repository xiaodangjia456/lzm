package com.source.root.manager.service;

import java.util.List;

import com.source.root.framework.comm.pager.Query;
import com.source.root.framework.template.service.IBaseService;
import com.source.root.manager.entity.User;

public interface UserService extends IBaseService<User, java.lang.Integer> {

	public List<User> getListUserByRole(Query query);
}
