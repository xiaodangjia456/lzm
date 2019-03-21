package com.source.root.site.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.source.root.framework.template.dao.IBaseDao;
import com.source.root.framework.template.service.BaseServiceImpl;
import com.source.root.site.dao.DeviceDao;
import com.source.root.site.entity.Device;
import com.source.root.site.service.DeviceService;

@Service("deviceService")
public class DeviceServiceImpl extends BaseServiceImpl<Device,java.lang.Integer> implements DeviceService{

	@Autowired
	private DeviceDao deviceDao;

	@Override
	protected IBaseDao<?,?> getBaseDao() {
		// TODO Auto-generated method stub
		return deviceDao;
	}
}

