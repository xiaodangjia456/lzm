package com.source.root.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.source.root.framework.template.dao.IBaseDao;
import com.source.root.framework.template.service.BaseServiceImpl;
import com.source.root.manager.dao.DictionaryDao;
import com.source.root.manager.entity.Dictionary;
import com.source.root.manager.service.DictionaryService;

@Service("dictionaryService")
public class DictionaryServiceImpl extends BaseServiceImpl<Dictionary,java.lang.Integer> implements DictionaryService{

	@Autowired
	private DictionaryDao dictionaryDao;

	@Override
	protected IBaseDao<?,?> getBaseDao() {
		// TODO Auto-generated method stub
		return dictionaryDao;
	}
}

