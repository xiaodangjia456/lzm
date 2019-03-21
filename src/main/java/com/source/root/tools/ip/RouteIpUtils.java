package com.source.root.tools.ip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RouteIpUtils {
	private final static RouteIpUtils routeIpUtils = new RouteIpUtils();

	private RouteIpUtils() {

	}

	public static RouteIpUtils getInstance() {
		// 验证器工具的实例进行注册
		Authenticator.setDefault(new RouterPassAuth());
		return routeIpUtils;
	}

	public String getRouteIp() throws IOException {
		StringBuffer wanPacket = getWanPacket();
		return getFirstIp(wanPacket);
	}

	/**
	 * 获得路由Web中的状态页面上的数据
	 * 
	 * @return
	 * @throws IOException
	 */
	private StringBuffer getWanPacket() throws IOException {
		URL url = new URL(IMailConstant.ROUTE_WEB_STATE);
		InputStream ins = null;
		try {
			ins = url.openConnection().getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					ins));
			String str;
			boolean flag = false;
			StringBuffer wanPacket = new StringBuffer();
			int num = 3;
			while ((str = reader.readLine()) != null && num > 0) {
				if (str.contains("var wanPara = new Array(")) {
					flag = true;
				}
				if (flag) {
					wanPacket.append(str);
					num--;
				}
			}
			return wanPacket;
		} finally {
			if (ins != null) {
				ins.close();
			}
		}
	}

	private String getFirstIp(StringBuffer wanPacket) {
		// 找出数据包中第一个匹配的IP,即为Ip
		Pattern p = Pattern.compile("\\d+\\.\\d+\\.\\d+\\.\\d+");
		Matcher m = p.matcher(wanPacket);
		if (m.find()) {
			return m.group();
		} else {
			return null;
		}
	}

	public static void main(String[] args) {
		try {
			System.out.println(RouteIpUtils.getInstance().getRouteIp());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
