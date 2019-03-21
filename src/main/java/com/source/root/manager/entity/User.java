package com.source.root.manager.entity;

import org.springframework.format.annotation.DateTimeFormat;

import com.source.root.tools.format.DateUtil;

public class User{
//	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "User";
	public static final String ALIAS_ID = "用户ID";
	public static final String ALIAS_NAME = "登录账号";
	public static final String ALIAS_PASSWORD = "登录密码（md5）";
	public static final String ALIAS_REAL_PASSWORD = "真实密码";
	public static final String ALIAS_PHONE = "联系电话";
	public static final String ALIAS_REAL_NAME = "真实姓名";
	public static final String ALIAS_ADDRESS = "详细地址";
	public static final String ALIAS_QQ = "qq号码";
	public static final String ALIAS_EMAIL = "邮箱地址";
	public static final String ALIAS_IMG = "头像";
	public static final String ALIAS_COMPANY_ID = "单位";
	public static final String ALIAS_ROLE_ID = "角色";
	public static final String ALIAS_LNG = "经度";
	public static final String ALIAS_LAT = "纬度";
	public static final String ALIAS_POINT_ADDR = "定位坐标具体位置信息";
	public static final String ALIAS_ENABLED = "是否可用：true(可用)；false(不可用)；";
	public static final String ALIAS_CREATE_TIME = "注册时间";
	public static final String ALIAS_OPERATER = "审核人";
	public static final String ALIAS_OPERAT_TIME = "审核时间";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	//

	private java.lang.Integer id;
	//@Length(max=25)

	private java.lang.String name;
	//@Length(max=32)

	private java.lang.String password;
	//@Length(max=32)

	private java.lang.String realPassword;
	//@Length(max=11)

	private java.lang.String phone;
	//@Length(max=10)

	private java.lang.String realName;
	//@Length(max=50)

	private java.lang.String address;
	//@Length(max=12)

	private java.lang.String qq;
	//@Email @Length(max=30)

	private java.lang.String email;
	//@Length(max=50)

	private java.lang.String img;
	//

	private java.lang.Integer companyId;
	//@NotNull 

	private java.lang.Integer roleId;
	//@Length(max=20)

	private java.lang.String lng;
	//@Length(max=20)

	private java.lang.String lat;
	//@Length(max=30)

	private java.lang.String pointAddr;
	//@Length(max=10)

	private java.lang.String enabled;
	//
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date createTime;
	//

	private java.lang.Integer operater;
	//
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date operatTime;
	
	private Role role;
	private User userOperater;

	private java.lang.Boolean checked;
	//columns END

	public User(){
	}

	public User(
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
	public void setName(java.lang.String name) {
		this.name = name;
	}
	
	public java.lang.String getName() {
		return this.name;
	}
	public void setPassword(java.lang.String password) {
		this.password = password;
	}
	
	public java.lang.String getPassword() {
		return this.password;
	}
	public void setRealPassword(java.lang.String realPassword) {
		this.realPassword = realPassword;
	}
	
	public java.lang.String getRealPassword() {
		return this.realPassword;
	}
	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}
	
	public java.lang.String getPhone() {
		return this.phone;
	}
	public void setRealName(java.lang.String realName) {
		this.realName = realName;
	}
	
	public java.lang.String getRealName() {
		return this.realName;
	}
	public void setAddress(java.lang.String address) {
		this.address = address;
	}
	
	public java.lang.String getAddress() {
		return this.address;
	}
	public void setQq(java.lang.String qq) {
		this.qq = qq;
	}
	
	public java.lang.String getQq() {
		return this.qq;
	}
	public void setEmail(java.lang.String email) {
		this.email = email;
	}
	
	public java.lang.String getEmail() {
		return this.email;
	}
	public void setImg(java.lang.String img) {
		this.img = img;
	}
	
	public java.lang.String getImg() {
		return this.img;
	}
	public void setCompanyId(java.lang.Integer companyId) {
		this.companyId = companyId;
	}
	
	public java.lang.Integer getCompanyId() {
		return this.companyId;
	}
	public void setRoleId(java.lang.Integer roleId) {
		this.roleId = roleId;
	}
	
	public java.lang.Integer getRoleId() {
		return this.roleId;
	}
	public void setLng(java.lang.String lng) {
		this.lng = lng;
	}
	
	public java.lang.String getLng() {
		return this.lng;
	}
	public void setLat(java.lang.String lat) {
		this.lat = lat;
	}
	
	public java.lang.String getLat() {
		return this.lat;
	}
	public void setPointAddr(java.lang.String pointAddr) {
		this.pointAddr = pointAddr;
	}
	
	public java.lang.String getPointAddr() {
		return this.pointAddr;
	}
	public void setEnabled(java.lang.String enabled) {
		this.enabled = enabled;
	}
	
	public java.lang.String getEnabled() {
		return this.enabled;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	public void setOperater(java.lang.Integer operater) {
		this.operater = operater;
	}
	
	public java.lang.Integer getOperater() {
		return this.operater;
	}
	public void setOperatTime(java.util.Date operatTime) {
		this.operatTime = operatTime;
	}
	
	public java.util.Date getOperatTime() {
		return this.operatTime;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public java.lang.Boolean getChecked() {
		return checked;
	}

	public void setChecked(java.lang.Boolean checked) {
		this.checked = checked;
	}

	public User getUserOperater() {
		return userOperater;
	}

	public void setUserOperater(User userOperater) {
		this.userOperater = userOperater;
	}

	public String getJson() {
		String jsonResult = "{";	
			if(this.id==null){
				jsonResult +="\"id\":"+"\" \",";
			}else{
				jsonResult +="\"id\":"+"\""+this.id+"\",";
			}
			if(this.name==null){
				jsonResult +="\"name\":"+"\" \",";
			}else{
				jsonResult +="\"name\":"+"\""+this.name+"\",";
			}
			if(this.password==null){
				jsonResult +="\"password\":"+"\" \",";
			}else{
				jsonResult +="\"password\":"+"\""+this.password+"\",";
			}
			if(this.realPassword==null){
				jsonResult +="\"realPassword\":"+"\" \",";
			}else{
				jsonResult +="\"realPassword\":"+"\""+this.realPassword+"\",";
			}
			if(this.phone==null){
				jsonResult +="\"phone\":"+"\" \",";
			}else{
				jsonResult +="\"phone\":"+"\""+this.phone+"\",";
			}
			if(this.realName==null){
				jsonResult +="\"realName\":"+"\" \",";
			}else{
				jsonResult +="\"realName\":"+"\""+this.realName+"\",";
			}
			if(this.address==null){
				jsonResult +="\"address\":"+"\" \",";
			}else{
				jsonResult +="\"address\":"+"\""+this.address+"\",";
			}
			if(this.qq==null){
				jsonResult +="\"qq\":"+"\" \",";
			}else{
				jsonResult +="\"qq\":"+"\""+this.qq+"\",";
			}
			if(this.email==null){
				jsonResult +="\"email\":"+"\" \",";
			}else{
				jsonResult +="\"email\":"+"\""+this.email+"\",";
			}
			if(this.img==null){
				jsonResult +="\"img\":"+"\" \",";
			}else{
				jsonResult +="\"img\":"+"\""+this.img+"\",";
			}
			if(this.companyId==null){
				jsonResult +="\"companyId\":"+"\" \",";
			}else{
				jsonResult +="\"companyId\":"+"\""+this.companyId+"\",";
			}
			if(this.roleId==null){
				jsonResult +="\"roleId\":"+"\" \",";
			}else{
				jsonResult +="\"roleId\":"+"\""+this.roleId+"\",";
			}
			if(this.lng==null){
				jsonResult +="\"lng\":"+"\" \",";
			}else{
				jsonResult +="\"lng\":"+"\""+this.lng+"\",";
			}
			if(this.lat==null){
				jsonResult +="\"lat\":"+"\" \",";
			}else{
				jsonResult +="\"lat\":"+"\""+this.lat+"\",";
			}
			if(this.pointAddr==null){
				jsonResult +="\"pointAddr\":"+"\" \",";
			}else{
				jsonResult +="\"pointAddr\":"+"\""+this.pointAddr+"\",";
			}
			if(this.enabled==null){
				jsonResult +="\"enabled\":"+"\" \",";
			}else{
				jsonResult +="\"enabled\":"+"\""+this.enabled+"\",";
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
			if(this.operatTime==null){
				jsonResult +="\"operatTime\":"+"\" \",";
			}else{
				jsonResult +="\"operatTime\":"+"\""+DateUtil.dateToString(this.operatTime)+"\",";
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