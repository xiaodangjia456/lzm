package com.source.root.manager.entity;

public class Grouparea{
//	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Grouparea";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_GROUP_ID = "groupId";
	public static final String ALIAS_AREA_ID = "areaId";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	//

	private java.lang.Long id;
	//

	private java.lang.Long groupId;
	//

	private java.lang.Long areaId;
	//columns END

	public Grouparea(){
	}

	public Grouparea(
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
	public void setAreaId(java.lang.Long areaId) {
		this.areaId = areaId;
	}
	
	public java.lang.Long getAreaId() {
		return this.areaId;
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
			if(this.areaId==null){
				jsonResult +="\"areaId\":"+"\" \",";
			}else{
				jsonResult +="\"areaId\":"+"\""+this.areaId+"\",";
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