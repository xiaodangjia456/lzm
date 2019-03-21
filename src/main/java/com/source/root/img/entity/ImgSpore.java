package com.source.root.img.entity;

import org.springframework.format.annotation.DateTimeFormat;

import com.google.gson.Gson;
import com.source.root.tools.format.DateUtil;

public class ImgSpore{
//	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "ImgSpore";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_SITE_ID = "站点Id";
	public static final String ALIAS_SITE_ALIAS = "站点别名";
	public static final String ALIAS_DEVICE_ID = "设备Id";
	public static final String ALIAS_IMG_DATE = "图片日期（年-月-日）";
	public static final String ALIAS_IMG_NAME = "图片名称";
	public static final String ALIAS_IMG_PATH = "图片全路径";
	public static final String ALIAS_CREATE_TIME = "数据创建时间";
	public static final String ALIAS_IMG_TYPE = "图片类型";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	//

	private java.lang.Integer id;  // id
	//

	private java.lang.Integer siteId;  // 站点Id
	//@Length(max=50)

	private java.lang.String siteAlias;  // 站点别名
	//

	private java.lang.Integer deviceId;  // 设备Id
	//@Length(max=10)

	private java.lang.String imgDate;  // 图片日期（年-月-日）
	//@Length(max=50)

	private java.lang.String imgName;  // 图片名称
	//@Length(max=255)

	private java.lang.String imgPath;  // 图片全路径
	//
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date createTime;  // 数据创建时间
	//@Length(max=10)

	private java.lang.String imgType;  // 图片类型
	//columns END

	public ImgSpore(){
	}

	public ImgSpore(
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
	// 站点Id
	public void setSiteId(java.lang.Integer siteId) {
		this.siteId = siteId;
	}
	// 站点Id
	public java.lang.Integer getSiteId() {
		return this.siteId;
	}
	// 站点别名
	public void setSiteAlias(java.lang.String siteAlias) {
		this.siteAlias = siteAlias;
	}
	// 站点别名
	public java.lang.String getSiteAlias() {
		return this.siteAlias;
	}
	// 设备Id
	public void setDeviceId(java.lang.Integer deviceId) {
		this.deviceId = deviceId;
	}
	// 设备Id
	public java.lang.Integer getDeviceId() {
		return this.deviceId;
	}
	// 图片日期（年-月-日）
	public void setImgDate(java.lang.String imgDate) {
		this.imgDate = imgDate;
	}
	// 图片日期（年-月-日）
	public java.lang.String getImgDate() {
		return this.imgDate;
	}
	// 图片名称
	public void setImgName(java.lang.String imgName) {
		this.imgName = imgName;
	}
	// 图片名称
	public java.lang.String getImgName() {
		return this.imgName;
	}
	// 图片全路径
	public void setImgPath(java.lang.String imgPath) {
		this.imgPath = imgPath;
	}
	// 图片全路径
	public java.lang.String getImgPath() {
		return this.imgPath;
	}
	// 数据创建时间
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	// 数据创建时间
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	// 图片类型
	public void setImgType(java.lang.String imgType) {
		this.imgType = imgType;
	}
	// 图片类型
	public java.lang.String getImgType() {
		return this.imgType;
	}

	public String getJson() {
		String jsonResult = "{";	
			if(this.id==null){
				jsonResult +="\"id\":"+"\" \",";
			}else{
				jsonResult +="\"id\":"+"\""+this.id+"\",";
			}
			if(this.siteId==null){
				jsonResult +="\"siteId\":"+"\" \",";
			}else{
				jsonResult +="\"siteId\":"+"\""+this.siteId+"\",";
			}
			if(this.siteAlias==null){
				jsonResult +="\"siteAlias\":"+"\" \",";
			}else{
				jsonResult +="\"siteAlias\":"+"\""+this.siteAlias+"\",";
			}
			if(this.deviceId==null){
				jsonResult +="\"deviceId\":"+"\" \",";
			}else{
				jsonResult +="\"deviceId\":"+"\""+this.deviceId+"\",";
			}
			if(this.imgDate==null){
				jsonResult +="\"imgDate\":"+"\" \",";
			}else{
				jsonResult +="\"imgDate\":"+"\""+this.imgDate+"\",";
			}
			if(this.imgName==null){
				jsonResult +="\"imgName\":"+"\" \",";
			}else{
				jsonResult +="\"imgName\":"+"\""+this.imgName+"\",";
			}
			if(this.imgPath==null){
				jsonResult +="\"imgPath\":"+"\" \",";
			}else{
				jsonResult +="\"imgPath\":"+"\""+this.imgPath+"\",";
			}
			if(this.createTime==null){
				jsonResult +="\"createTime\":"+"\" \",";
			}else{
				jsonResult +="\"createTime\":"+"\""+DateUtil.dateToString(this.createTime)+"\",";
			}
			if(this.imgType==null){
				jsonResult +="\"imgType\":"+"\" \",";
			}else{
				jsonResult +="\"imgType\":"+"\""+this.imgType+"\",";
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