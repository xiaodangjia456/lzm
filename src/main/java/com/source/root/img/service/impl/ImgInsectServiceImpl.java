package com.source.root.img.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.source.root.framework.template.dao.IBaseDao;
import com.source.root.framework.template.service.BaseServiceImpl;
import com.source.root.img.dao.ImgInsectDao;
import com.source.root.img.entity.ImgInsect;
import com.source.root.img.service.ImgInsectService;

@Service("imginsectService")
public class ImgInsectServiceImpl extends BaseServiceImpl<ImgInsect,java.lang.Integer> implements ImgInsectService{

	@Autowired
	private ImgInsectDao imginsectDao;

	@Override
	protected IBaseDao<?, ?> getBaseDao() {
		// TODO Auto-generated method stub
		return imginsectDao;
	}
}

