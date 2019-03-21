package com.source.root.manager.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.source.root.framework.comm.pager.Query;
import com.source.root.framework.template.dao.BaseDaoImpl;
import com.source.root.manager.dao.UsergroupDao;
import com.source.root.manager.entity.Groupuser;
import com.source.root.manager.entity.Usergroup;

@Repository("usergroupDao")
public class UsergroupDaoImpl extends BaseDaoImpl<Usergroup, java.lang.Long>
		implements UsergroupDao {

	// concstructor

	public UsergroupDaoImpl() {
		super(Usergroup.class);
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Groupuser> findUserAndGroup(Query _query) {
		List<Groupuser> list = new ArrayList<Groupuser>();
		try {
			list = this.getSqlMapClientTemplate().getSqlMapClient().queryForList("Usergroup.findUserAndGroup",_query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
