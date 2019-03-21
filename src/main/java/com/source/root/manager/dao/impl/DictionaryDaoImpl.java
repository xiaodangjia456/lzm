package com.source.root.manager.dao.impl;

import org.springframework.stereotype.Repository;

import com.source.root.framework.template.dao.BaseDaoImpl;
import com.source.root.manager.dao.DictionaryDao;
import com.source.root.manager.entity.Dictionary;

@Repository("dictionaryDao")
public class DictionaryDaoImpl extends BaseDaoImpl<Dictionary,java.lang.Integer> implements DictionaryDao {

	// concstructor

	public DictionaryDaoImpl() {
		super(Dictionary.class);
	}

}
