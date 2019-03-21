package com.source.root.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.source.root.framework.template.dao.IBaseDao;
import com.source.root.framework.template.service.BaseServiceImpl;
import com.source.root.manager.dao.ChooseauthoritytypeDao;
import com.source.root.manager.entity.Chooseauthoritytype;
import com.source.root.manager.service.ChooseauthoritytypeService;

@Service("chooseauthoritytypeService")
public class ChooseauthoritytypeServiceImpl extends BaseServiceImpl<Chooseauthoritytype,java.lang.Long> implements ChooseauthoritytypeService{

	@Autowired
	private ChooseauthoritytypeDao chooseauthoritytypeDao;

	@SuppressWarnings("rawtypes")
	@Override
	protected IBaseDao getBaseDao() {
		// TODO Auto-generated method stub
		return chooseauthoritytypeDao;
	}
}

