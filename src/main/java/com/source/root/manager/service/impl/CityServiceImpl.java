package com.source.root.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.source.root.framework.comm.pager.Query;
import com.source.root.framework.template.dao.IBaseDao;
import com.source.root.framework.template.service.BaseServiceImpl;
import com.source.root.manager.dao.CityDao;
import com.source.root.manager.entity.City;
import com.source.root.manager.service.CityService;

@Service("cityService")
public class CityServiceImpl extends BaseServiceImpl<City, java.lang.Integer> implements CityService {

	@Autowired
	private CityDao cityDao;

	@Override
	protected IBaseDao<?,?> getBaseDao() {
		// TODO Auto-generated method stub
		return cityDao;
	}

	public List<City> getListCityByName(String name) {
		City city = new City();
		Query query = new Query();
		query.addAndCondition("name", "'" + name + "'");
		city = cityDao.getByQuery(query);

		if (city != null) {
			Query pq = new Query();
			pq.addAndCondition("parent_id", city.getId().toString());
			List<City> list = cityDao.findAll(pq);
			return list;
		}else{
			return null;
		}
	}
}
