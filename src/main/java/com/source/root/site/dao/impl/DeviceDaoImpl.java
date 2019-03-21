package com.source.root.site.dao.impl;

import org.springframework.stereotype.Repository;

import com.source.root.framework.template.dao.BaseDaoImpl;
import com.source.root.site.dao.DeviceDao;
import com.source.root.site.entity.Device;

@Repository("deviceDao")
public class DeviceDaoImpl extends BaseDaoImpl<Device,java.lang.Integer> implements DeviceDao {

	// concstructor

	public DeviceDaoImpl() {
		super(Device.class);
	}

}
