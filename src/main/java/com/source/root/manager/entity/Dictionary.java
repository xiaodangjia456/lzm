package com.source.root.manager.entity;

public class Dictionary{
//	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Dictionary";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_CONTENT = "描述内容";
	public static final String ALIAS_TYPE = "数据类型 1、申请类型      A:维修： WEIXIU      B:安装:：ANZHUANG      C:移址：YIZHI 2、申请状态：SHENQING 3、用户评价：PINGJIA 4、支付方式：ZHIFU 5、设备类型：DEVICE_TYPE 6、出差方式：TRAVEL 7、交通工具：RIDE_TYPE 8、配件领取状态：PARTS";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	//

	private java.lang.Integer id;
	//@Length(max=50)

	private java.lang.String content;
	//@Length(max=20)

	private java.lang.String type;
	//columns END

	public Dictionary(){
	}

	public Dictionary(
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
	public void setContent(java.lang.String content) {
		this.content = content;
	}
	
	public java.lang.String getContent() {
		return this.content;
	}
	public void setType(java.lang.String type) {
		this.type = type;
	}
	
	public java.lang.String getType() {
		return this.type;
	}

	public String getJson() {
		String jsonResult = "{";	
			if(this.id==null){
				jsonResult +="\"id\":"+"\" \",";
			}else{
				jsonResult +="\"id\":"+"\""+this.id+"\",";
			}
			if(this.content==null){
				jsonResult +="\"content\":"+"\" \",";
			}else{
				jsonResult +="\"content\":"+"\""+this.content+"\",";
			}
			if(this.type==null){
				jsonResult +="\"type\":"+"\" \",";
			}else{
				jsonResult +="\"type\":"+"\""+this.type+"\",";
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