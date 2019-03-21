package com.source.root.tools.json;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.source.root.tools.json.bean.DateBean;
import com.source.root.tools.json.bean.JavaBean;
import com.source.root.tools.json.util.DateDeserializerUtils;
import com.source.root.tools.json.util.DateSerializerUtils;

/**
 * Google Gson鐟欙絾鐎絁son閺佺増宓佺�鐐扮伐
 * 
 * 1.Bean閵嗕福son鏉烆剚宕�testBeanJson() 2.List -> Json鏉烆剚宕�testList2Json()
 * 3.濞夋稑鐎稬ist閵嗕福son閻╅晲绨版潪顒佸床 testGenericList2Json() 4.Map -> Json鏉烆剚宕�testMap2Json()
 * 5.濞夋稑鐎稭ap閵嗕福son閻╅晲绨版潪顒佸床 testGenericMap2Json() 6.鐢附妫╅張鐔风潣閹潅ean閵嗕福son鏉烆剚宕�
 * testDateBeanJson() 7.鐢附妫╅張鐔风潣閹勭【閸ㄥ┌ist閵嗕福son鏉烆剚宕�testDateGenericListJson()
 * 
 * @author Lupeng
 * @create 2011-08-05
 * @modify 2011-08-06
 */
@SuppressWarnings("unchecked")
public class GsonTester {
	private Gson gson = new Gson();
	private GsonBuilder gsonBuilder = new GsonBuilder();

	// @Before
	// public void setUp() {
	// //gson = new Gson();
	// //gsonBuilder = new GsonBuilder();
	// }
	/**
	 * JavaBean閵嗕福son閻╅晲绨版潪顒佸床
	 * 
	 * @Test
	 */
	public void testBeanJson() {
		JavaBean bean = new JavaBean("1001", "scott", 20, "TL");

		// Bean -> Json
		String json = gson.toJson(bean);
		System.out.println(json);

		// Json -> Bean
		bean = gson.fromJson(json, JavaBean.class);
		System.out.println(bean);
	}

	/**
	 * List鏉烆剚宕查幋鎬瀞on鐎涙顑佹稉锟�
	 * 
	 * @Test
	 */
	public void testList2Json() {
		// List
		@SuppressWarnings("rawtypes")
		List list = new ArrayList();
		for (int i = 0; i < 5; i++) {
			list.add("element" + i);
		}
		System.out.println(list);

		// List -> Json
		String json = gson.toJson(list);
		System.out.println(json);
	}

	/**
	 * 濞夋稑鐎稬ist閵嗕福son閻╅晲绨版潪顒佸床
	 * 
	 * @Test
	 */
	public void testGenericListJson() {
		// 濞夋稑鐎稬ist
		List<JavaBean> list = new ArrayList<JavaBean>();
		for (int i = 0; i < 3; i++) {
			JavaBean user = new JavaBean("100" + i, "name" + i, 20 + i, "BJ"
					+ i);
			list.add(user);
		}
		System.out.println(list);

		// 濞夋稑鐎稬ist -> Json
		java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<List<JavaBean>>() {
		}.getType();
		String json = gson.toJson(list, type);
		System.out.println(json);

		// Json -> 濞夋稑鐎稬ist
		List<JavaBean> users = gson.fromJson(json.toString(), type);
		System.out.println(users);
	}

	/**
	 * Map鏉烆剚宕查幋鎬瀞on鐎涙顑佹稉锟�
	 * 
	 * @Test
	 */
	public void testMap2Json() {
		// Map閺佺増宓�
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("id", "1001");
		map.put("name", "scott");
		map.put("age", 20);
		map.put("addr", "BJ");
		System.out.println(map);

		// Map -> Json
		String json = gson.toJson(map);
		System.out.println(json);
	}

	/**
	 * 濞夋稑鐎稭ap閵嗕福son閻╅晲绨版潪顒佸床
	 * 
	 * @Test
	 */
	public void testGenericMapJson() {
		// 濞夋稑鐎稭ap閺佺増宓�
		Map<String, JavaBean> map = new HashMap<String, JavaBean>();
		for (int i = 0; i < 5; i++) {
			JavaBean user = new JavaBean("100" + i, "name" + i, 20 + i, "LN"
					+ i);
			map.put("100" + i, user);
		}
		System.out.println(map);

		// 濞夋稑鐎稭ap -> Json
		java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<Map<String, JavaBean>>() {
		}.getType();
		String json = gson.toJson(map, type);
		System.out.println(json);

		// Json -> Map
		Map<String, JavaBean> users = gson.fromJson(json.toString(), type);
		System.out.println(users);

	}

	/**
	 * 鐢附妫╅張鐔鸿閸ㄥ─ean閵嗕福son閻╅晲绨版潪顒佸床
	 * 
	 * @Test
	 */
	public void testDateBeanJson() {
		// 閺冦儲婀ean閺佺増宓�
		DateBean bean = new DateBean("1001", "scott", 20, new Date());

		// Bean(鐢附妫╅張鐔风潣閹拷 -> Json
		gson = gsonBuilder
				.registerTypeAdapter(java.util.Date.class,
						new DateSerializerUtils())
				.setDateFormat(DateFormat.LONG).create();
		String json = gson.toJson(bean);
		System.out.println(json);

		// Json -> Bean(鐢附妫╅張鐔鸿閸ㄥ鐫橀幀锟�
		gson = gsonBuilder
				.registerTypeAdapter(java.util.Date.class,
						new DateDeserializerUtils())
				.setDateFormat(DateFormat.LONG).create();
		java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<DateBean>() {
		}.getType();
		DateBean b = gson.fromJson(json, type);
		System.out.println(b);
	}

	/**
	 * 濞夋稑鐎烽弮銉︽埂List閵嗕福son閻╅晲绨版潪顒佸床
	 * 
	 * @Test
	 */
	public void testDateGenericListJson() {
		// 濞夋稑鐎烽弮銉︽埂List
		List<DateBean> list = new ArrayList<DateBean>();
		for (int i = 0; i < 3; i++) {
			DateBean user = new DateBean("100" + i, "name" + i, 20 + i,
					new Date());
			list.add(user);
		}
		System.out.println(list);

		// 濞夋稑鐎烽弮銉︽埂List -> Json
		gson = gsonBuilder
				.registerTypeAdapter(java.util.Date.class,
						new DateSerializerUtils())
				.setDateFormat(DateFormat.LONG).create();
		java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<List<DateBean>>() {
		}.getType();
		String json = gson.toJson(list, type);
		System.out.println(json);

		// Json -> 濞夋稑鐎烽弮銉︽埂List
		gson = gsonBuilder
				.registerTypeAdapter(java.util.Date.class,
						new DateDeserializerUtils())
				.setDateFormat(DateFormat.LONG).create();
		List<DateBean> users = gson.fromJson(json.toString(), type);
		System.out.println(users);
	}
	public static void main(String[] args) {
		GsonTester gt = new GsonTester();
//		gt.testGenericListJson();
		gt.testDateBeanJson();
	}
}