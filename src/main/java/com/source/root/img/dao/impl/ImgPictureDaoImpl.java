package com.source.root.img.dao.impl;

import org.springframework.stereotype.Repository;

import com.source.root.framework.template.dao.BaseDaoImpl;
import com.source.root.img.dao.ImgPictureDao;
import com.source.root.img.entity.ImgPicture;

@Repository("imgPictureDao")
public class ImgPictureDaoImpl extends BaseDaoImpl<ImgPicture,java.lang.Integer> implements ImgPictureDao {

	// concstructor

	public ImgPictureDaoImpl() {
		super(ImgPicture.class);
	}

}
