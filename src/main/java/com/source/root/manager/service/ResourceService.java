package com.source.root.manager.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.source.root.framework.comm.pager.Query;
import com.source.root.framework.template.service.IBaseService;
import com.source.root.manager.entity.Resource;
import com.source.root.manager.model.menu.LeftMenu1Model;

public interface ResourceService extends IBaseService<Resource,java.lang.Integer>{

	List<LeftMenu1Model> getLeftMenu(HttpServletRequest request);
	
	List<Resource> findByRoleId(Query query);
}

