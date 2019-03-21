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

import com.source.root.framework.comm.objectsutil.RWReturnObject;
import com.source.root.framework.comm.pager.ConditionParams;
import com.source.root.framework.comm.pager.Query;
import com.source.root.framework.template.web.controller.BaseRestEasyController;
import com.source.root.manager.entity.Roleresource;
import com.source.root.manager.service.RoleresourceService;

@Controller
@RequestMapping("/roleresource")
public class RoleresourceController extends BaseRestEasyController<Roleresource, java.lang.Integer> {

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
		int totalResult = roleresourceService.getCountByQuery(query);
		query.addPage(showCount, currentPage, totalResult);
		query.addOrder("id", "desc");
		List<Roleresource> list = roleresourceService.findPage(query);
		model.addAttribute("list", list);
		model.addAttribute("page", query.getPager());
		return "/roleresource/list";
	}

	/** 获取最新信息 */
	@Override
	public void getNewsData(@PathVariable("id") java.lang.Integer id, HttpServletRequest request,
			HttpServletResponse response, PrintWriter printWriter) {
		Query query = new Query();
		query.addAndCondition("id", ConditionParams.LG, id.toString());
		query.addOrder("id", "desc");
		List<Roleresource> list = roleresourceService.findAll(query);
		String resultJson = "";
		if (list.size() > 0) {
			resultJson = "[";
			for (Roleresource entity : list) {
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
		Roleresource roleresource = (Roleresource) roleresourceService.getById(id);
		model.addAttribute("roleresource", roleresource);
		return "/roleresource/show";
	}

	/** 显示 */
	@Override
	public Roleresource show(@PathVariable("id") java.lang.Integer id, HttpServletRequest request,
			HttpServletResponse response, Model model) throws Exception {
		Roleresource roleresource = (Roleresource) roleresourceService.getById(id);
		model.addAttribute("roleresource", roleresource);
		return roleresource;
	}

	/** 进入新增 */
	@Override
	public String _new(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		model.addAttribute("roleresource", new Roleresource());
		return "/roleresource/edit";
	}

	/** 保存新增,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult */
	@Override
	public void create(Roleresource roleresource, HttpServletRequest request, HttpServletResponse response,
			PrintWriter printWriter) {
		Query query = new Query();
		query.addAndCondition("roleId", roleresource.getRoleId().toString());
		roleresourceService.deleteByQuery(query);

		String[] resourceIds = request.getParameterValues("resourceId");
		int i = 0;
		if (resourceIds != null) {
			if (resourceIds.length > 0) {
				for (String r : resourceIds) {
					Roleresource rr = new Roleresource();
					rr.setRoleId(roleresource.getRoleId());
					rr.setResourceId(Integer.valueOf(r));
					boolean result = roleresourceService.saveNotNull(rr);
					if (result) {
						i++;
					}
				}
			}
		}
		if (i == resourceIds.length) {
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
		Roleresource roleresource = (Roleresource) roleresourceService.getById(id);
		model.addAttribute("roleresource", roleresource);
		return "/roleresource/edit";
	}

	/** 保存更新,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult */
	@Override
	public void update(@PathVariable("id") java.lang.Integer id, Roleresource roleresource, HttpServletRequest request,
			HttpServletResponse response, PrintWriter printWriter) throws Exception {

		boolean result = roleresourceService.updateById(roleresource);
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

		boolean result = roleresourceService.deleteById(id);
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
		boolean result = roleresourceService.deleteByQuery(query);

		if (result) {
			printWriter.write(new RWReturnObject(200, "删除数据成功！").toString());
		} else {
			printWriter.write(new RWReturnObject(300, "删除数据失败！").toString());
		}
		printWriter.flush();
		printWriter.close();
	}

}
