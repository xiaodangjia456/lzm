package com.source.root.manager.entity;

public class Chooseauthoritytype{
//	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Chooseauthoritytype";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_MARK = "mark";
	public static final String ALIAS_NAME = "name";
	public static final String ALIAS_REMARKS = "remarks";
	public static final String ALIAS_ENABLE = "enable";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	//

	private java.lang.Long id;
	//@Length(max=20)

	private java.lang.String mark;
	//@Length(max=20)

	private java.lang.String name;
	//@Length(max=255)

	private java.lang.String remarks;
	//@Length(max=5)

	private java.lang.String enable;
	//columns END

	public Chooseauthoritytype(){
	}

	public Chooseauthoritytype(
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
	public void setMark(java.lang.String mark) {
		this.mark = mark;
	}
	
	public java.lang.String getMark() {
		return this.mark;
	}
	public void setName(java.lang.String name) {
		this.name = name;
	}
	
	public java.lang.String getName() {
		return this.name;
	}
	public void setRemarks(java.lang.String remarks) {
		this.remarks = remarks;
	}
	
	public java.lang.String getRemarks() {
		return this.remarks;
	}
	public void setEnable(java.lang.String enable) {
		this.enable = enable;
	}
	
	public java.lang.String getEnable() {
		return this.enable;
	}

	public String getJson() {
		String jsonResult = "{";	
			if(this.id==null){
				jsonResult +="\"id\":"+"\" \",";
			}else{
				jsonResult +="\"id\":"+"\""+this.id+"\",";
			}
			if(this.mark==null){
				jsonResult +="\"mark\":"+"\" \",";
			}else{
				jsonResult +="\"mark\":"+"\""+this.mark+"\",";
			}
			if(this.name==null){
				jsonResult +="\"name\":"+"\" \",";
			}else{
				jsonResult +="\"name\":"+"\""+this.name+"\",";
			}
			if(this.remarks==null){
				jsonResult +="\"remarks\":"+"\" \",";
			}else{
				jsonResult +="\"remarks\":"+"\""+this.remarks+"\",";
			}
			if(this.enable==null){
				jsonResult +="\"enable\":"+"\" \",";
			}else{
				jsonResult +="\"enable\":"+"\""+this.enable+"\",";
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