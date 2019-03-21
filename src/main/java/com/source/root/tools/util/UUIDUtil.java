package com.source.root.tools.util;

import java.util.Stack;

public class UUIDUtil {

	/**
	 * @param args
	 */
	public static String toUID() {
		String result = "";
		String res = "";
		for (int i = 0; i < 32; i++) {
			int random = (int) (Math.random() * 16);
			res = baseString(random, 16);
			if ("" == res || "".equals(res)) {
				result = result + "0";
			} else {
				result = result + res;
			}
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static String toNum20() {
		String result = "";
		String res = "";
		for (int i = 0; i < 20; i++) {
			int random = (int) (Math.random() * 16);
			res = baseString(random, 16);
			if ("" == res || "".equals(res)) {
				result = result + "0";
			} else {
				result = result + res;
			}
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static String toAccounts() {
		String result = "";
		String res = "";
		for (int i = 0; i < 7; i++) {
			int random = (int) (Math.random() * 10);
			res = baseString(random, 10);
			if ("" == res || "".equals(res)) {
				result = result + "0";
			} else {
				result = result + res;
			}
		}
		return result;
	}

	/**
	 * 将数转为任意进制
	 * 
	 * @param num
	 * @param base
	 * @return
	 */
	public static String baseString(int num, int base) {
		if (base > 16) {
			throw new RuntimeException("进制数超出范围，base<=16");
		}
		StringBuffer str = new StringBuffer("");
		String digths = "0123456789abcdef";
		Stack<Character> s = new Stack<Character>();
		while (num != 0) {
			s.push(digths.charAt(num % base));
			num /= base;
		}
		while (!s.isEmpty()) {
			str.append(s.pop());
		}
		return str.toString();
	}

	/**
	 * 16进制内任意进制转换
	 * 
	 * @param num
	 * @param srcBase
	 * @param destBase
	 * @return
	 */
	public static String baseNum(String num, int srcBase, int destBase) {
		if (srcBase == destBase) {
			return num;
		}
		String digths = "0123456789abcdef";
		char[] chars = num.toCharArray();
		int len = chars.length;
		if (destBase != 10) {// 目标进制不是十进制 先转化为十进制
			num = baseNum(num, srcBase, 10);
		} else {
			int n = 0;
			for (int i = len - 1; i >= 0; i--) {
				n += digths.indexOf(chars[i]) * Math.pow(srcBase, len - i - 1);
			}
			return n + "";
		}
		return baseString(Integer.valueOf(num), destBase);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i=0; i<3000; i++){
			System.out.println(toUID());
		}

	}

}
