package com.source.root.manager.entity;

public class Role{
//	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Role";
	public static final String ALIAS_ID = "角色Id";
	public static final String ALIAS_ROLE_NAME = "角色名称";
	public static final String ALIAS_IS_ABLE = "是否可用";
	public static final String ALIAS_LEVELS = "角色级别";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	//

	private java.lang.Integer id;
	//@NotBlank @Length(max=10)

	private java.lang.String roleName;
	//@NotBlank @Length(max=5)

	private java.lang.String isAble;
	//@NotBlank @Length(max=20)

	private java.lang.String levels;
	//columns END

	public Role(){
	}

	public Role(
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
	public void setRoleName(java.lang.String roleName) {
		this.roleName = roleName;
	}
	
	public java.lang.String getRoleName() {
		return this.roleName;
	}
	public void setIsAble(java.lang.String isAble) {
		this.isAble = isAble;
	}
	
	public java.lang.String getIsAble() {
		return this.isAble;
	}
	public void setLevels(java.lang.String levels) {
		this.levels = levels;
	}
	
	public java.lang.String getLevels() {
		return this.levels;
	}

	public String getJson() {
		String jsonResult = "{";	
			if(this.id==null){
				jsonResult +="\"id\":"+"\" \",";
			}else{
				jsonResult +="\"id\":"+"\""+this.id+"\",";
			}
			if(this.roleName==null){
				jsonResult +="\"roleName\":"+"\" \",";
			}else{
				jsonResult +="\"roleName\":"+"\""+this.roleName+"\",";
			}
			if(this.isAble==null){
				jsonResult +="\"isAble\":"+"\" \",";
			}else{
				jsonResult +="\"isAble\":"+"\""+this.isAble+"\",";
			}
			if(this.levels==null){
				jsonResult +="\"levels\":"+"\" \",";
			}else{
				jsonResult +="\"levels\":"+"\""+this.levels+"\",";
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