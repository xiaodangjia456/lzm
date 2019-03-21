package com.source.root.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.source.root.framework.template.dao.IBaseDao;
import com.source.root.framework.template.service.BaseServiceImpl;
import com.source.root.manager.dao.LogsDao;
import com.source.root.manager.entity.Logs;
import com.source.root.manager.service.LogsService;

@Service("logsService")
public class LogsServiceImpl extends BaseServiceImpl<Logs,java.lang.Integer> implements LogsService{

	@Autowired
	private LogsDao logsDao;

	@Override
	protected IBaseDao<?,?> getBaseDao() {
		// TODO Auto-generated method stub
		return logsDao;
	}
}

