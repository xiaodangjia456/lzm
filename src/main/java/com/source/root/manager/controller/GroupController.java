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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.source.root.framework.comm.objectsutil.RWReturnObject;
import com.source.root.framework.comm.pager.Query;
import com.source.root.framework.template.web.controller.BaseRestEasyController;
import com.source.root.manager.entity.Chooseauthoritytype;
import com.source.root.manager.entity.City;
import com.source.root.manager.entity.Group;
import com.source.root.manager.entity.Groupresource;
import com.source.root.manager.entity.Resource;
import com.source.root.manager.service.ChooseauthoritytypeService;
import com.source.root.manager.service.CityService;
import com.source.root.manager.service.GroupService;
import com.source.root.manager.service.GroupareaService;
import com.source.root.manager.service.GroupresourceService;
import com.source.root.manager.service.ResourceService;
import com.source.root.manager.service.UsergroupService;

@Controller
@RequestMapping("/group")
public class GroupController extends BaseRestEasyController<Group, java.lang.Long> {

	@Autowired
	private GroupService groupService;
	@Autowired
	private CityService cityService;
	@Autowired
	private GroupresourceService groupresourceService;
	@Autowired
	private ResourceService resourceService;
	@Autowired
	private GroupareaService groupareaService;
	@Autowired
	private UsergroupService usergroupService;
	@Autowired
	private ChooseauthoritytypeService chooseauthoritytypeService;

	@SuppressWarnings("unused")
	private final String LIST_ACTION = "redirect:/group";

	/**
	 * 增加了@ModelAttribute的方法可以在本controller方法调用前执行,可以存放一些共享变量,如枚举值,或是一些初始化操作
	 */
	@ModelAttribute
	public void init(ModelMap model) {
		model.put("now", new java.sql.Timestamp(System.currentTimeMillis()));
	}

	/** 列表 */
	@Override
	public String index(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		return "manager/group/groupSearch";
	}

	/** 详细信息 */
	@Override
	public String showDetail(@PathVariable("id") java.lang.Long id,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		Group group = (Group) groupService.getById(id);
		model.addAttribute("group", group);
		return "";
	}

	/** 显示 */
	@Override
	public Group show(@PathVariable("id") java.lang.Long id,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws Exception {
		Group group = (Group) groupService.getById(id);
		model.addAttribute("group", group);
		return group;
	}

	/** 进入新增 */
	@Override
	public String _new(HttpServletRequest request,
			HttpServletResponse response, Model model) throws Exception {
		Query query = new Query();
		List<Group> list = groupService.findAll(query);
		model.addAttribute("groupList", list);
		List<Resource> r_list = resourceService.findAll(query);
		model.addAttribute("r_list", r_list);
		model.addAttribute("entity", new Group());

		Query query1 = new Query();
		query1.addAndCondition("inheritCode", "0");
		query1.addAndCondition("levels", "0");
		List<Resource> r_list1 = resourceService.findAll(query1);
		model.addAttribute("r_list1", r_list1);
		Query query2 = new Query();
		query2.addAndCondition("levels", "1");
		List<Resource> r_list2 = resourceService.findAll(query2);
		model.addAttribute("r_list2", r_list2);
		Query query3 = new Query();
		query3.addAndCondition("levels", "2");
		List<Resource> r_list3 = resourceService.findAll(query3);
		model.addAttribute("r_list3", r_list3);

		Query q = new Query();
		q.addAndCondition("enable", "'true'");
		List<Chooseauthoritytype> c_list = chooseauthoritytypeService
				.findAll(q);
		if (c_list.size() > 0) {
			Chooseauthoritytype cat = new Chooseauthoritytype();
			cat = c_list.get(0);
			model.addAttribute("Chooseauthoritytype", cat);
		} else {
			model.addAttribute("Chooseauthoritytype", new Chooseauthoritytype());
		}
		return "manager/group/groupAdd";
	}

	/** 保存新增,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult */
	@Override
	public void create(Group group, HttpServletRequest request,
			HttpServletResponse response, PrintWriter printWriter)
			throws Exception {
		boolean result = groupService.save(group);
		Group group_maxId = groupService.getByMaxId();
		String[] _resourceId = request.getParameterValues("_resourceId");
		if (_resourceId != null && !"".equals(_resourceId)) {
			for (String rId : _resourceId) {
				Query query = new Query();
				query.addAndCondition("groupId", group_maxId.getId().toString());
				query.addAndCondition("resourceId", rId);
				List<Groupresource> list = groupresourceService.findAll(query);
				if (list.size() < 1) {
					Groupresource entity = new Groupresource();
					entity.setGroupId(group_maxId.getId());
					entity.setResourceId(Long.valueOf(rId));
					groupresourceService.save(entity);
				}
			}
		}
		if (result) {
			printWriter.write(new RWReturnObject(200, "添加数据成功！").toString());
		} else {
			printWriter.write(new RWReturnObject(300, "添加数据失败！").toString());
		}
		printWriter.flush();
		printWriter.close();
	}

	/** 编辑 */
	@Override
	public String edit(@PathVariable("id") java.lang.Long id,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws Exception {
		Query query = new Query();
		List<Group> list = groupService.findAll(query);
		model.addAttribute("groupList", list);

		Group group = (Group) groupService.getById(id);
		model.addAttribute("entity", group);

		City city = cityService.getById(group.getAreaId());
		if (city != null && !"".equals(city)) {
			model.addAttribute("_areaName", city.getName());
		} else {
			model.addAttribute("_areaName", "");
		}

		Query gr_query = new Query();
		gr_query.addAndCondition("groupId", id.toString());
		List<Groupresource> gr_list = groupresourceService.findAll(gr_query);
		model.addAttribute("gr_list", gr_list);

		Query query1 = new Query();
		query1.addAndCondition("inheritCode", "0");
		query1.addAndCondition("levels", "0");
		List<Resource> r_list1 = resourceService.findAll(query1);
		model.addAttribute("r_list1", r_list1);
		Query query2 = new Query();
		query2.addAndCondition("levels", "1");
		List<Resource> r_list2 = resourceService.findAll(query2);
		model.addAttribute("r_list2", r_list2);
		Query query3 = new Query();
		query3.addAndCondition("levels", "2");
		List<Resource> r_list3 = resourceService.findAll(query3);
		model.addAttribute("r_list3", r_list3);
		Query q = new Query();
		q.addAndCondition("enable", "'true'");
		List<Chooseauthoritytype> c_list = chooseauthoritytypeService
				.findAll(q);
		if (c_list.size() > 0) {
			Chooseauthoritytype cat = new Chooseauthoritytype();
			cat = c_list.get(0);
			model.addAttribute("Chooseauthoritytype", cat);
		} else {
			model.addAttribute("Chooseauthoritytype", new Chooseauthoritytype());
		}
		return "manager/group/groupAdd";
	}

	/** 保存更新,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult */
	@Override
	public void update(@PathVariable("id") java.lang.Long id, Group group,
			HttpServletRequest request, HttpServletResponse response,
			PrintWriter printWriter) throws Exception {
		String[] _resourceId = request.getParameterValues("_resourceId");
		for (String rId : _resourceId) {
			Query query = new Query();
			query.addAndCondition("groupId", id.toString());
			query.addAndCondition("resourceId", rId);
			List<Groupresource> list = groupresourceService.findAll(query);
			if (list.size() < 1) {
				Groupresource entity = new Groupresource();
				entity.setGroupId(id);
				entity.setResourceId(Long.valueOf(rId));
				groupresourceService.save(entity);
			}
		}
		boolean result = groupService.updateById(group);
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
	public void delete(@PathVariable("id") java.lang.Long id,
			HttpServletRequest request, HttpServletResponse response,
			PrintWriter printWriter) {
		Query query = new Query();
		query.addAndCondition("groupId", id.toString());
		groupresourceService.deleteByQuery(query);
		groupareaService.deleteByQuery(query);
		usergroupService.deleteByQuery(query);
		boolean result = groupService.deleteById(id);
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
	public void batchDelete(@RequestParam("items") java.lang.Long[] items,
			HttpServletRequest request, HttpServletResponse response,
			PrintWriter printWriter) {
		for (int i = 0; i < items.length; i++) {
			groupService.deleteById(items[i]);
		}
		printWriter.write(new RWReturnObject(200, "").toString());
		printWriter.flush();
		printWriter.close();
	}

	@RequestMapping(value = "/get/json", produces = { "text/javascript;charset=UTF-8" })
	public @ResponseBody String getZtree(HttpServletRequest request,
			HttpServletResponse response) {
		Query query = new Query();
		String result = groupService.getZtree(query);
		return result;
	}

	@RequestMapping(value = "/get/Ztree/GroupAndUser", produces = { "text/javascript;charset=UTF-8" })
	public @ResponseBody String getZtreeGroupAndUser(
			HttpServletRequest request, HttpServletResponse response) {
		Query query = new Query();
		String result = groupService.getZtreeGroupAndUser(query);
		return result;
	}
}
