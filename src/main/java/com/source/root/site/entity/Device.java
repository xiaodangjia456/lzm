package com.source.root.site.entity;

import org.springframework.format.annotation.DateTimeFormat;

import com.source.root.manager.entity.Dictionary;
import com.source.root.manager.entity.User;
import com.source.root.tools.format.DateUtil;

public class Device{
//	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Device";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_SITE_ID = "站点ID";
	public static final String ALIAS_DEVICE_NAME = "设备名称";
	public static final String ALIAS_DEVICE_CODE = "设备编号";
	public static final String ALIAS_DEVICE_TYPE = "设备类型";
	public static final String ALIAS_DEVICE_IP = "设备IP";
	public static final String ALIAS_DEVICE_PORT = "设备端口";
	public static final String ALIAS_DEVICE_SPORT = "deviceSport";
	public static final String ALIAS_DEVICE_REG = "注册字";
	public static final String ALIAS_DEVICE_LNG = "经度";
	public static final String ALIAS_DEVICE_LAT = "维度";
	public static final String ALIAS_CREATE_TIME = "安装时间";
	public static final String ALIAS_OPERATER = "操作人";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	//

	private java.lang.Integer id;
	//

	private java.lang.Integer siteId;
	//@Length(max=20)

	private java.lang.String deviceName;
	//@Length(max=20)

	private java.lang.String deviceCode;
	//

	private java.lang.Integer deviceType;
	//@Length(max=20)

	private java.lang.String deviceIp;
	//

	private java.lang.Integer devicePort;
	//

	private java.lang.Integer deviceSport;
	//@Length(max=20)

	private java.lang.String deviceReg;
	//@Length(max=20)

	private java.lang.String deviceLng;
	//@Length(max=255)

	private java.lang.String deviceLat;
	//
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date createTime;
	//

	private java.lang.Integer operater;
	
	private Dictionary dictionary;
	private User user;
	//columns END

	public Device(){
	}

	public Device(
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
	public void setSiteId(java.lang.Integer siteId) {
		this.siteId = siteId;
	}
	
	public java.lang.Integer getSiteId() {
		return this.siteId;
	}
	public void setDeviceName(java.lang.String deviceName) {
		this.deviceName = deviceName;
	}
	
	public java.lang.String getDeviceName() {
		return this.deviceName;
	}
	public void setDeviceCode(java.lang.String deviceCode) {
		this.deviceCode = deviceCode;
	}
	
	public java.lang.String getDeviceCode() {
		return this.deviceCode;
	}
	public void setDeviceType(java.lang.Integer deviceType) {
		this.deviceType = deviceType;
	}
	
	public java.lang.Integer getDeviceType() {
		return this.deviceType;
	}
	public void setDeviceIp(java.lang.String deviceIp) {
		this.deviceIp = deviceIp;
	}
	
	public java.lang.String getDeviceIp() {
		return this.deviceIp;
	}
	public void setDevicePort(java.lang.Integer devicePort) {
		this.devicePort = devicePort;
	}
	
	public java.lang.Integer getDevicePort() {
		return this.devicePort;
	}
	public void setDeviceSport(java.lang.Integer deviceSport) {
		this.deviceSport = deviceSport;
	}
	
	public java.lang.Integer getDeviceSport() {
		return this.deviceSport;
	}
	public void setDeviceReg(java.lang.String deviceReg) {
		this.deviceReg = deviceReg;
	}
	
	public java.lang.String getDeviceReg() {
		return this.deviceReg;
	}
	public void setDeviceLng(java.lang.String deviceLng) {
		this.deviceLng = deviceLng;
	}
	
	public java.lang.String getDeviceLng() {
		return this.deviceLng;
	}
	public void setDeviceLat(java.lang.String deviceLat) {
		this.deviceLat = deviceLat;
	}
	
	public java.lang.String getDeviceLat() {
		return this.deviceLat;
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

	public Dictionary getDictionary() {
		return dictionary;
	}

	public void setDictionary(Dictionary dictionary) {
		this.dictionary = dictionary;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
			if(this.deviceName==null){
				jsonResult +="\"deviceName\":"+"\" \",";
			}else{
				jsonResult +="\"deviceName\":"+"\""+this.deviceName+"\",";
			}
			if(this.deviceCode==null){
				jsonResult +="\"deviceCode\":"+"\" \",";
			}else{
				jsonResult +="\"deviceCode\":"+"\""+this.deviceCode+"\",";
			}
			if(this.deviceType==null){
				jsonResult +="\"deviceType\":"+"\" \",";
			}else{
				jsonResult +="\"deviceType\":"+"\""+this.deviceType+"\",";
			}
			if(this.deviceIp==null){
				jsonResult +="\"deviceIp\":"+"\" \",";
			}else{
				jsonResult +="\"deviceIp\":"+"\""+this.deviceIp+"\",";
			}
			if(this.devicePort==null){
				jsonResult +="\"devicePort\":"+"\" \",";
			}else{
				jsonResult +="\"devicePort\":"+"\""+this.devicePort+"\",";
			}
			if(this.deviceSport==null){
				jsonResult +="\"deviceSport\":"+"\" \",";
			}else{
				jsonResult +="\"deviceSport\":"+"\""+this.deviceSport+"\",";
			}
			if(this.deviceReg==null){
				jsonResult +="\"deviceReg\":"+"\" \",";
			}else{
				jsonResult +="\"deviceReg\":"+"\""+this.deviceReg+"\",";
			}
			if(this.deviceLng==null){
				jsonResult +="\"deviceLng\":"+"\" \",";
			}else{
				jsonResult +="\"deviceLng\":"+"\""+this.deviceLng+"\",";
			}
			if(this.deviceLat==null){
				jsonResult +="\"deviceLat\":"+"\" \",";
			}else{
				jsonResult +="\"deviceLat\":"+"\""+this.deviceLat+"\",";
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

//	
//
//	
//
}




//
//