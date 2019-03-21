package com.source.root.tools.ip;

public class IMailConstant {
	/**
	 * 发件人地址
	 */
	public final static String NOTIFY_EMAIL_MESSAGE_FROM = "wensong1987@126.com";

	/**
	 * 提醒邮件标题前缀
	 */
	public final static String NOTIFY_EMAIL_MESSAGE_PRE_TITLE = "通知：服务器IP提醒————";

	/**
	 * 路由用户名
	 */
	public final static String ROUTE_USER = "admin";

	/**
	 * 路由密码
	 */
	public final static String ROUTE_PWD = "huang";

	/**
	 * 路由Web记录状态的页面，里面包含了Wan口ip
	 */
	public final static String ROUTE_WEB_STATE = "http://192.168.1.1:83/userRpm/StatusRpm.htm?Connect=连 接&wan=1";

	/**
	 * 轮询时间 10分钟
	 */
	public final static long POLLING_TIME = 10 * 60 * 1000;

	/**
	 * email文件地址
	 */
	public final static String EMAIL_FILE_PATH = "/root/mail/mail.txt";

	/**
	 * log4j存放地址
	 */
	public final static String LOG4J_FILE_PATH = "/root/mail/log/log4j.properties";

	/**
	 * 匹配email的正则
	 */
	public final static String EMAIL_REG = "[A-Za-z0-9](?:[0-9a-zA-Z_]?\\.?){4,24}@[0-9a-zA-Z_-]{1,59}\\.(?:[0-9a-zA-Z]\\.?[0-9a-zA-Z]?){2,3}";
}