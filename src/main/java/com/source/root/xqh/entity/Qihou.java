package com.source.root.xqh.entity;

import org.springframework.format.annotation.DateTimeFormat;

import com.google.gson.Gson;
import com.source.root.tools.format.DateUtil;

public class Qihou{
//	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Qihou";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_SITE_ID = "站点Id";
	public static final String ALIAS_DEVICE_ID = "设备Id";
	public static final String ALIAS_ZHUCE = "注册字";
	public static final String ALIAS_RIQI = "日期";
	public static final String ALIAS_SHIJIAN = "时间";
	public static final String ALIAS_KONGQIWENDU = "空气温度";
	public static final String ALIAS_KONGQISHIDU = "空气湿度";
	public static final String ALIAS_DAQIYAQIANG = "大气压强";
	public static final String ALIAS_FENGXIANG = "风向";
	public static final String ALIAS_FENGSU = "风速";
	public static final String ALIAS_YULIANG = "降雨量";
	public static final String ALIAS_ZHENGFALIANG = "蒸发量";
	public static final String ALIAS_GUANGZHAOQIANGDU = "光照强度";
	public static final String ALIAS_GUANGHE = "光合有效辐射";
	public static final String ALIAS_ZONGFUSHE = "总辐射";
	public static final String ALIAS_TURANGWENDU1 = "土壤温度10cm";
	public static final String ALIAS_TURANGWENDU2 = "土壤温度20cm";
	public static final String ALIAS_TURANGWENDU3 = "土壤温度30cm";
	public static final String ALIAS_TURANGSHIDU1 = "土壤湿度10cm";
	public static final String ALIAS_TURANGSHIDU2 = "土壤湿度20cm";
	public static final String ALIAS_TURANGSHIDU3 = "土壤湿度30cm";
	public static final String ALIAS_TURANG_EC = "土壤可溶浓度";
	public static final String ALIAS_TURANG_PH = "土壤PH值";
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
	//

	private java.lang.Integer id;  // id
	//

	private java.lang.Integer siteId;  // 站点Id
	//

	private java.lang.Integer deviceId;  // 设备Id
	//@Length(max=10)

	private java.lang.String zhuce;  // 注册字
	//
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date riqi;  // 日期
	//
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private java.util.Date shijian;  // 时间
	//@Length(max=10)

	private java.lang.String kongqiwendu;  // 空气温度
	//@Length(max=10)

	private java.lang.String kongqishidu;  // 空气湿度
	//@Length(max=10)

	private java.lang.String daqiyaqiang;  // 大气压强
	//@Length(max=10)

	private java.lang.String fengxiang;  // 风向
	//@Length(max=10)

	private java.lang.String fengsu;  // 风速
	//@Length(max=10)

	private java.lang.String yuliang;  // 降雨量
	//@Length(max=10)

	private java.lang.String zhengfaliang;  // 蒸发量
	//@Length(max=10)

	private java.lang.String guangzhaoqiangdu;  // 光照强度
	//@Length(max=10)

	private java.lang.String guanghe;  // 光合有效辐射
	//@Length(max=10)

	private java.lang.String zongfushe;  // 总辐射
	//@Length(max=10)

	private java.lang.String turangwendu1;  // 土壤温度10cm
	//@Length(max=10)

	private java.lang.String turangwendu2;  // 土壤温度20cm
	//@Length(max=10)

	private java.lang.String turangwendu3;  // 土壤温度30cm
	//@Length(max=10)

	private java.lang.String turangshidu1;  // 土壤湿度10cm
	//@Length(max=10)

	private java.lang.String turangshidu2;  // 土壤湿度20cm
	//@Length(max=10)

	private java.lang.String turangshidu3;  // 土壤湿度30cm
	//@Length(max=10)

	private java.lang.String turangEc;  // 土壤可溶浓度
	//@Length(max=10)

	private java.lang.String turangPh;  // 土壤PH值
	//columns END

	public Qihou(){
	}

	public Qihou(
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
	// 设备Id
	public void setDeviceId(java.lang.Integer deviceId) {
		this.deviceId = deviceId;
	}
	// 设备Id
	public java.lang.Integer getDeviceId() {
		return this.deviceId;
	}
	// 注册字
	public void setZhuce(java.lang.String zhuce) {
		this.zhuce = zhuce;
	}
	// 注册字
	public java.lang.String getZhuce() {
		return this.zhuce;
	}
	// 日期
	public void setRiqi(java.util.Date riqi) {
		this.riqi = riqi;
	}
	// 日期
	public java.util.Date getRiqi() {
		return this.riqi;
	}
	// 时间
	public void setShijian(java.util.Date shijian) {
		this.shijian = shijian;
	}
	// 时间
	public java.util.Date getShijian() {
		return this.shijian;
	}
	// 空气温度
	public void setKongqiwendu(java.lang.String kongqiwendu) {
		this.kongqiwendu = kongqiwendu;
	}
	// 空气温度
	public java.lang.String getKongqiwendu() {
		return this.kongqiwendu;
	}
	// 空气湿度
	public void setKongqishidu(java.lang.String kongqishidu) {
		this.kongqishidu = kongqishidu;
	}
	// 空气湿度
	public java.lang.String getKongqishidu() {
		return this.kongqishidu;
	}
	// 大气压强
	public void setDaqiyaqiang(java.lang.String daqiyaqiang) {
		this.daqiyaqiang = daqiyaqiang;
	}
	// 大气压强
	public java.lang.String getDaqiyaqiang() {
		return this.daqiyaqiang;
	}
	// 风向
	public void setFengxiang(java.lang.String fengxiang) {
		this.fengxiang = fengxiang;
	}
	// 风向
	public java.lang.String getFengxiang() {
		return this.fengxiang;
	}
	// 风速
	public void setFengsu(java.lang.String fengsu) {
		this.fengsu = fengsu;
	}
	// 风速
	public java.lang.String getFengsu() {
		return this.fengsu;
	}
	// 降雨量
	public void setYuliang(java.lang.String yuliang) {
		this.yuliang = yuliang;
	}
	// 降雨量
	public java.lang.String getYuliang() {
		return this.yuliang;
	}
	// 蒸发量
	public void setZhengfaliang(java.lang.String zhengfaliang) {
		this.zhengfaliang = zhengfaliang;
	}
	// 蒸发量
	public java.lang.String getZhengfaliang() {
		return this.zhengfaliang;
	}
	// 光照强度
	public void setGuangzhaoqiangdu(java.lang.String guangzhaoqiangdu) {
		this.guangzhaoqiangdu = guangzhaoqiangdu;
	}
	// 光照强度
	public java.lang.String getGuangzhaoqiangdu() {
		return this.guangzhaoqiangdu;
	}
	// 光合有效辐射
	public void setGuanghe(java.lang.String guanghe) {
		this.guanghe = guanghe;
	}
	// 光合有效辐射
	public java.lang.String getGuanghe() {
		return this.guanghe;
	}
	// 总辐射
	public void setZongfushe(java.lang.String zongfushe) {
		this.zongfushe = zongfushe;
	}
	// 总辐射
	public java.lang.String getZongfushe() {
		return this.zongfushe;
	}
	// 土壤温度10cm
	public void setTurangwendu1(java.lang.String turangwendu1) {
		this.turangwendu1 = turangwendu1;
	}
	// 土壤温度10cm
	public java.lang.String getTurangwendu1() {
		return this.turangwendu1;
	}
	// 土壤温度20cm
	public void setTurangwendu2(java.lang.String turangwendu2) {
		this.turangwendu2 = turangwendu2;
	}
	// 土壤温度20cm
	public java.lang.String getTurangwendu2() {
		return this.turangwendu2;
	}
	// 土壤温度30cm
	public void setTurangwendu3(java.lang.String turangwendu3) {
		this.turangwendu3 = turangwendu3;
	}
	// 土壤温度30cm
	public java.lang.String getTurangwendu3() {
		return this.turangwendu3;
	}
	// 土壤湿度10cm
	public void setTurangshidu1(java.lang.String turangshidu1) {
		this.turangshidu1 = turangshidu1;
	}
	// 土壤湿度10cm
	public java.lang.String getTurangshidu1() {
		return this.turangshidu1;
	}
	// 土壤湿度20cm
	public void setTurangshidu2(java.lang.String turangshidu2) {
		this.turangshidu2 = turangshidu2;
	}
	// 土壤湿度20cm
	public java.lang.String getTurangshidu2() {
		return this.turangshidu2;
	}
	// 土壤湿度30cm
	public void setTurangshidu3(java.lang.String turangshidu3) {
		this.turangshidu3 = turangshidu3;
	}
	// 土壤湿度30cm
	public java.lang.String getTurangshidu3() {
		return this.turangshidu3;
	}
	// 土壤可溶浓度
	public void setTurangEc(java.lang.String turangEc) {
		this.turangEc = turangEc;
	}
	// 土壤可溶浓度
	public java.lang.String getTurangEc() {
		return this.turangEc;
	}
	// 土壤PH值
	public void setTurangPh(java.lang.String turangPh) {
		this.turangPh = turangPh;
	}
	// 土壤PH值
	public java.lang.String getTurangPh() {
		return this.turangPh;
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
			if(this.deviceId==null){
				jsonResult +="\"deviceId\":"+"\" \",";
			}else{
				jsonResult +="\"deviceId\":"+"\""+this.deviceId+"\",";
			}
			if(this.zhuce==null){
				jsonResult +="\"zhuce\":"+"\" \",";
			}else{
				jsonResult +="\"zhuce\":"+"\""+this.zhuce+"\",";
			}
			if(this.riqi==null){
				jsonResult +="\"riqi\":"+"\" \",";
			}else{
				jsonResult +="\"riqi\":"+"\""+DateUtil.dateToString(this.riqi)+"\",";
			}
			if(this.shijian==null){
				jsonResult +="\"shijian\":"+"\" \",";
			}else{
				jsonResult +="\"shijian\":"+"\""+DateUtil.dateToString(this.shijian)+"\",";
			}
			if(this.kongqiwendu==null){
				jsonResult +="\"kongqiwendu\":"+"\" \",";
			}else{
				jsonResult +="\"kongqiwendu\":"+"\""+this.kongqiwendu+"\",";
			}
			if(this.kongqishidu==null){
				jsonResult +="\"kongqishidu\":"+"\" \",";
			}else{
				jsonResult +="\"kongqishidu\":"+"\""+this.kongqishidu+"\",";
			}
			if(this.daqiyaqiang==null){
				jsonResult +="\"daqiyaqiang\":"+"\" \",";
			}else{
				jsonResult +="\"daqiyaqiang\":"+"\""+this.daqiyaqiang+"\",";
			}
			if(this.fengxiang==null){
				jsonResult +="\"fengxiang\":"+"\" \",";
			}else{
				jsonResult +="\"fengxiang\":"+"\""+this.fengxiang+"\",";
			}
			if(this.fengsu==null){
				jsonResult +="\"fengsu\":"+"\" \",";
			}else{
				jsonResult +="\"fengsu\":"+"\""+this.fengsu+"\",";
			}
			if(this.yuliang==null){
				jsonResult +="\"yuliang\":"+"\" \",";
			}else{
				jsonResult +="\"yuliang\":"+"\""+this.yuliang+"\",";
			}
			if(this.zhengfaliang==null){
				jsonResult +="\"zhengfaliang\":"+"\" \",";
			}else{
				jsonResult +="\"zhengfaliang\":"+"\""+this.zhengfaliang+"\",";
			}
			if(this.guangzhaoqiangdu==null){
				jsonResult +="\"guangzhaoqiangdu\":"+"\" \",";
			}else{
				jsonResult +="\"guangzhaoqiangdu\":"+"\""+this.guangzhaoqiangdu+"\",";
			}
			if(this.guanghe==null){
				jsonResult +="\"guanghe\":"+"\" \",";
			}else{
				jsonResult +="\"guanghe\":"+"\""+this.guanghe+"\",";
			}
			if(this.zongfushe==null){
				jsonResult +="\"zongfushe\":"+"\" \",";
			}else{
				jsonResult +="\"zongfushe\":"+"\""+this.zongfushe+"\",";
			}
			if(this.turangwendu1==null){
				jsonResult +="\"turangwendu1\":"+"\" \",";
			}else{
				jsonResult +="\"turangwendu1\":"+"\""+this.turangwendu1+"\",";
			}
			if(this.turangwendu2==null){
				jsonResult +="\"turangwendu2\":"+"\" \",";
			}else{
				jsonResult +="\"turangwendu2\":"+"\""+this.turangwendu2+"\",";
			}
			if(this.turangwendu3==null){
				jsonResult +="\"turangwendu3\":"+"\" \",";
			}else{
				jsonResult +="\"turangwendu3\":"+"\""+this.turangwendu3+"\",";
			}
			if(this.turangshidu1==null){
				jsonResult +="\"turangshidu1\":"+"\" \",";
			}else{
				jsonResult +="\"turangshidu1\":"+"\""+this.turangshidu1+"\",";
			}
			if(this.turangshidu2==null){
				jsonResult +="\"turangshidu2\":"+"\" \",";
			}else{
				jsonResult +="\"turangshidu2\":"+"\""+this.turangshidu2+"\",";
			}
			if(this.turangshidu3==null){
				jsonResult +="\"turangshidu3\":"+"\" \",";
			}else{
				jsonResult +="\"turangshidu3\":"+"\""+this.turangshidu3+"\",";
			}
			if(this.turangEc==null){
				jsonResult +="\"turangEc\":"+"\" \",";
			}else{
				jsonResult +="\"turangEc\":"+"\""+this.turangEc+"\",";
			}
			if(this.turangPh==null){
				jsonResult +="\"turangPh\":"+"\" \",";
			}else{
				jsonResult +="\"turangPh\":"+"\""+this.turangPh+"\",";
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