package com.source.root.tools.http;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.source.root.tools.format.DateUtil;

public class ExtractInfoUtil {

	private final static String regxpHtml = "<[^>]+>";
	private final static String regxpWebService = "<string xmlns=\"http://tempuri.org/\">(.*?)</string>";

	// private final static String regxpForHtml = "<([^>]*)>"; //
	// 过滤所有以<开头以>结尾的标签
	// private final static String regxpForImgTag = "<\\s*img\\s+([^>]*)\\s*>";
	// // 找出IMG标签
	// private final static String regxpForImaTagSrcAttrib = "src=\"([^\"]+)\"";
	// // 找出IMG标签的SRC属性
	
	public static String getWebServiceJsonResult(String param){
		String result = "";
		Pattern p = Pattern.compile(regxpWebService);
		Matcher m = p.matcher(param);
		if(m.find()) {
		    result = m.group(1);
		}
		return result;
	}

	/**
	 * 获取url连接
	 * 
	 * @Title: getMatchToUrl_title
	 * @Description: TODO
	 * @param url
	 *            索引链接
	 * @param html
	 * @param pRule
	 * @return: ArrayList<String>
	 */
	public static ArrayList<String> getMatchToUrl(String url, String html,
			String pRule, String splitWord) {
		String[] splitArr = new String[]{};
		if (splitWord != null && !"".equals(splitWord)) {
			splitArr = html.split(splitWord);
		} else {
			splitArr = new String[]{html};
		}
		ArrayList<String> strs = new ArrayList<String>();
		int ii = 0;
		if (splitArr.length > 1) {
			ii = 1;
		} else {
			ii = 0;
		}
		for (int i = ii; i < splitArr.length; i++) {
			String htm = splitArr[i];
			Pattern p = Pattern.compile(pRule);
			Matcher m = p.matcher(htm);
			while (m.find()) {
				// 是否包含html 元素
				String href = m.group(1);
				Pattern _p = Pattern.compile(regxpHtml);
				Matcher _m = _p.matcher(href);
				if (_m.find()) {
					_m.replaceAll("");
				}
				// url两头是否包含双引号
				href = href.replaceFirst("\"", "");
				int len = href.indexOf("\"");
				if (len > 0) {
					href = href.substring(0, len);
				}
				// 是否包含http://
				if (href.contains("http://")) {
					if (!href.contains(" "))
						strs.add(href);
				} else {
					if (!href.contains(" ")) {
						String substr = changeUrl(href, url);
						strs.add(substr);
					}
				}
			}
		}
		return strs;
	}
	/**
	 * 对提取到的url链接进行补充，主要用于处理相对路径的url
	 * 
	 * @param url
	 * @param indexUrl
	 * @return
	 */
	public static String changeUrl(String url, String indexUrl) {
		String finalUrl = "";
		if (url.indexOf("/") == 0) {
			finalUrl = getUrlSite(indexUrl) + url.substring(1, url.length());
		} else if (url.indexOf("../../") == 0) {
			// System.out.println(url);
			if (indexUrl.lastIndexOf("/") == indexUrl.length() - 1) {
				// 如果索引链接最后一级目录带有/这个结束符号
				String[] arr = indexUrl.split("/");
				finalUrl = arr[0];
				for (int i = 1; i < arr.length - 2; i++) {
					finalUrl = finalUrl + "/" + arr[i];
				}
			} else {
				// 如果索引链接最后一级目录不带有/这个结束符号
				String[] arr = indexUrl.split("/");
				finalUrl = arr[0];
				for (int i = 1; i < arr.length - 1; i++) {
					finalUrl = finalUrl + "/" + arr[i];
				}
			}
			finalUrl += url.substring(5, url.length());
		} else if (url.indexOf("../") == 0) {
			if (indexUrl.lastIndexOf("/") == indexUrl.length() - 1) {
				// 如果索引链接最后一级目录带有/这个结束符号
				String[] arr = indexUrl.split("/");
				finalUrl = arr[0];
				for (int i = 1; i < arr.length - 1; i++) {
					finalUrl = finalUrl + "/" + arr[i];
				}
			} else {
				// 如果索引链接最后一级目录不带有/这个结束符号
				String[] arr = indexUrl.split("/");
				finalUrl = arr[0];
				for (int i = 1; i < arr.length; i++) {
					finalUrl = finalUrl + "/" + arr[i];
				}
			}
			finalUrl += url.substring(2, url.length());
		} else if (url.indexOf("./") == 0) {
			finalUrl = indexUrl + url.substring(2, url.length());
		} else {
			finalUrl = getUrlSite(indexUrl) + url;
		}
		return finalUrl;
	}

	/**
	 * 解析提取一条链接
	 * 
	 * @param url
	 * @param param
	 * @param pRule
	 * @return
	 */
	public static String getMatchUrl(String url, String param, String pRule) {
		String result = "";
		Pattern p = Pattern.compile(pRule);
		Matcher m = p.matcher(param);
		while (m.find()) {
			// 是否包含html 元素
			String href = m.group(1);
			Pattern _p = Pattern.compile(regxpHtml);
			Matcher _m = _p.matcher(href);
			if (_m.find()) {
				_m.replaceAll("");
			}
			// url两头是否包含双引号
			href = href.replaceFirst("\"", "");
			int len = href.indexOf("\"");
			if (len > 0) {
				href = href.substring(0, len);
			}
			// 是否包含http://
			if (href.contains("http://")) {
				if (!href.contains(" "))
					result = href;
			} else {
				if (!href.contains(" ")) {
					int sit = href.indexOf("/");
					if (sit == 0) {
						result = getUrlSite(url)
								+ href.substring(1, href.length());
					} else {
						result = getUrlSite(url) + href;
					}
				}
			}
		}
		return result;
	}

	/**
	 * 获取标题内容
	 * 
	 * @Title: getMatchTitle
	 * @Description: TODO
	 * @param html
	 * @param pRule
	 * @return: String
	 */
	public static String getMatch(String html, String pRule) {
		Pattern p = Pattern.compile(pRule);
		Matcher m = p.matcher(html);
		String result = "";
		while (m.find()) {
			result += m.group(1);
		}
		result = regxpHtml(result.trim().toString());
		result = filterSymbol(result).trim();
		return result;
	}

	public static String filterSymbol(String param) {
		String nbsp = "&nbsp;"; // 空格
		String ldquo = "&ldquo;"; // 中文前双引号
		String rdquo = "&rdquo;"; // 中文后双引号
		String quot = "&quot;"; // 中文后双引号
		String lt = "&lt;"; // 小于号 <
		String gt = "&gt;"; // 大于号 >
		String mdash = "&mdash;"; // 长连接线 ——
		String minus = "&minus;"; // 短连接线 -
		String t = "\t";
		if (param.contains(t))
			param = param.replaceAll(t, "");
		if (param.contains(nbsp))
			param = param.replaceAll(nbsp, "");
		if (param.contains(quot))
			param = param.replaceAll(quot, "\"");
		if (param.contains(ldquo))
			param = param.replaceAll(ldquo, "“");
		if (param.contains(rdquo))
			param = param.replaceAll(rdquo, "”");
		if (param.contains(lt))
			param = param.replaceAll(lt, "<");
		if (param.contains(gt))
			param = param.replaceAll(gt, ">");
		if (param.contains(mdash))
			param = param.replaceAll(mdash, "——");
		if (param.contains(minus))
			param = param.replaceAll(minus, "—");
		return param;
	}

	/**
	 * 过滤html标签
	 * 
	 * @Title: regxpHtml
	 * @Description: TODO
	 * @param param
	 * @return: String
	 */
	public static String regxpHtml(String param) {
		String result = "";
		Pattern p_html = Pattern.compile(regxpHtml, Pattern.CASE_INSENSITIVE);
		Matcher m_html = p_html.matcher(param);
		result = m_html.replaceAll(""); // 过滤html标签
		// System.out.println(result);
		// System.out.println(HTTP.UTF_8);
		return result;
	}

	/**
	 * 获取首页站点
	 * 
	 * @Title: getUrlSite
	 * @Description: TODO
	 * @param url
	 * @return: String
	 */
	public static String getUrlSite(String url) {
		String site = "";
		String tmpUrl = "";
		if (url.indexOf("http://") == 0) {
			tmpUrl = url.substring(7);
		} else {
			tmpUrl = url;
		}
		if (tmpUrl.contains("/")) {
			int len = tmpUrl.indexOf("/");
			site = "http://" + tmpUrl.substring(0, len + 1);
		} else {
			site = "http://" + tmpUrl.substring(0, tmpUrl.length()) + "/";
		}
		return site;
	}

	/**
	 * 获取站点m名称
	 * 
	 * @Title: getUrlSite
	 * @Description: TODO
	 * @param url
	 * @return: String
	 */
	public static String getSiteName(String url) {
		String site = "";
		url = url.replace(".", "_");
		if (url.contains("_")) {
			String[] arr = url.split("_");
			if (arr.length >= 3) {
				site = arr[1];
			}
		}
		return site;
	}

	public static String getSourceName(String source_time) {
		int len = source_time.length();
		int last = source_time.lastIndexOf("：");
		String result = source_time.substring(last + 1, len);
		return result;
	}

	public static Date strToGetTime(String datePrama) {
		datePrama = datePrama.trim().toString();
		int len = datePrama.length();
		Date result = null;
		if (len >= 8 && len <= 21) {
			if (datePrama.contains("年"))
				datePrama = datePrama.replaceAll("年", "/");
			if (datePrama.contains("月"))
				datePrama = datePrama.replaceAll("月", "/");
			if (datePrama.contains("日"))
				datePrama = datePrama.replaceAll("日", "|");
			if (datePrama.contains("/"))
				datePrama = datePrama.replaceAll("/", "/");
			if (datePrama.contains("-"))
				datePrama = datePrama.replaceAll("-", "/");
			if (datePrama.contains("."))
				datePrama = datePrama.replace(".", "/");
			if (datePrama.contains(" "))
				datePrama = datePrama.replace(" ", "|");
			if (datePrama.contains("|")) {
				int site = datePrama.indexOf("|");
				datePrama = datePrama.substring(0, site);
				if (datePrama.contains("/")) {
					String[] split = datePrama.split("/");
					String _datePrama = "";
					for (String item : split) {
						DecimalFormat df = new DecimalFormat("00");
						String str2 = df.format(Integer.parseInt(item));
						_datePrama += str2 + "-";
					}
					_datePrama = _datePrama.substring(0,
							_datePrama.length() - 1);
					try {
						result = DateUtil.toDate(_datePrama);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
			} else {
				if (datePrama.contains("/") && datePrama.length() < 10) {
					String[] split = datePrama.split("/");
					String _datePrama = "";
					for (String item : split) {
						DecimalFormat df = new DecimalFormat("00");
						String str2 = df.format(Integer.parseInt(item));
						_datePrama += str2 + "-";
					}
					_datePrama = _datePrama.substring(0,
							_datePrama.length() - 1);
					try {
						result = DateUtil.toDate(_datePrama);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return result;
	}

	/**
	 * 字符串替换引文双引号
	 * 
	 * @param param
	 * @return
	 */
	public static String replaceChar(String param) {
		if (param.contains("\"")) {
			param = param.replace("\"", "_");
		}
		return param;
	}

	public static void main(String[] args) throws ParseException {
		getWebServiceJsonResult("<string xmlns=\"http://tempuri.org/\">[{\"id\":\"82802\",\"date_time\":\"2015-05-30 00:00:00\"},{\"id\":\"83232\",\"date_time\":\"2015-06-01 23:50:00\"}]</string>");
	}
}
