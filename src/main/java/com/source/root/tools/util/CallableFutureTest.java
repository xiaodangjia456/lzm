package com.source.root.tools.util;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
public class CallableFutureTest {
	@SuppressWarnings({"rawtypes", "unchecked"})
	public static void main(String[] args) throws ExecutionException,
			InterruptedException {
		CallableFutureTest test = new CallableFutureTest();

		// 创建一个线程池
		ExecutorService pool = Executors.newFixedThreadPool(2);
		// 创建两个有返回值的任务
		Callable c1 = test.new MyCallable("m1");
		Callable c2 = test.new MyCallable("m2");

		// 执行任务并获取Future对象
		Future f1 = pool.submit(c1);
		Future f2 = pool.submit(c2);

		// 从Future对象上获取任务的返回值，并输出到控制台
		System.out.println(">>>" + f1.get().toString());
		System.out.println(">>>" + f2.get().toString());

		// Map<String,String> map1 = new LinkedHashMap<String, String>();
		// Map<String,String> map2 = new LinkedHashMap<String, String>();
		//
		// map1 = (Map<String, String>) f1.get();
		// for (Map.Entry<String, String> entry : map1.entrySet()) {
		// System.out.println("map1==>key：" + entry.getKey() + " ， value： " +
		// entry.getValue());
		// }
		// map2 = (Map<String, String>) f2.get();
		// for (Map.Entry<String, String> entry : map2.entrySet()) {
		// System.out.println("map2==>key：" + entry.getKey() + " ， value： " +
		// entry.getValue());
		// }

		// 关闭线程池
		pool.shutdown();
	}
	@SuppressWarnings("rawtypes")
	class MyCallable implements Callable {
		private String oid;
		MyCallable(String oid) {
			this.oid = oid;
		}
		// public Map<String,String> call() throws Exception {
		// return map2(oid);
		// }
		// public Map<String,String> map2(String oid){
		// Map<String,String> map = new LinkedHashMap<String, String>();
		// if(oid=="m1" || "m1".equals(oid)){
		// map.put("aa", "AA");
		// map.put("bb", "BB");
		// map.put("cc", "CC");
		// }else if(oid=="m2" || "m2".equals(oid)){
		// map.put("a", "A");
		// map.put("b", "B");
		// map.put("c", "C");
		// }
		// return map;
		// }

		public Map<String, String> call() throws Exception {
			return map2(oid);
		}
		public Map<String, String> map2(String oid) {
			Map<String, String> map = new LinkedHashMap<String, String>();
			if (oid == "m1" || "m1".equals(oid)) {
				map.put("aa", "AA");
				map.put("bb", "BB");
				map.put("cc", "CC");
			} else if (oid == "m2" || "m2".equals(oid)) {
				map.put("a", "A");
				map.put("b", "B");
				map.put("c", "C");
			}
			return map;
		}
	}

}