package com.source.root.site.entity;

import org.springframework.format.annotation.DateTimeFormat;

import com.google.gson.Gson;
import com.source.root.manager.entity.User;
import com.source.root.tools.format.DateUtil;

public class Site{
//	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Site";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_SITE_NAME = "站点名称";
	public static final String ALIAS_SITE_ALIAS = "站点别名";
	public static final String ALIAS_SITE_IP = "站点IP";
	public static final String ALIAS_SITE_PORT = "站点端口号";
	public static final String ALIAS_SITE_PWD = "站点密码";
	public static final String ALIAS_SITE_LNG = "经度";
	public static final String ALIAS_SITE_LAT = "维度";
	public static final String ALIAS_SHENG = "省";
	public static final String ALIAS_SHI = "市";
	public static final String ALIAS_XIAN = "县";
	public static final String ALIAS_CREATE_TIME = "createTime";
	public static final String ALIAS_OPERATER = "operater";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	//

	private java.lang.Integer id;  // id
	//@Length(max=30)

	private java.lang.String siteName;  // 站点名称
	//@Length(max=50)

	private java.lang.String siteAlias;  // 站点别名
	//@Length(max=18)

	private java.lang.String siteIp;  // 站点IP
	//

	private java.lang.Integer sitePort;  // 站点端口号
	//@Length(max=16)

	private java.lang.String sitePwd;  // 站点密码
	//@Length(max=20)

	private java.lang.String siteLng;  // 经度
	//@Length(max=20)

	private java.lang.String siteLat;  // 维度
	//@Length(max=20)

	private java.lang.String sheng;  // 省
	//@Length(max=20)

	private java.lang.String shi;  // 市
	//@Length(max=20)

	private java.lang.String xian;  // 县
	//
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date createTime;  // createTime
	//

	private java.lang.Integer operater;  // operater
	
	private User user; // 用户信息
	
	private String check; // 是否分配
	//columns END

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Site(){
	}

	public Site(
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
	// 站点名称
	public void setSiteName(java.lang.String siteName) {
		this.siteName = siteName;
	}
	// 站点名称
	public java.lang.String getSiteName() {
		return this.siteName;
	}
	// 站点别名
	public void setSiteAlias(java.lang.String siteAlias) {
		this.siteAlias = siteAlias;
	}
	// 站点别名
	public java.lang.String getSiteAlias() {
		return this.siteAlias;
	}
	// 站点IP
	public void setSiteIp(java.lang.String siteIp) {
		this.siteIp = siteIp;
	}
	// 站点IP
	public java.lang.String getSiteIp() {
		return this.siteIp;
	}
	// 站点端口号
	public void setSitePort(java.lang.Integer sitePort) {
		this.sitePort = sitePort;
	}
	// 站点端口号
	public java.lang.Integer getSitePort() {
		return this.sitePort;
	}
	// 站点密码
	public void setSitePwd(java.lang.String sitePwd) {
		this.sitePwd = sitePwd;
	}
	// 站点密码
	public java.lang.String getSitePwd() {
		return this.sitePwd;
	}
	// 经度
	public void setSiteLng(java.lang.String siteLng) {
		this.siteLng = siteLng;
	}
	// 经度
	public java.lang.String getSiteLng() {
		return this.siteLng;
	}
	// 维度
	public void setSiteLat(java.lang.String siteLat) {
		this.siteLat = siteLat;
	}
	// 维度
	public java.lang.String getSiteLat() {
		return this.siteLat;
	}
	// 省
	public void setSheng(java.lang.String sheng) {
		this.sheng = sheng;
	}
	// 省
	public java.lang.String getSheng() {
		return this.sheng;
	}
	// 市
	public void setShi(java.lang.String shi) {
		this.shi = shi;
	}
	// 市
	public java.lang.String getShi() {
		return this.shi;
	}
	// 县
	public void setXian(java.lang.String xian) {
		this.xian = xian;
	}
	// 县
	public java.lang.String getXian() {
		return this.xian;
	}
	// createTime
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	// createTime
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	// operater
	public void setOperater(java.lang.Integer operater) {
		this.operater = operater;
	}
	// operater
	public java.lang.Integer getOperater() {
		return this.operater;
	}

	public String getJson() {
		String jsonResult = "{";	
			if(this.id==null){
				jsonResult +="\"id\":"+"\" \",";
			}else{
				jsonResult +="\"id\":"+"\""+this.id+"\",";
			}
			if(this.siteName==null){
				jsonResult +="\"siteName\":"+"\" \",";
			}else{
				jsonResult +="\"siteName\":"+"\""+this.siteName+"\",";
			}
			if(this.siteAlias==null){
				jsonResult +="\"siteAlias\":"+"\" \",";
			}else{
				jsonResult +="\"siteAlias\":"+"\""+this.siteAlias+"\",";
			}
			if(this.siteIp==null){
				jsonResult +="\"siteIp\":"+"\" \",";
			}else{
				jsonResult +="\"siteIp\":"+"\""+this.siteIp+"\",";
			}
			if(this.sitePort==null){
				jsonResult +="\"sitePort\":"+"\" \",";
			}else{
				jsonResult +="\"sitePort\":"+"\""+this.sitePort+"\",";
			}
			if(this.sitePwd==null){
				jsonResult +="\"sitePwd\":"+"\" \",";
			}else{
				jsonResult +="\"sitePwd\":"+"\""+this.sitePwd+"\",";
			}
			if(this.siteLng==null){
				jsonResult +="\"siteLng\":"+"\" \",";
			}else{
				jsonResult +="\"siteLng\":"+"\""+this.siteLng+"\",";
			}
			if(this.siteLat==null){
				jsonResult +="\"siteLat\":"+"\" \",";
			}else{
				jsonResult +="\"siteLat\":"+"\""+this.siteLat+"\",";
			}
			if(this.sheng==null){
				jsonResult +="\"sheng\":"+"\" \",";
			}else{
				jsonResult +="\"sheng\":"+"\""+this.sheng+"\",";
			}
			if(this.shi==null){
				jsonResult +="\"shi\":"+"\" \",";
			}else{
				jsonResult +="\"shi\":"+"\""+this.shi+"\",";
			}
			if(this.xian==null){
				jsonResult +="\"xian\":"+"\" \",";
			}else{
				jsonResult +="\"xian\":"+"\""+this.xian+"\",";
			}
			if(this.createTime==null){
				jsonResult +="\"createTime\":"+"\" \",";
			}else{
				jsonResult +="\"createTime\":"+"\""+DateUtil.dateToString(this.createTime)+"\",";
			}
			if(this.operater==null){
				jsonResult +="\"operater\":"+"\" \",";
			}else{
				jsonResult +="\"operater\":"+"\""+this.operater+"\",";
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