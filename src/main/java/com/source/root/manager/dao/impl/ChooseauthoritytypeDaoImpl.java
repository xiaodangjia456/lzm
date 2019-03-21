package com.source.root.manager.dao.impl;

import org.springframework.stereotype.Repository;

import com.source.root.framework.template.dao.BaseDaoImpl;
import com.source.root.manager.dao.ChooseauthoritytypeDao;
import com.source.root.manager.entity.Chooseauthoritytype;

@Repository("chooseauthoritytypeDao")
public class ChooseauthoritytypeDaoImpl extends BaseDaoImpl<Chooseauthoritytype,java.lang.Long> implements ChooseauthoritytypeDao {

	// concstructor

	public ChooseauthoritytypeDaoImpl() {
		super(Chooseauthoritytype.class);
	}

}
