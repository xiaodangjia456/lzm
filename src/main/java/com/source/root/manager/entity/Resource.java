package com.source.root.manager.entity;

public class Resource{
//	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Resource";
	public static final String ALIAS_ID = "资源ID";
	public static final String ALIAS_RESOURCE_CODE = "资源编号";
	public static final String ALIAS_RESOURCE_NAME = "资源名称";
	public static final String ALIAS_INHERIT_CODE = "父  id";
	public static final String ALIAS_LEVELS = "资源等级";
	public static final String ALIAS_IMAGE_PATH = "资源图片";
	public static final String ALIAS_RESOURCE_URL = "资源访问路径";
	public static final String ALIAS_IS_ABLE_TABLE = "是否可用";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	//

	private java.lang.Integer id;
	//@Length(max=20)

	private java.lang.String resourceCode;
	//@Length(max=20)

	private java.lang.String resourceName;
	//

	private java.lang.Integer inheritCode;
	//

	private java.lang.Integer levels;
	//@Length(max=50)

	private java.lang.String imagePath;
	//@Length(max=50)

	private java.lang.String resourceUrl;
	//@Length(max=5)

	private java.lang.String isAbleTable;
	//columns END

	public Resource(){
	}

	public Resource(
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
	public void setResourceCode(java.lang.String resourceCode) {
		this.resourceCode = resourceCode;
	}
	
	public java.lang.String getResourceCode() {
		return this.resourceCode;
	}
	public void setResourceName(java.lang.String resourceName) {
		this.resourceName = resourceName;
	}
	
	public java.lang.String getResourceName() {
		return this.resourceName;
	}
	public void setInheritCode(java.lang.Integer inheritCode) {
		this.inheritCode = inheritCode;
	}
	
	public java.lang.Integer getInheritCode() {
		return this.inheritCode;
	}
	public void setLevels(java.lang.Integer levels) {
		this.levels = levels;
	}
	
	public java.lang.Integer getLevels() {
		return this.levels;
	}
	public void setImagePath(java.lang.String imagePath) {
		this.imagePath = imagePath;
	}
	
	public java.lang.String getImagePath() {
		return this.imagePath;
	}
	public void setResourceUrl(java.lang.String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}
	
	public java.lang.String getResourceUrl() {
		return this.resourceUrl;
	}
	public void setIsAbleTable(java.lang.String isAbleTable) {
		this.isAbleTable = isAbleTable;
	}
	
	public java.lang.String getIsAbleTable() {
		return this.isAbleTable;
	}

	public String getJson() {
		String jsonResult = "{";	
			if(this.id==null){
				jsonResult +="\"id\":"+"\" \",";
			}else{
				jsonResult +="\"id\":"+"\""+this.id+"\",";
			}
			if(this.resourceCode==null){
				jsonResult +="\"resourceCode\":"+"\" \",";
			}else{
				jsonResult +="\"resourceCode\":"+"\""+this.resourceCode+"\",";
			}
			if(this.resourceName==null){
				jsonResult +="\"resourceName\":"+"\" \",";
			}else{
				jsonResult +="\"resourceName\":"+"\""+this.resourceName+"\",";
			}
			if(this.inheritCode==null){
				jsonResult +="\"inheritCode\":"+"\" \",";
			}else{
				jsonResult +="\"inheritCode\":"+"\""+this.inheritCode+"\",";
			}
			if(this.levels==null){
				jsonResult +="\"levels\":"+"\" \",";
			}else{
				jsonResult +="\"levels\":"+"\""+this.levels+"\",";
			}
			if(this.imagePath==null){
				jsonResult +="\"imagePath\":"+"\" \",";
			}else{
				jsonResult +="\"imagePath\":"+"\""+this.imagePath+"\",";
			}
			if(this.resourceUrl==null){
				jsonResult +="\"resourceUrl\":"+"\" \",";
			}else{
				jsonResult +="\"resourceUrl\":"+"\""+this.resourceUrl+"\",";
			}
			if(this.isAbleTable==null){
				jsonResult +="\"isAbleTable\":"+"\" \",";
			}else{
				jsonResult +="\"isAbleTable\":"+"\""+this.isAbleTable+"\",";
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