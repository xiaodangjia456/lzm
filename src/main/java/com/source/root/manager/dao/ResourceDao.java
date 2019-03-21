package com.source.root.manager.dao;

import java.util.List;

import com.source.root.framework.comm.pager.Query;
import com.source.root.framework.template.dao.IBaseDao;
import com.source.root.manager.entity.Resource;

public interface ResourceDao extends IBaseDao<Resource,java.lang.Integer>{

	List<Resource> findByRoleId(Query query);

}
