package com.source.root.img.dao.impl;

import org.springframework.stereotype.Repository;

import com.source.root.framework.template.dao.BaseDaoImpl;
import com.source.root.img.dao.ImgSporeDao;
import com.source.root.img.entity.ImgSpore;

@Repository("imgSporeDao")
public class ImgSporeDaoImpl extends BaseDaoImpl<ImgSpore,java.lang.Integer> implements ImgSporeDao {

	// concstructor

	public ImgSporeDaoImpl() {
		super(ImgSpore.class);
	}

}
