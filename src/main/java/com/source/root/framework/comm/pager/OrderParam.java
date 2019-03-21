package com.source.root.framework.comm.pager;

public class OrderParam {

	private String orderKey;
	private String orderValue;
	
	public OrderParam(String orderKey, String orderValue) {
		this.orderKey = orderKey;
		this.orderValue = orderValue;
	}
	
	public String getOrderKey() {
		return orderKey;
	}

	public void setOrderKey(String orderKey) {
		this.orderKey = orderKey;
	}

	public String getOrderValue() {
		return orderValue;
	}

	public void setOrderValue(String orderValue) {
		this.orderValue = orderValue;
	}

}
