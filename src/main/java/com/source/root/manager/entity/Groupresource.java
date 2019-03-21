package com.source.root.manager.entity;

public class Groupresource{
//	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Groupresource";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_GROUP_ID = "groupId";
	public static final String ALIAS_RESOURCE_ID = "resourceId";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	//

	private java.lang.Long id;
	//

	private java.lang.Long groupId;
	//

	private java.lang.Long resourceId;
	//columns END

	public Groupresource(){
	}

	public Groupresource(
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
	public void setGroupId(java.lang.Long groupId) {
		this.groupId = groupId;
	}
	
	public java.lang.Long getGroupId() {
		return this.groupId;
	}
	public void setResourceId(java.lang.Long resourceId) {
		this.resourceId = resourceId;
	}
	
	public java.lang.Long getResourceId() {
		return this.resourceId;
	}

	public String getJson() {
		String jsonResult = "{";	
			if(this.id==null){
				jsonResult +="\"id\":"+"\" \",";
			}else{
				jsonResult +="\"id\":"+"\""+this.id+"\",";
			}
			if(this.groupId==null){
				jsonResult +="\"groupId\":"+"\" \",";
			}else{
				jsonResult +="\"groupId\":"+"\""+this.groupId+"\",";
			}
			if(this.resourceId==null){
				jsonResult +="\"resourceId\":"+"\" \",";
			}else{
				jsonResult +="\"resourceId\":"+"\""+this.resourceId+"\",";
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