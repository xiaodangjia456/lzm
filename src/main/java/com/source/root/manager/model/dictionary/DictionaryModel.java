package com.source.root.manager.model.dictionary;

import java.util.HashMap;
import java.util.Map;

public class DictionaryModel {

	public static Map<String,String> getListDictionary(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("SQ_", "申请/任务单状态");
		map.put("PINGJIA", "用户评价");
		map.put("ZHIFU", "支付方式");
		map.put("DEVICE_TYPE", "设备类型");
		map.put("TRAVEL", "出差方式");
		map.put("RIDE_TYPE", "交通工具");
		return map;
	}
}
