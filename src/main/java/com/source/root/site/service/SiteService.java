package com.source.root.site.service;

import java.util.List;

import com.source.root.framework.comm.pager.Query;
import com.source.root.framework.template.service.IBaseService;
import com.source.root.site.entity.Site;

public interface SiteService extends IBaseService<Site,java.lang.Integer>{

	/**
	 * 根据用户ID获取站点信息
	 * @param userId
	 * @return
	 */
	List<Site> findAllByUserId(Query query);
}

