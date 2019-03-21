package com.source.root.img.dao.impl;

import org.springframework.stereotype.Repository;

import com.source.root.framework.template.dao.BaseDaoImpl;
import com.source.root.img.dao.ImgInsectDao;
import com.source.root.img.entity.ImgInsect;

@Repository("imgInsectDao")
public class ImgInsectDaoImpl extends BaseDaoImpl<ImgInsect,java.lang.Integer> implements ImgInsectDao {

	// concstructor

	public ImgInsectDaoImpl() {
		super(ImgInsect.class);
	}

}
