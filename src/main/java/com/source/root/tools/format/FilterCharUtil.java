package com.source.root.tools.format;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilterCharUtil {

	private final static String regxpHtml = "<[^>]+>";

	/**
	 * 
	 * @param html
	 * @return
	 */
	public static String htmlElement(String html) {
		String result = "";
		int start = html.indexOf("<body>");
		int end = html.indexOf("</html>");
		html = html.substring(start, end);
		Pattern p_html = Pattern.compile(regxpHtml, Pattern.CASE_INSENSITIVE);
		Matcher m_html = p_html.matcher(html);
		result = m_html.replaceAll("");
		return result;
	}
}
