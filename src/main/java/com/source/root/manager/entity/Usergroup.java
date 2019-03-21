package com.source.root.manager.entity;

public class Usergroup{
//	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Usergroup";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_USER_ID = "userId";
	public static final String ALIAS_GROUP_ID = "groupId";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	//

	private java.lang.Long id;
	//

	private java.lang.Long userId;
	//

	private java.lang.Long groupId;
	//columns END

	public Usergroup(){
	}

	public Usergroup(
		java.lang.Long id
	){
		this.id = id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}
	
	public java.lang.Long getId() {
		return this.id;
	}
	public void setUserId(java.lang.Long userId) {
		this.userId = userId;
	}
	
	public java.lang.Long getUserId() {
		return this.userId;
	}
	public void setGroupId(java.lang.Long groupId) {
		this.groupId = groupId;
	}
	
	public java.lang.Long getGroupId() {
		return this.groupId;
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
			if(this.groupId==null){
				jsonResult +="\"groupId\":"+"\" \",";
			}else{
				jsonResult +="\"groupId\":"+"\""+this.groupId+"\",";
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