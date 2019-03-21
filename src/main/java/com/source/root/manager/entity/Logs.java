package com.source.root.manager.entity;

import org.springframework.format.annotation.DateTimeFormat;

import com.source.root.tools.format.DateUtil;

public class Logs {
	// private static final long serialVersionUID = 5454155825314635342L;

	// alias
	public static final String TABLE_ALIAS = "Logs";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_USER = "user";
	public static final String ALIAS_RECORD = "record";
	public static final String ALIAS_CREAT_TIME = "creatTime";
	public static final String ALIAS_METHOD = "method";
	public static final String ALIAS_TABLE_NAME = "tableName";
	public static final String ALIAS_IP_ADDR = "ipAddr";

	// 可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	// columns START
	//

	private java.lang.Integer id;
	// @Length(max=30)

	private java.lang.String user;
	// @Length(max=65535)

	private java.lang.String record;
	//
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date creatTime;
	// @Length(max=50)

	private java.lang.String method;
	// @Length(max=50)

	private java.lang.String tableName;
	// @Length(max=20)

	private java.lang.String ipAddr;

	// columns END

	public Logs() {
	}

	public Logs(java.lang.Integer id) {
		this.id = id;
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getId() {
		return this.id;
	}

	public void setUser(java.lang.String user) {
		this.user = user;
	}

	public java.lang.String getUser() {
		return this.user;
	}

	public void setRecord(java.lang.String record) {
		this.record = record;
	}

	public java.lang.String getRecord() {
		return this.record;
	}

	public void setCreatTime(java.util.Date creatTime) {
		this.creatTime = creatTime;
	}

	public java.util.Date getCreatTime() {
		return this.creatTime;
	}

	public void setMethod(java.lang.String method) {
		this.method = method;
	}

	public java.lang.String getMethod() {
		return this.method;
	}

	public void setTableName(java.lang.String tableName) {
		this.tableName = tableName;
	}

	public java.lang.String getTableName() {
		return this.tableName;
	}

	public void setIpAddr(java.lang.String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public java.lang.String getIpAddr() {
		return this.ipAddr;
	}

	public String getJson() {
		String jsonResult = "{";
		if (this.id == null) {
			jsonResult += "\"id\":" + "\" \",";
		} else {
			jsonResult += "\"id\":" + "\"" + this.id + "\",";
		}
		if (this.user == null) {
			jsonResult += "\"user\":" + "\" \",";
		} else {
			jsonResult += "\"user\":" + "\"" + this.user + "\",";
		}
		if (this.record == null) {
			jsonResult += "\"record\":" + "\" \",";
		} else {
			jsonResult += "\"record\":" + "\"" + this.record + "\",";
		}
		if (this.creatTime == null) {
			jsonResult += "\"creatTime\":" + "\" \",";
		} else {
			jsonResult += "\"creatTime\":" + "\"" + DateUtil.dateToString(this.creatTime) + "\",";
		}
		if (this.method == null) {
			jsonResult += "\"method\":" + "\" \",";
		} else {
			jsonResult += "\"method\":" + "\"" + this.method + "\",";
		}
		if (this.tableName == null) {
			jsonResult += "\"tableName\":" + "\" \",";
		} else {
			jsonResult += "\"tableName\":" + "\"" + this.tableName + "\",";
		}
		if (this.ipAddr == null) {
			jsonResult += "\"ipAddr\":" + "\" \",";
		} else {
			jsonResult += "\"ipAddr\":" + "\"" + this.ipAddr + "\",";
		}
		jsonResult = jsonResult.substring(0, jsonResult.length() - 1);
		jsonResult += "}";
		return jsonResult;
	}

	//
	//
	//
	//
}

//
//