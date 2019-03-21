package com.source.root.site.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.source.root.framework.comm.pager.Query;
import com.source.root.framework.template.dao.IBaseDao;
import com.source.root.framework.template.service.BaseServiceImpl;
import com.source.root.site.dao.SiteDao;
import com.source.root.site.entity.Site;
import com.source.root.site.service.SiteService;

@Service("siteService")
public class SiteServiceImpl extends BaseServiceImpl<Site,java.lang.Integer> implements SiteService{

	@Autowired
	private SiteDao siteDao;

	@Override
	protected IBaseDao<?,?> getBaseDao() {
		return siteDao;
	}

	@Override
	public List<Site> findAllByUserId(Query query) {
		return siteDao.findAllByUserId(query);
	}
}

