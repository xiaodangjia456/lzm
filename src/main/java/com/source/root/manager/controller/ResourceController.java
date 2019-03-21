package com.source.root.manager.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
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
import com.source.root.framework.comm.pager.ConditionParams;
import com.source.root.framework.comm.pager.Query;
import com.source.root.framework.template.web.controller.BaseRestEasyController;
import com.source.root.manager.entity.Resource;
import com.source.root.manager.entity.Role;
import com.source.root.manager.entity.Roleresource;
import com.source.root.manager.model.resource.Level0;
import com.source.root.manager.model.resource.Level1;
import com.source.root.manager.model.resource.Level2;
import com.source.root.manager.service.ResourceService;
import com.source.root.manager.service.RoleService;
import com.source.root.manager.service.RoleresourceService;

@Controller
@RequestMapping("/resource")
public class ResourceController extends BaseRestEasyController<Resource, java.lang.Integer> {

	@Autowired
	private ResourceService resourceService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private RoleresourceService roleresourceService;

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
		String showCount = request.getParameter("showCount");
		String currentPage = request.getParameter("currentPage");
		Query query = new Query();
		int totalResult = resourceService.getCountByQuery(query);
		query.addPage(showCount, currentPage, totalResult);
		query.addOrder("id", "desc");
		List<Resource> list = resourceService.findPage(query);
		model.addAttribute("list", list);
		model.addAttribute("page", query.getPager());
		return "/resource/list";
	}

	/** 获取最新信息 */
	@Override
	public void getNewsData(@PathVariable("id") java.lang.Integer id, HttpServletRequest request,
			HttpServletResponse response, PrintWriter printWriter) {
		Query query = new Query();
		query.addAndCondition("id", ConditionParams.LG, id.toString());
		query.addOrder("id", "desc");
		List<Resource> list = resourceService.findAll(query);
		String resultJson = "";
		if (list.size() > 0) {
			resultJson = "[";
			for (Resource entity : list) {
				resultJson += entity.getJson() + ",";
			}
			resultJson = resultJson.substring(0, resultJson.length() - 1) + "]";
			printWriter.write(resultJson);
		} else {
			printWriter.write("");
		}
		printWriter.flush();
		printWriter.close();
	}

	/** 详细信息 */
	@Override
	public String showDetail(@PathVariable("id") java.lang.Integer id, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		Resource resource = (Resource) resourceService.getById(id);
		model.addAttribute("resource", resource);
		return "/resource/show";
	}

	/** 显示 */
	@Override
	public Resource show(@PathVariable("id") java.lang.Integer id, HttpServletRequest request,
			HttpServletResponse response, Model model) throws Exception {
		Resource resource = (Resource) resourceService.getById(id);
		model.addAttribute("resource", resource);
		return resource;
	}

	/** 进入新增 */
	@Override
	public String _new(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		model.addAttribute("resource", new Resource());
		return "/resource/edit";
	}

	/** 保存新增,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult */
	@Override
	public void create(Resource resource, HttpServletRequest request, HttpServletResponse response, PrintWriter printWriter)
			throws Exception {

		boolean result = resourceService.saveNotNull(resource);
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
	public String edit(@PathVariable("id") java.lang.Integer id, HttpServletRequest request,
			HttpServletResponse response, Model model) throws Exception {
		Resource resource = (Resource) resourceService.getById(id);
		model.addAttribute("resource", resource);
		return "/resource/edit";
	}

	/** 保存更新,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult */
	@Override
	public void update(@PathVariable("id") java.lang.Integer id, Resource resource, HttpServletRequest request,
			HttpServletResponse response, PrintWriter printWriter) throws Exception {

		boolean result = resourceService.updateById(resource);
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
	public void delete(@PathVariable("id") java.lang.Integer id, HttpServletRequest request,
			HttpServletResponse response, PrintWriter printWriter) {

		boolean result = resourceService.deleteById(id);
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
	public void batchDelete(@RequestParam("items") java.lang.Integer[] items, HttpServletRequest request,
			HttpServletResponse response, PrintWriter printWriter) {

		String ids = "";
		for (int i = 0; i < items.length; i++) {
			ids += String.valueOf(items[i]) + ",";
		}
		ids = ids.substring(0, ids.length() - 1);
		Query query = new Query();
		query.addAndCondition("id", ConditionParams.IN, ids);
		boolean result = resourceService.deleteByQuery(query);

		if (result) {
			printWriter.write(new RWReturnObject(200, "删除数据成功！").toString());
		} else {
			printWriter.write(new RWReturnObject(300, "删除数据失败！").toString());
		}
		printWriter.flush();
		printWriter.close();
	}

	@RequestMapping(value = "/get/resource/fenpei/page", method = RequestMethod.GET)
	public String getResource_FenPei_Page(HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		String roleId = request.getParameter("roleId");
		model.addAttribute("roleId", roleId);

		Query r_q = new Query();
		r_q.addAndCondition("levels", ConditionParams.NQ, "'ADMIN'");
		List<Role> r_list = roleService.findAll(r_q);
		model.addAttribute("r_list", r_list);

		if (roleId == null || roleId.isEmpty()) {
			roleId = r_list.get(0).getId().toString();
		}
		Query rr_q = new Query();
		rr_q.addAndCondition("roleId", roleId);
		List<Roleresource> rr_list = roleresourceService.findAll(rr_q);
		model.addAttribute("rr_list", rr_list);

		List<Level0> list_l0 = new ArrayList<Level0>();
		Query l0_q = new Query();
		l0_q.addAndCondition("levels", "0");
		l0_q.addAndCondition("isAbleTable", "'true'");
		List<Resource> l0_list = resourceService.findAll(l0_q);
		if (l0_list != null) {
			for (Resource r0 : l0_list) {
				Level0 l0 = new Level0();
				l0.setLevel0(r0);

				l0.setCheck("false");
				int rId0 = r0.getId();
				if (rr_list != null) {
					for (Roleresource rr : rr_list) {
						int r_rId = rr.getResourceId();
						if (rId0 == r_rId) {
							l0.setCheck("true");
						}
					}
				}
				List<Level1> list_l1 = new ArrayList<Level1>();
				Query l1_q = new Query();
				l1_q.addAndCondition("inheritCode", r0.getId().toString());
				l1_q.addAndCondition("levels", "1");
				l1_q.addAndCondition("isAbleTable", "'true'");
				List<Resource> l1_list = resourceService.findAll(l1_q);
				if (l1_list != null) {
					for (Resource r1 : l1_list) {
						Level1 l1 = new Level1();
						l1.setLevel1(r1);
						l1.setCheck("false");
						int rId1 = r1.getId();
						if (rr_list != null) {
							for (Roleresource rr : rr_list) {
								int r_rId = rr.getResourceId();
								if (rId1 == r_rId) {
									l1.setCheck("true");
								}
							}
						}
						List<Level2> list_l2 = new ArrayList<Level2>();
						Query l2_q = new Query();
						l2_q.addAndCondition("inheritCode", r1.getId().toString());
						l2_q.addAndCondition("levels", "2");
						l2_q.addAndCondition("isAbleTable", "'true'");
						List<Resource> l2_list = resourceService.findAll(l2_q);
						if (l2_list != null) {
							for (Resource r2 : l2_list) {
								Level2 l2 = new Level2();
								l2.setLevel2(r2);
								l2.setCheck("false");
								int rId2 = r2.getId();
								if (rr_list != null) {
									for (Roleresource rr : rr_list) {
										int r_rId = rr.getResourceId();
										if (rId2 == r_rId) {
											l2.setCheck("true");
										}
									}
								}
								list_l2.add(l2);
							}
						}
						l1.setLevel2(list_l2);
						list_l1.add(l1);
					}
				}
				l0.setLevel1(list_l1);
				list_l0.add(l0);
			}
		}
		model.addAttribute("list_l0", list_l0);
		return "min/roleresource/add";
	}
}
