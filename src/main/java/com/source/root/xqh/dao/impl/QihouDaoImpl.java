package com.source.root.xqh.dao.impl;

import org.springframework.stereotype.Repository;

import com.source.root.framework.template.dao.BaseDaoImpl;
import com.source.root.xqh.dao.QihouDao;
import com.source.root.xqh.entity.Qihou;

@Repository("qihouDao")
public class QihouDaoImpl extends BaseDaoImpl<Qihou,java.lang.Integer> implements QihouDao {

	// concstructor

	public QihouDaoImpl() {
		super(Qihou.class);
	}

}
