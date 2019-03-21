package com.source.root.img.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.source.root.framework.template.dao.IBaseDao;
import com.source.root.framework.template.service.BaseServiceImpl;
import com.source.root.img.dao.ImgPictureDao;
import com.source.root.img.entity.ImgPicture;
import com.source.root.img.service.ImgPictureService;

@Service("imgpictureService")
public class ImgPictureServiceImpl extends BaseServiceImpl<ImgPicture,java.lang.Integer> implements ImgPictureService{

	@Autowired
	private ImgPictureDao imgpictureDao;

	@Override
	protected IBaseDao<?, ?> getBaseDao() {
		// TODO Auto-generated method stub
		return imgpictureDao;
	}
}

