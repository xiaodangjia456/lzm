package com.source.root.manager.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.source.root.framework.comm.pager.Query;
import com.source.root.framework.template.dao.BaseDaoImpl;
import com.source.root.manager.dao.ResourceDao;
import com.source.root.manager.entity.Resource;

@Repository("resourceDao")
@SuppressWarnings({ "deprecation","unchecked" })
public class ResourceDaoImpl extends BaseDaoImpl<Resource,java.lang.Integer> implements ResourceDao {

	// concstructor

	public ResourceDaoImpl() {
		super(Resource.class);
	}

	public List<Resource> findByRoleId(Query query) {
		List<Resource> list = new ArrayList<Resource>();
		try {
			list = this.getSqlMapClientTemplate().getSqlMapClient().queryForList("Resource.findByRoleId", query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
