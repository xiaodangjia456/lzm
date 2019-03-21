package com.source.root.framework.comm.pager;

public class ConditionParams {

	// 大于
	public final static String LG = ">";
	// 大于等于
	public final static String LE = ">=";
	// 小于
	public final static String SM = "<";
	// 小于等于
	public final static String SE = "<=";
	// 等于
	public final static String EQ = "=";
	// 模糊
	public final static String LK = "like";
	// 包含
	public final static String IN = "in";
	// 包含
	public final static String NQ = "!=";
	// 包含
	public final static String IS = "is";
	// 包含
	public final static String ISN = "is not";

	private String key;

	private String params;

	private Object value;

	public ConditionParams(String key, Object value) {
		this.key = key;
		this.params = EQ;
		this.value = value;
	}

	public ConditionParams(String key, String params, Object value) {
		this.key = key;
		this.params = params;
		if (params == "like" || "like".equals(params)) {
			this.value = "\'%" + value + "%\'";
		} else if (params == "in" || "in".equals(params)) {
			this.value = "(" + value + ")";
		} else {
			this.value = value;
		}
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
