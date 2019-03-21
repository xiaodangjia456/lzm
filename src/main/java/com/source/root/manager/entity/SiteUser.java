package com.source.root.manager.entity;

import com.google.gson.Gson;

public class SiteUser{
//	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "SiteUser";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_USER_ID = "用户ID";
	public static final String ALIAS_SITE_ID = "站点ID";
	public static final String ALIAS_SEE = "是否可预览";
	public static final String ALIAS_ACT = "是否可控制";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	//

	private java.lang.Integer id;  // id
	//

	private java.lang.Integer userId;  // 用户ID
	//

	private java.lang.Integer siteId;  // 站点ID
	//@Length(max=10)

	private java.lang.String see;  // 是否可预览
	//@Length(max=10)

	private java.lang.String act;  // 是否可控制
	//columns END

	public SiteUser(){
	}

	public SiteUser(
		java.lang.Integer id
	){
		this.id = id;
	}

	// id
	public void setId(java.lang.Integer id) {
		this.id = id;
	}
	// id
	public java.lang.Integer getId() {
		return this.id;
	}
	// 用户ID
	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}
	// 用户ID
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	// 站点ID
	public void setSiteId(java.lang.Integer siteId) {
		this.siteId = siteId;
	}
	// 站点ID
	public java.lang.Integer getSiteId() {
		return this.siteId;
	}
	// 是否可预览
	public void setSee(java.lang.String see) {
		this.see = see;
	}
	// 是否可预览
	public java.lang.String getSee() {
		return this.see;
	}
	// 是否可控制
	public void setAct(java.lang.String act) {
		this.act = act;
	}
	// 是否可控制
	public java.lang.String getAct() {
		return this.act;
	}

	public String getJson() {
		String jsonResult = "{";	
			if(this.id==null){
				jsonResult +="\"id\":"+"\" \",";
			}else{
				jsonResult +="\"id\":"+"\""+this.id+"\",";
			}
			if(this.userId==null){
				jsonResult +="\"userId\":"+"\" \",";
			}else{
				jsonResult +="\"userId\":"+"\""+this.userId+"\",";
			}
			if(this.siteId==null){
				jsonResult +="\"siteId\":"+"\" \",";
			}else{
				jsonResult +="\"siteId\":"+"\""+this.siteId+"\",";
			}
			if(this.see==null){
				jsonResult +="\"see\":"+"\" \",";
			}else{
				jsonResult +="\"see\":"+"\""+this.see+"\",";
			}
			if(this.act==null){
				jsonResult +="\"act\":"+"\" \",";
			}else{
				jsonResult +="\"act\":"+"\""+this.act+"\",";
			}
		jsonResult=jsonResult.substring(0,jsonResult.length()-1);
		jsonResult +="}";
		return jsonResult;
	}

	public String toString() {
		return new Gson().toJson(this);
	}

//	
//
//	
//
}




//
//