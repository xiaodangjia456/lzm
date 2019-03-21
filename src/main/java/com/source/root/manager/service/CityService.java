package com.source.root.manager.service;

import java.util.List;

import com.source.root.framework.template.service.IBaseService;
import com.source.root.manager.entity.City;

public interface CityService extends IBaseService<City, java.lang.Integer> {

	public List<City> getListCityByName(String name);
}
