package com.source.root.tools.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.source.root.framework.comm.objectsutil.RWReturnObject;
import com.source.root.manager.entity.User;
public class test {

	public static void main(String[] args) throws IOException {
		List<User> list = new ArrayList<User>();
		User user = new User();
		user.setId(1111);
		user.setName("张三");
		user.setRealName("zhangsan");
		list.add(user);
		list.add(user);
		list.add(user);
		list.add(user);
		
		RWReturnObject rwr = new RWReturnObject(200,"执行成功",list);
		System.out.println(rwr.toString());
	}
}
