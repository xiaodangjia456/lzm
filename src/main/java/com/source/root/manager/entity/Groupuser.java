package com.source.root.manager.entity;

public class Groupuser {

	private java.lang.Long userId;
	//
	private java.lang.Long groupId;
	//
	private java.lang.String userName;

	public java.lang.Long getUserId() {
		return userId;
	}

	public void setUserId(java.lang.Long userId) {
		this.userId = userId;
	}

	public java.lang.Long getGroupId() {
		return groupId;
	}

	public void setGroupId(java.lang.Long groupId) {
		this.groupId = groupId;
	}

	public java.lang.String getUserName() {
		return userName;
	}

	public void setUserName(java.lang.String userName) {
		this.userName = userName;
	}

	public String getTreeJson() {
		String jsonResult = "{";
		jsonResult += "id:" + this.userId + ",";
		jsonResult += "pId:" + this.groupId + ",";
		jsonResult += "name:" + "\"" + this.userName + "\",";
		jsonResult += "open:false";
		jsonResult += "}";
		return jsonResult;
	}
}
