package com.source.root.framework.comm.pager;

import java.util.ArrayList;
import java.util.List;

public class Query {
	private List<ConditionParams> andCondition;
	private List<ConditionParams> orCondition;
	private Pager pager;
	private List<OrderParam> orderCondition;
	
	public List<OrderParam> getOrderCondition() {
		return orderCondition;
	}

	public void setOrderCondition(List<OrderParam> orderCondition) {
		this.orderCondition = orderCondition;
	}

	public void addOrder(String orderKey, String orderValue) {
		if (this.orderCondition == null)
			this.orderCondition = new ArrayList<OrderParam>();
		this.orderCondition.add(new OrderParam(orderKey, orderValue));
	}

	public List<ConditionParams> getAndCondition() {
		return andCondition;
	}

	public void setAndCondition(List<ConditionParams> andCondition) {
		this.andCondition = andCondition;
	}

	public List<ConditionParams> getOrCondition() {
		return orCondition;
	}

	public void setOrCondition(List<ConditionParams> orCondition) {
		this.orCondition = orCondition;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public void addPage(String showCount, String currentPage, int totalResult){
		Pager pagers = new Pager(showCount, currentPage, totalResult);
		this.pager = pagers;
	}

	/**
	 * And 连接条件(in,like,>,<,>=,<=)
	 * 
	 * @param key
	 * @param operator
	 * @param value
	 */
	public void addAndCondition(String key, String operator, String value) {
		if (this.andCondition == null)
			this.andCondition = new ArrayList<ConditionParams>();
		this.andCondition.add(new ConditionParams(key, operator, value));
	}

	/**
	 * And 连接条件(=)
	 * 
	 * @param key
	 * @param value
	 */
	public void addAndCondition(String key, String value) {
		if (this.andCondition == null)
			this.andCondition = new ArrayList<ConditionParams>();
		this.andCondition.add(new ConditionParams(key, value));
	}

	/**
	 * Or 连接条件(in,like,>,<,>=,<=)
	 * 
	 * @param key
	 * @param operator
	 * @param value
	 */
	public void addOrCondition(String key, String operator, String value) {
		if (this.orCondition == null)
			this.orCondition = new ArrayList<ConditionParams>();
		this.orCondition.add(new ConditionParams(key, operator, value));
	}

	/**
	 * Or 连接条件(=)
	 * 
	 * @param key
	 * @param value
	 */
	public void addOrCondition(String key, String value) {
		if (this.orCondition == null)
			this.orCondition = new ArrayList<ConditionParams>();
		this.orCondition.add(new ConditionParams(key, value));
	}

	/*********************************************
	 * Query 测试
	 *********************************************/
	public static Pager paper() {
		Pager pagers = new Pager();
		pagers.setShowCount(5);
		pagers.setCurrentPage(6);
		pagers.setTotalResult(31);
		return pagers;
	}

	public static void main(String[] args) {
		Query q = new Query();
		Pager pagers = new Pager();
		q.addPage("5", "7", 31);
		pagers = q.pager;
		q.setPager(pagers);
	}
}
