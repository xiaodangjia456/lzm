package com.source.root.img.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.source.root.framework.template.dao.IBaseDao;
import com.source.root.framework.template.service.BaseServiceImpl;
import com.source.root.img.dao.ImgSporeDao;
import com.source.root.img.entity.ImgSpore;
import com.source.root.img.service.ImgSporeService;

@Service("imgsporeService")
public class ImgSporeServiceImpl extends BaseServiceImpl<ImgSpore,java.lang.Integer> implements ImgSporeService{

	@Autowired
	private ImgSporeDao imgsporeDao;

	@Override
	protected IBaseDao<?, ?> getBaseDao() {
		// TODO Auto-generated method stub
		return imgsporeDao;
	}
}

