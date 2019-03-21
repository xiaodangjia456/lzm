package com.source.root.xqh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.source.root.framework.template.dao.IBaseDao;
import com.source.root.framework.template.service.BaseServiceImpl;
import com.source.root.xqh.dao.QihouDao;
import com.source.root.xqh.entity.Qihou;
import com.source.root.xqh.service.QihouService;

@Service("qihouService")
public class QihouServiceImpl extends BaseServiceImpl<Qihou,java.lang.Integer> implements QihouService{

	@Autowired
	private QihouDao qihouDao;

	@Override
	protected IBaseDao<?, ?> getBaseDao() {
		// TODO Auto-generated method stub
		return qihouDao;
	}
}

