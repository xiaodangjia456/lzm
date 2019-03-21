package com.source.root.tools.file;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class ReadPropertiesUtil {

	private static ReadPropertiesUtil getProperties;
	private static String path = "/properties/";

	// private static Logger logger =
	// Logger.getLogger(ReadPropertiesUtil.class);

	/**
	 * 閸楁洑绶�-缁捐法鈻肩�澶婂弿 楠炴湹绗栭弫鍫㈠芳妤傦拷閼宠姤婀佹径姘嚋缁捐法鈻肩拋鍧楁６
	 */
	public static ReadPropertiesUtil getInstance() {
		if (getProperties == null) {
			synchronized (getProperties) {
				if (getProperties == null) {
					getProperties = new ReadPropertiesUtil();
				}
			}
		}
		return getProperties;
	}

	/**
	 * 濡楀棙鐏roperties閸忣剛鏁ら柊宥囩枂閺傚洣娆�
	 * 
	 * @param fileName
	 * @param key
	 * @return
	 */
	public static String propertiesReadByUrl(String fileName, String key) {
		String result = "";
		// -------URL 鐠囪褰噋roperties閺傚洣娆�-----
		URL appPropsUrl = Thread.currentThread().getContextClassLoader()
				.getResource(path + fileName + ".properties");
		if (appPropsUrl == null) {
			appPropsUrl = Thread.currentThread().getContextClassLoader()
					.getResource("properties.properties");
			if (appPropsUrl == null) {
				// logger.error("Sorry, Not find the file.--Properties--");
				return null;
			}
		}
		// 鐎涙濡ù锟�
		InputStream appStream = null;
		try {
			appStream = appPropsUrl.openStream();
		} catch (IOException e) {
			// logger.error(e);
			e.printStackTrace();
		}
		Properties p = new Properties();
		try {
			p.load(appStream); // 閸旂姾娴嘝roperties閺傚洣娆㈤崘鍛啇
		} catch (IOException e) {
			// logger.error(e);
			e.printStackTrace();
		}
		result = p.getProperty(key); // 閼惧嘲褰嘖ey鐎电懓绨查惃鍒卆lue
		return result;
	}

	public static String getResourceAsStream(String key) throws IOException {
		String result = "";
		// -------InputStream 鐠囪褰噋roperties閺傚洣娆�-----
		// InputStream in =
		// Object.class.getResourceAsStream("/test.properties");
		// InputStream in =
		// ReadProperties.class.getResourceAsStream("/test.properties");
		InputStream in = ReadPropertiesUtil.class.getClassLoader()
				.getResourceAsStream("properties.properties");
		Properties p1 = new Properties();
		p1.load(in);
		result = p1.getProperty(key);
		return result;
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		 String result = propertiesReadByUrl("properties","Ftp_Http_address");
		 System.out.println(result);
		// String result2 = propertiesReadByUrl("log4j.test.name");
		// System.out.println(result2);
		// String result1 = propertiesReadByFile("psw");
		// System.out.println(result1);
	}
}
