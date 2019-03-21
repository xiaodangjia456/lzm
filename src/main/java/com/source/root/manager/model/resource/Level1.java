package com.source.root.manager.model.resource;

import java.util.List;

import com.source.root.manager.entity.Resource;

public class Level1 {
	private Resource level1;
	private String check;
	private List<Level2> level2;

	public Resource getLevel1() {
		return level1;
	}

	public void setLevel1(Resource level1) {
		this.level1 = level1;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public List<Level2> getLevel2() {
		return level2;
	}

	public void setLevel2(List<Level2> level2) {
		this.level2 = level2;
	}

}
