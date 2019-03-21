package com.source.root.manager.dao.impl;

import org.springframework.stereotype.Repository;

import com.source.root.framework.template.dao.BaseDaoImpl;
import com.source.root.manager.dao.LogsDao;
import com.source.root.manager.entity.Logs;

@Repository("logsDao")
public class LogsDaoImpl extends BaseDaoImpl<Logs,java.lang.Integer> implements LogsDao {

	// concstructor

	public LogsDaoImpl() {
		super(Logs.class);
	}

}
