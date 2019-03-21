package com.source.root.manager.model.resource;

import java.util.List;

import com.source.root.manager.entity.Resource;

public class Level0 {

	private Resource level0;
	private String check;
	private List<Level1> level1;

	public Resource getLevel0() {
		return level0;
	}

	public void setLevel0(Resource level0) {
		this.level0 = level0;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public List<Level1> getLevel1() {
		return level1;
	}

	public void setLevel1(List<Level1> level1) {
		this.level1 = level1;
	}

}
