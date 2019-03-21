package com.source.root.manager.dao.impl;

import org.springframework.stereotype.Repository;

import com.source.root.framework.template.dao.BaseDaoImpl;
import com.source.root.manager.dao.CityDao;
import com.source.root.manager.entity.City;

@Repository("cityDao")
public class CityDaoImpl extends BaseDaoImpl<City,java.lang.Integer> implements CityDao {

	// concstructor

	public CityDaoImpl() {
		super(City.class);
	}

}
