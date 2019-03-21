package com.source.root.tools.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestListSortUtil {

	public static void main(String[] args) {
		List<Map<String, Object>> listA = new ArrayList<Map<String, Object>>();
		Map<String, Object> m1 = new HashMap<String, Object>();
		Map<String, Object> m2 = new HashMap<String, Object>();
		Map<String, Object> m3 = new HashMap<String, Object>();
		Map<String, Object> m4 = new HashMap<String, Object>();

		m1.put("aa", "aa");
		m2.put("aa", "bb");
		m3.put("aa", "cc");
		m4.put("aa", "dd");

		listA.add(m1);
		listA.add(m4);
		listA.add(m3);
		listA.add(m2);

		System.out.println("===============befor=============");
		for (int i = 0; i < listA.size(); i++) {
			System.out.println(listA.get(i).get("aa"));
		}

		Collections.sort(listA, new Comparator<Map<String, Object>>() {
			public int compare(Map<String, Object> arg0,
					Map<String, Object> arg1) {
				int result;
				result = ((String) arg0.get("aa")).compareTo((String) arg1
						.get("aa"));
				return result;
			}
		});

		System.out.println("===============end=============");

		for (int i = 0; i < listA.size(); i++) {
			System.out.println(listA.get(i).get("aa"));
		}

	}
}
