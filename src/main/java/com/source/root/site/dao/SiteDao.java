package com.source.root.site.dao;

import java.util.List;

import com.source.root.framework.comm.pager.Query;
import com.source.root.framework.template.dao.IBaseDao;
import com.source.root.site.entity.Site;

public interface SiteDao extends IBaseDao<Site,java.lang.Integer>{

	/**
	 * 根据用户ID获取站点信息
	 * @param userId
	 * @return
	 */
	List<Site> findAllByUserId(Query query);

}
