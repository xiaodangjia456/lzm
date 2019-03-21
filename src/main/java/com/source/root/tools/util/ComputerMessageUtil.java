package com.source.root.tools.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ComputerMessageUtil {

//	private static Logger logger = Logger.getLogger(ComputerMessageUtil.class);

	/**
	 * IP 获取
	 */
	@SuppressWarnings("unused")
	public static String getLocalIp() {
		InetAddress addr = null;
		String ip = "";
		String address = "";
		try {
			addr = InetAddress.getLocalHost();
			ip = addr.getHostAddress().toString();// 获得本机IP
			address = addr.getHostName().toString();// 获得本机名称
		} catch (UnknownHostException e) {
			e.printStackTrace();
//			logger.error("获取本机IP地址:" + ip);
		}
		return ip;
	}

	public static void main(String[] args) {
		System.out.println(getLocalIp());
	}
}
