package com.source.root.site.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.source.root.framework.comm.pager.Query;
import com.source.root.framework.template.dao.BaseDaoImpl;
import com.source.root.site.dao.SiteDao;
import com.source.root.site.entity.Site;

@SuppressWarnings({ "deprecation", "unchecked" })
@Repository("siteDao")
public class SiteDaoImpl extends BaseDaoImpl<Site,java.lang.Integer> implements SiteDao {

	// concstructor

	public SiteDaoImpl() {
		super(Site.class);
	}

	@Override
	public List<Site> findAllByUserId(Query query) {
		List<Site> list = new ArrayList<Site>();
		try {
			list = getSqlMapClient().queryForList("Site.findAllByUserId", query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
