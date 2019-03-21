package com.source.root.framework.comm.objectsutil;

import java.io.Serializable;

import com.google.gson.Gson;

@SuppressWarnings("serial")
public class RWReturnObject implements Serializable {

	private int code;		// 编码
	private String msg;		// 消息
	private int count;		// 数量
	private Object data;	// 列表数据

	public RWReturnObject() {

	}

	public RWReturnObject(int code) {
		this.code = code;
	}

	public RWReturnObject(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public RWReturnObject(int code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public RWReturnObject(int code, String msg, int count, Object data) {
		this.code = code;
		this.msg = msg;
		this.count = count;
		this.data = data;
	}
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

}
