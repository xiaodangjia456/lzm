package com.source.root.manager.entity;

public class City{
//	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "City";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_CODE = "行政代码";
	public static final String ALIAS_NAME = "名称";
	public static final String ALIAS_PARENT_ID = "父id";
	public static final String ALIAS_FIRST_LETTER = "首字母";
	public static final String ALIAS_LEVEL = "城市等级";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	//

	private java.lang.Integer id;
	//@NotBlank @Length(max=50)

	private java.lang.String code;
	//@NotBlank @Length(max=255)

	private java.lang.String name;
	//@NotNull 

	private java.lang.Integer parentId;
	//@NotBlank @Length(max=10)

	private java.lang.String firstLetter;
	//@NotNull 

	private java.lang.Integer level;
	//columns END

	public City(){
	}

	public City(
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
	public void setCode(java.lang.String code) {
		this.code = code;
	}
	
	public java.lang.String getCode() {
		return this.code;
	}
	public void setName(java.lang.String name) {
		this.name = name;
	}
	
	public java.lang.String getName() {
		return this.name;
	}
	public void setParentId(java.lang.Integer parentId) {
		this.parentId = parentId;
	}
	
	public java.lang.Integer getParentId() {
		return this.parentId;
	}
	public void setFirstLetter(java.lang.String firstLetter) {
		this.firstLetter = firstLetter;
	}
	
	public java.lang.String getFirstLetter() {
		return this.firstLetter;
	}
	public void setLevel(java.lang.Integer level) {
		this.level = level;
	}
	
	public java.lang.Integer getLevel() {
		return this.level;
	}

	public String getJson() {
		String jsonResult = "{";	
			if(this.id==null){
				jsonResult +="\"id\":"+"\" \",";
			}else{
				jsonResult +="\"id\":"+"\""+this.id+"\",";
			}
			if(this.code==null){
				jsonResult +="\"code\":"+"\" \",";
			}else{
				jsonResult +="\"code\":"+"\""+this.code+"\",";
			}
			if(this.name==null){
				jsonResult +="\"name\":"+"\" \",";
			}else{
				jsonResult +="\"name\":"+"\""+this.name+"\",";
			}
			if(this.parentId==null){
				jsonResult +="\"parentId\":"+"\" \",";
			}else{
				jsonResult +="\"parentId\":"+"\""+this.parentId+"\",";
			}
			if(this.firstLetter==null){
				jsonResult +="\"firstLetter\":"+"\" \",";
			}else{
				jsonResult +="\"firstLetter\":"+"\""+this.firstLetter+"\",";
			}
			if(this.level==null){
				jsonResult +="\"level\":"+"\" \",";
			}else{
				jsonResult +="\"level\":"+"\""+this.level+"\",";
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