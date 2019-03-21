package com.source.root.tools.http;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

@SuppressWarnings({ "unused", "resource", "deprecation" })
public class HttpPostFileUtil {
	URL url;
	HttpURLConnection conn;
	String boundary = "--------httppost123";
	Map<String, String> textParams = new HashMap<String, String>();
	Map<String, File> fileparams = new HashMap<String, File>();
	DataOutputStream ds;

	public HttpPostFileUtil(String url) throws Exception {
		this.url = new URL(url);
	}

	// 重新设置要请求的服务器地址，即上传文件的地址。
	public void setUrl(String url) throws Exception {
		this.url = new URL(url);
	}

	// 增加一个普通字符串数据到form表单数据中
	public void addTextParameter(String name, String value) {
		textParams.put(name, value);
	}

	// 增加一个文件到form表单数据中
	public void addFileParameter(String name, File value) {
		fileparams.put(name, value);
	}

	// 清空所有已添加的form表单数据
	public void clearAllParameters() {
		textParams.clear();
		fileparams.clear();
	}

	// 发送数据到服务器，返回一个字节包含服务器的返回结果的数组
	public byte[] send(String status) throws Exception {
		initConnection(status);
		try {
			conn.connect();
		} catch (SocketTimeoutException e) {
			// something
			throw new RuntimeException();
		}
		ds = new DataOutputStream(conn.getOutputStream());
		if (status == "file" || "file".equals(status)) {
			writeFileParams();
		} else {
			writeStringParams();
		}
		// paramsEnd();
		InputStream in = conn.getInputStream();
		// BufferedReader in = new BufferedReader(new InputStreamReader(in,
		// "GBK"));
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int b;
		while ((b = in.read()) != -1) {
			out.write(b);
		}
		conn.disconnect();
		return out.toByteArray();
	}

	// 文件上传的connection的一些必须设置
	private void initConnection(String status) throws Exception {
		conn = (HttpURLConnection) this.url.openConnection();
		conn.setDoOutput(true);
		conn.setUseCaches(false);
		conn.setConnectTimeout(10000); // 连接超时为10秒
		conn.setRequestMethod("POST");
		if (status == "file" || "file".equals(status)) {
			conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
		} else {
			conn.setRequestProperty("Content-Type", "GBK");
		}
	}

	// 普通字符串数据
	private void writeStringParams() throws Exception {
		// Set<String> keySet = textParams.keySet();
		// for (Iterator<String> it = keySet.iterator(); it.hasNext();) {
		// String name = it.next();
		// String value = textParams.get(name);
		// ds.writeBytes("--" + boundary + "\r\n");
		// ds.writeBytes("Content-Disposition: form-data; name=\"" + name
		// + "\"\r\n");
		// ds.writeBytes("\r\n");
		// ds.writeBytes(encode(value) + "\r\n");
		// }
		Gson gson = new Gson();
		String json = "[" + gson.toJson(textParams) + "]";
		ds.write(json.getBytes("gbk"));

	}

	// 文件数据
	private void writeFileParams() throws Exception {
		Set<String> keySet = fileparams.keySet();
		for (Iterator<String> it = keySet.iterator(); it.hasNext();) {
			String name = it.next();
			File value = fileparams.get(name);
			// ds.writeBytes("--" + boundary + "\r\n");
			// ds.writeBytes("Content-Disposition: form-data; name=\"" + name
			// + "\"; filename=\"" + encode(value.getName()) + "\"\r\n");
			// ds.writeBytes("Content-Type: " + getContentType(value) + "\r\n");
			// ds.writeBytes("\r\n");
			ds.write(getBytes(value));
			// ds.writeBytes("\r\n");
		}
	}

	// 获取文件的上传类型，图片格式为image/png,image/jpg等。非图片为application/octet-stream
	private String getContentType(File f) throws Exception {

		// return "application/octet-stream"; //
		// 此行不再细分是否为图片，全部作为application/octet-stream 类型
		ImageInputStream imagein = ImageIO.createImageInputStream(f);
		if (imagein == null) {
			return "application/octet-stream";
		}
		Iterator<ImageReader> it = ImageIO.getImageReaders(imagein);
		if (!it.hasNext()) {
			imagein.close();
			return "application/octet-stream";
		}
		imagein.close();
		return "image/" + it.next().getFormatName().toLowerCase();// 将FormatName返回的值转换成小写，默认为大写

	}

	// 把文件转换成字节数组
	private byte[] getBytes(File f) throws Exception {
		FileInputStream in = new FileInputStream(f);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] b = new byte[1024];
		int n;
		while ((n = in.read(b)) != -1) {
			out.write(b, 0, n);
		}
		in.close();
		return out.toByteArray();
	}

	// 添加结尾数据
	private void paramsEnd() throws Exception {
		ds.writeBytes("--" + boundary + "--" + "\r\n");
		ds.writeBytes("\r\n");
	}

	// 对包含中文的字符串进行转码，此为UTF-8。服务器那边要进行一次解码
	private String encode(String value) throws Exception {
		return URLEncoder.encode(value, "gbk");
	}

	private String getJsonResultByHeader() throws ParseException, IOException {
		final String CONTENT_TYPE_TEXT_JSON = "text/json";
		DefaultHttpClient client = new DefaultHttpClient(new PoolingClientConnectionManager());

		String url = "http://172.16.30.226:8091/svc/authentication/register";
		String js = "{\"userName\":\"18600363833\",\"validateChar\":\"706923\",\"randomChar\":\"706923\",\"password\":\"123456\",\"confirmPwd\":\"123456\",\"recommendMobile\":\"\",\"idCard\":\"320601197608285792\",\"realName\":\"阙岩\",\"verifyCode\"}";

		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");

		StringEntity se = new StringEntity(js);
		se.setContentType(CONTENT_TYPE_TEXT_JSON);

		httpPost.setEntity(se);

		CloseableHttpResponse response2 = null;

		response2 = client.execute(httpPost);
		HttpEntity entity2 = null;
		entity2 = response2.getEntity();
		String s2 = EntityUtils.toString(entity2, "UTF-8");
		return s2;
	}

	public static void main(String[] args) throws Exception {
		// HttpPostUtil u = new HttpPostUtil(
		// "http://192.168.0.144:80/FileUpload.aspx");
		// u.addFileParameter("img", new File("D:\\蛀茎蛾.JPG"));
		// byte[] b = u.send("file");
		// String result = new String(b);
		// System.out.println(result);
		// Gson gson = new Gson();
		// Type type = new TypeToken<Map<String, String>>() {
		// }.getType();
		// Map<String, String> map = gson.fromJson(result, type);
		// System.out.println(map.get("result") + "," + map.get("err"));
		// if (map.get("result") == "true" || "true".equals(map.get("result")))
		// {
		// HttpPostUtil _u = new HttpPostUtil(
		// "http://192.168.0.144:80/Survey.aspx?act=add&table=img");
		// _u.addTextParameter("date", "2015/3/11");
		// _u.addTextParameter("place", "河南省鹤壁市");
		// _u.addTextParameter("name", "guosj");
		// _u.addTextParameter("imagepath", map.get("err"));
		// _u.addTextParameter("note", "测试");
		// _u.addTextParameter("consult", "yes");
		// byte[] _b = _u.send("param");
		// String _result = new String(_b);
		// System.out.println(_result);
		// }
	}

}