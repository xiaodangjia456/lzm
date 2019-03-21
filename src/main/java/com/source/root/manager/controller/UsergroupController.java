package com.source.root.manager.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.source.root.framework.comm.objectsutil.RWReturnObject;
import com.source.root.framework.comm.pager.Query;
import com.source.root.framework.template.web.controller.BaseRestEasyController;
import com.source.root.manager.entity.Group;
import com.source.root.manager.entity.User;
import com.source.root.manager.entity.Usergroup;
import com.source.root.manager.service.GroupService;
import com.source.root.manager.service.UserService;
import com.source.root.manager.service.UsergroupService;

@Controller
@RequestMapping("/usergroup")
public class UsergroupController extends BaseRestEasyController<Usergroup, java.lang.Long> {

	@Autowired
	private UsergroupService usergroupService;
	@Autowired
	private GroupService groupService;
	@Autowired
	private UserService userService;

	@SuppressWarnings("unused")
	private final String LIST_ACTION = "redirect:/usergroup";

	/**
	 * 增加了@ModelAttribute的方法可以在本controller方法调用前执行,可以存放一些共享变量,如枚举值,或是一些初始化操作
	 */
	@ModelAttribute
	public void init(ModelMap model) {
		model.put("now", new java.sql.Timestamp(System.currentTimeMillis()));
	}

	/** 列表 */
	@Override
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) {

		return "";
	}

	/** 详细信息 */
	@Override
	public String showDetail(@PathVariable("id") java.lang.Long id, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		Usergroup usergroup = (Usergroup) usergroupService.getById(id);
		model.addAttribute("usergroup", usergroup);
		return "";
	}

	/** 显示 */
	@Override
	public Usergroup show(@PathVariable("id") java.lang.Long id, HttpServletRequest request,
			HttpServletResponse response, Model model) throws Exception {
		Usergroup usergroup = (Usergroup) usergroupService.getById(id);
		model.addAttribute("usergroup", usergroup);
		return usergroup;
	}

	/** 进入新增 */
	@Override
	public String _new(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		Query query = new Query();
		List<Group> list = groupService.findAll(query);
		model.addAttribute("list", list);
		return "manager/group/addUserSearch";
	}

	/** 保存新增,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult */
	@Override
	public void create(Usergroup usergroup, HttpServletRequest request, HttpServletResponse response,
			PrintWriter printWriter) throws Exception {
		Query query = new Query();
		query.addAndCondition("userId", usergroup.getUserId().toString());
		List<Usergroup> list = usergroupService.findAll(query);
		if (list.size() < 1) {
			boolean result = usergroupService.save(usergroup);
			if (result) {
				printWriter.write(new RWReturnObject(200, "添加数据成功！").toString());
			} else {
				printWriter.write(new RWReturnObject(300, "添加数据失败！").toString());
			}
		} else {
			printWriter.write(new RWReturnObject(100, "该用户已在其它组中存在！").toString());
		}
		printWriter.flush();
		printWriter.close();
	}

	/** 编辑 */
	@Override
	public String edit(@PathVariable("id") java.lang.Long id, HttpServletRequest request, HttpServletResponse response,
			Model model) throws Exception {
		Usergroup usergroup = (Usergroup) usergroupService.getById(id);
		model.addAttribute("usergroup", usergroup);
		return "usergroup/edit";
	}

	/** 保存更新,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult */
	@Override
	public void update(@PathVariable("id") java.lang.Long id, Usergroup usergroup, HttpServletRequest request,
			HttpServletResponse response, PrintWriter printWriter) throws Exception {
		boolean result = usergroupService.update(usergroup);
		if (result) {
			printWriter.write(new RWReturnObject(200, "修改数据成功！").toString());
		} else {
			printWriter.write(new RWReturnObject(300, "修改数据失败！").toString());
		}
		printWriter.flush();
		printWriter.close();
	}

	/** 删除 */
	@Override
	public void delete(@PathVariable("id") java.lang.Long id, HttpServletRequest request, HttpServletResponse response,
			PrintWriter printWriter) {
		boolean result = usergroupService.deleteById(id);
		if (result) {
			printWriter.write(new RWReturnObject(200, "删除数据成功！").toString());
		} else {
			printWriter.write(new RWReturnObject(300, "删除数据失败！").toString());
		}
		printWriter.flush();
		printWriter.close();
	}

	/** 删除 */
	@RequestMapping(value = "/del/{groupId}/{userId}", method = RequestMethod.DELETE)
	public void deleteByGroupAndUserId(@PathVariable("groupId") java.lang.String groupId,
			@PathVariable("userId") java.lang.String userId, HttpServletRequest request, HttpServletResponse response,
			PrintWriter printWriter) {
		Query query = new Query();
		query.addAndCondition("groupId", groupId);
		query.addAndCondition("userId", userId);
		boolean result = usergroupService.deleteByQuery(query);
		if (result) {
			printWriter.write(new RWReturnObject(200, "删除数据成功！").toString());
		} else {
			printWriter.write(new RWReturnObject(300, "删除数据失败！").toString());
		}
		printWriter.flush();
		printWriter.close();
	}

	/** 批量删除 */
	@Override
	public void batchDelete(@RequestParam("items") java.lang.Long[] items, HttpServletRequest request,
			HttpServletResponse response, PrintWriter printWriter) {
		for (int i = 0; i < items.length; i++) {
			usergroupService.deleteById(items[i]);
		}
		printWriter.write(new RWReturnObject(200, "").toString());
		printWriter.flush();
		printWriter.close();
	}

	/** 组织用户关联 */
	@RequestMapping(value = "/get/json")
	public void toJson(HttpServletRequest request, HttpServletResponse response, Model model, PrintWriter printWriter) {
		String groupId = request.getParameter("groupId");
		Query query = new Query();
		List<User> list = userService.findAll(query);
		String jsonResult = "[";
		for (User user : list) {
			if (groupId != null && !groupId.isEmpty()) {
				int i = 0;
				Query _query = new Query();
				_query.addAndCondition("groupId", groupId);
				List<Usergroup> ugList = usergroupService.findAll(_query);
				for (Usergroup ug : ugList) {
					String uId = String.valueOf(user.getId());
					String ugId = String.valueOf(ug.getUserId());
					if (uId == ugId || uId.equals(ugId)) {
						jsonResult += "{'id':" + user.getId() + ", 'pId':0" + ",'name':'" + user.getRealName()
								+ "','open':true, checked:true},";
						i = i + 1;
					}
				}
				if (i < 1) {
					jsonResult += "{'id':" + user.getId() + ", 'pId':0" + ",'name':'" + user.getRealName()
							+ "','open':true},";
				}
			} else {
				jsonResult += "{'id':" + user.getId() + ", 'pId':0" + ",'name':'" + user.getRealName()
						+ "','open':true},";
			}
		}
		jsonResult = jsonResult.substring(0, jsonResult.length() - 1) + "]";
		printWriter.write(jsonResult);
		printWriter.flush();
		printWriter.close();
	}
}
