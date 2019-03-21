package com.source.root.tools.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.util.EntityUtils;

@SuppressWarnings({ "unused", "resource", "deprecation" })
public class HtttpGetUtil {

	public static String getStringResult(String sendUrl, String enCoding) {
		/** 缂冩垹绮堕惃鍓坮l閸︽澘娼� */
		URL url = null;

		/** http鏉╃偞甯� */
		HttpURLConnection httpConn = null;

		// ** 鏉堟挸鍙嗗ù锟�*/
		BufferedReader in = null;
		StringBuffer sb = new StringBuffer();
		try {
			url = new URL(sendUrl);
			in = new BufferedReader(new InputStreamReader(url.openStream(), enCoding));
			String str = null;
			while ((str = in.readLine()) != null) {
				sb.append(str);
			}
		} catch (Exception ex) {
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
			}
		}
		String result = sb.toString();
		return result;
	}

	public static String getJsonResultByHeader(String sendUrl, String enCoding, Map<String, String> map)
			throws IOException {
		String CONTENT_TYPE_TEXT_JSON = "text/json";
		DefaultHttpClient client = new DefaultHttpClient(new PoolingClientConnectionManager());

		HttpGet httpGet = new HttpGet(sendUrl);
		httpGet.setHeader("Content-Type", "application/json;charset=" + enCoding);
		if (map != null) {
			for (Entry<String, String> entry : map.entrySet()) {
				httpGet.addHeader(entry.getKey(), entry.getValue());
			}
		}

		CloseableHttpResponse response2 = client.execute(httpGet);
		HttpEntity entity2 = response2.getEntity();
		String result = EntityUtils.toString(entity2, enCoding);
		return result;
	}

	public static void main(String[] args) throws IOException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("apikey", "8d31836c322ad5353918f87f38db584a");
		String aa = getJsonResultByHeader("http://www.cebaowang.com/api/v0.1/device/QX00000016/info",
				"UTF-8", map);
		System.out.println(aa);
	}
}
