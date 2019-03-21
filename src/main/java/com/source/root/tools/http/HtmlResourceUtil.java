package com.source.root.tools.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

@SuppressWarnings("deprecation")
public class HtmlResourceUtil {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String htmls = getPageSource(
				"http://search.sina.com.cn/?c=blog&q=%E5%B0%8F%E9%BA%A6&range=article&by=&sort=time&col=&source=&from=&country=&size=&time=&a=&page=1&dpc=1",
				"gb2312");
		System.out.println(htmls);
	}

	public static String getPageSource(String pageUrl, String encoding) {
		StringBuffer sb = new StringBuffer();
		try {
			// ����һURL����
			URL url = new URL(pageUrl);
			URLConnection URLconnection = url.openConnection();
			HttpURLConnection httpConnection = (HttpURLConnection) URLconnection;
			int responseCode = httpConnection.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				// System.out.println("URL返回值：" + responseCode);
				// ʹ��openStream�õ�һ���������ɴ˹���һ��BufferedReader����
				BufferedReader in = new BufferedReader(new InputStreamReader(
						url.openStream(), encoding));
				String line;
				// ��ȡwww��Դ
				while ((line = in.readLine()) != null) {
					sb.append(line);
				}
				in.close();
			} else {
				sb.append("-1");
			}

		} catch (Exception ex) {
			System.err.println(ex);
		}

		return sb.toString();
	}

	public Boolean submitDataByDoGet(Map<String, String> map, String path)
			throws Exception {
		// ƴ�ճ������ַ
		StringBuilder sb = new StringBuilder(path);
		sb.append("?");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			sb.append(entry.getKey()).append("=").append(entry.getValue());
			sb.append("&");
		}
		sb.deleteCharAt(sb.length() - 1);
		String str = sb.toString();
		URL Url = new URL(str);
		HttpURLConnection HttpConn = (HttpURLConnection) Url.openConnection();
		HttpConn.setRequestMethod("GET");
		HttpConn.setReadTimeout(5000);
		// GET��ʽ������������ʲôDoOutPut()֮�����
		if (HttpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
			return true;
		}
		return false;
	}

	public Boolean submitDataByDoPost(Map<String, String> map, String path)
			throws Exception {
		// ע��Post��ַ���ǲ��������ģ�����newURL��ʱ��Ҫע�ⲻ�ܼ��Ϻ���Ĳ���
		URL Url = new URL(path);
		// Post��ʽ�ύ��ʱ�������URL�Ƿֿ��ύ�ģ�������ʽ�������ӵģ�name=y&age=6
		StringBuilder sb = new StringBuilder();
		// sb.append("?");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			sb.append(entry.getKey()).append("=").append(entry.getValue());
			sb.append("&");
		}
		sb.deleteCharAt(sb.length() - 1);
		String str = sb.toString();

		HttpURLConnection HttpConn = (HttpURLConnection) Url.openConnection();
		HttpConn.setRequestMethod("POST");
		HttpConn.setReadTimeout(5000);
		HttpConn.setDoOutput(true);
		HttpConn.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		HttpConn.setRequestProperty("Content-Length",
				String.valueOf(str.getBytes().length));
		OutputStream os = HttpConn.getOutputStream();
		os.write(str.getBytes());
		if (HttpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
			return true;
		}
		return false;
	}

	@SuppressWarnings({"resource", "unused"})
	public Boolean submitDataByHttpClientDoGet(Map<String, String> map,
			String path) throws Exception {
		HttpClient hc = new DefaultHttpClient();
		// ����·��
		StringBuilder sb = new StringBuilder(path);
		sb.append("?");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			sb.append(entry.getKey()).append("=").append(entry.getValue());
			sb.append("&");
		}
		sb.deleteCharAt(sb.length() - 1);
		String str = sb.toString();
		HttpGet request = new HttpGet(sb.toString());

		HttpResponse response = hc.execute(request);
		if (response.getStatusLine().getStatusCode() == HttpURLConnection.HTTP_OK) {
			return true;
		}
		return false;
	}

	@SuppressWarnings({"resource"})
	public Boolean submintDataByHttpClientDoPost(Map<String, String> map,
			String path) throws Exception {
		// 1. ���һ���൱�����������HttpClient��ʹ������ӿڵ�ʵ��������������DefaultHttpClient
		HttpClient hc = new DefaultHttpClient();
		// DoPost��ʽ�����ʱ���������󣬹ؼ���·��
		HttpPost request = new HttpPost(path);
		// 2. Ϊ�����������������Ҳ���ǽ�Ҫ�ϴ���web�������ϵĲ���
		List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			NameValuePair nameValuePairs = new BasicNameValuePair(
					entry.getKey(), entry.getValue());
			parameters.add(nameValuePairs);
		}
		// ����ʵ��HttpEntityҲ��һ���ӿڣ�����������ʵ����UrlEncodedFormEntity����������ע�����һ��String���͵Ĳ���������ָ�������
		HttpEntity entity = new UrlEncodedFormEntity(parameters, "UTF-8");
		request.setEntity(entity);
		// 3. ִ������
		HttpResponse response = hc.execute(request);
		// 4. ͨ�����������ж�����ɹ����
		if (response.getStatusLine().getStatusCode() == HttpURLConnection.HTTP_OK) {
			return true;
		}
		return false;
	}

}
