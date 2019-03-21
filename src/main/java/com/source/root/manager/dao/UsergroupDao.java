package com.source.root.manager.dao;

import java.util.List;

import com.source.root.framework.comm.pager.Query;
import com.source.root.framework.template.dao.IBaseDao;
import com.source.root.manager.entity.Groupuser;
import com.source.root.manager.entity.Usergroup;

public interface UsergroupDao extends IBaseDao<Usergroup,java.lang.Long>{

	List<Groupuser> findUserAndGroup(Query _query);

}
