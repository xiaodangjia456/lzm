package com.source.root.framework.interceptor.aop;

public class CheckClassNameFilter {

	public static boolean checkClassName(String _className) {
		if ((_className != "Logs" && !"Logs".equals(_className))) {
			return true;
		} else {
			return false;
		}
	}
}
