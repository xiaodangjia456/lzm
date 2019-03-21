package com.source.root.manager.entity;

public class Roleresource{
//	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Roleresource";
	public static final String ALIAS_ID = "角色_资源ID";
	public static final String ALIAS_ROLE_ID = "角色ID";
	public static final String ALIAS_RESOURCE_ID = "资源ID";
	public static final String ALIAS_USER_ID = "用户ID";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	//

	private java.lang.Integer id;
	//

	private java.lang.Integer roleId;
	//

	private java.lang.Integer resourceId;
	//

	private java.lang.Integer userId;
	//columns END

	public Roleresource(){
	}

	public Roleresource(
		java.lang.Integer id
	){
		this.id = id;
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}
	
	public java.lang.Integer getId() {
		return this.id;
	}
	public void setRoleId(java.lang.Integer roleId) {
		this.roleId = roleId;
	}
	
	public java.lang.Integer getRoleId() {
		return this.roleId;
	}
	public void setResourceId(java.lang.Integer resourceId) {
		this.resourceId = resourceId;
	}
	
	public java.lang.Integer getResourceId() {
		return this.resourceId;
	}
	public void setUserId(java.lang.Integer userId) {
		this.userId = userId;
	}
	
	public java.lang.Integer getUserId() {
		return this.userId;
	}

	public String getJson() {
		String jsonResult = "{";	
			if(this.id==null){
				jsonResult +="\"id\":"+"\" \",";
			}else{
				jsonResult +="\"id\":"+"\""+this.id+"\",";
			}
			if(this.roleId==null){
				jsonResult +="\"roleId\":"+"\" \",";
			}else{
				jsonResult +="\"roleId\":"+"\""+this.roleId+"\",";
			}
			if(this.resourceId==null){
				jsonResult +="\"resourceId\":"+"\" \",";
			}else{
				jsonResult +="\"resourceId\":"+"\""+this.resourceId+"\",";
			}
			if(this.userId==null){
				jsonResult +="\"userId\":"+"\" \",";
			}else{
				jsonResult +="\"userId\":"+"\""+this.userId+"\",";
			}
		jsonResult=jsonResult.substring(0,jsonResult.length()-1);
		jsonResult +="}";
		return jsonResult;
	}

//	
//
//	
//
}




//
//