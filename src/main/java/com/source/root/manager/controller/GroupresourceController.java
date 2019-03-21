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
import com.source.root.framework.comm.pager.ConditionParams;
import com.source.root.framework.comm.pager.Query;
import com.source.root.framework.template.web.controller.BaseRestEasyController;
import com.source.root.manager.entity.Groupresource;
import com.source.root.manager.service.GroupresourceService;

@Controller
@RequestMapping("/groupresource")
public class GroupresourceController extends BaseRestEasyController<Groupresource, java.lang.Long> {

	@Autowired
	private GroupresourceService groupresourceService;

	@SuppressWarnings("unused")
	private final String LIST_ACTION = "redirect:/min/groupresource";

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
		int totalResult = groupresourceService.getCountByQuery(query);
		query.addPage(showCount, currentPage, totalResult);
		query.addOrder("id", "desc");
		List<Groupresource> list = groupresourceService.findPage(query);
		model.addAttribute("list", list);
		model.addAttribute("page", query.getPager());
		return "groupresource/index";
	}

	/** 获取最新信息 */
	@RequestMapping(value = "/get/news/by/bg/{id}")
	public void getNewsData(@PathVariable("id") java.lang.Long id, HttpServletRequest request,
			HttpServletResponse response, PrintWriter printWriter) {
		Query query = new Query();
		query.addAndCondition("id", ConditionParams.LG, id.toString());
		query.addOrder("id", "desc");
		List<Groupresource> list = groupresourceService.findAll(query);
		if (list.size() > 0) {
			String resultJson = "[";
			for (Groupresource entity : list) {
				resultJson += entity.getJson() + ",";
			}
			resultJson = resultJson.substring(0, resultJson.length() - 1) + "]";
			printWriter.write(resultJson);
		} else {
			printWriter.write("null");
		}
		printWriter.flush();
		printWriter.close();
	}

	/** 详细信息 */
	@Override
	public String showDetail(@PathVariable("id") java.lang.Long id, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		Groupresource groupresource = (Groupresource) groupresourceService.getById(id);
		model.addAttribute("groupresource", groupresource);
		return "";
	}

	/** 显示 */
	@Override
	public Groupresource show(@PathVariable("id") java.lang.Long id, HttpServletRequest request,
			HttpServletResponse response, Model model) throws Exception {
		Groupresource groupresource = (Groupresource) groupresourceService.getById(id);
		model.addAttribute("groupresource", groupresource);
		return groupresource;
	}

	/** 进入新增 */
	@Override
	public String _new(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		model.addAttribute("groupresource", new Groupresource());
		return "groupresource/new";
	}

	/** 保存新增,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult */
	@Override
	public void create(Groupresource groupresource, HttpServletRequest request, HttpServletResponse response,
			PrintWriter printWriter) throws Exception {
		boolean result = groupresourceService.saveNotNull(groupresource);
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
	public String edit(@PathVariable("id") java.lang.Long id, HttpServletRequest request, HttpServletResponse response,
			Model model) throws Exception {
		Groupresource groupresource = (Groupresource) groupresourceService.getById(id);
		model.addAttribute("groupresource", groupresource);
		return "groupresource/edit";
	}

	/** 保存更新,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult */
	@Override
	public void update(@PathVariable("id") java.lang.Long id, Groupresource groupresource, HttpServletRequest request,
			HttpServletResponse response, PrintWriter printWriter) throws Exception {
		boolean result = groupresourceService.updateById(groupresource);
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
		boolean result = groupresourceService.deleteById(id);
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
		String ids = "";
		for (int i = 0; i < items.length; i++) {
			ids += String.valueOf(items[i]) + ",";
		}
		ids = ids.substring(0, ids.length() - 1);
		Query query = new Query();
		query.addAndCondition("id", ConditionParams.IN, ids);
		boolean result = groupresourceService.deleteByQuery(query);
		if (result) {
			printWriter.write(new RWReturnObject(200, "删除数据成功！").toString());
		} else {
			printWriter.write(new RWReturnObject(300, "删除数据失败！").toString());
		}
		printWriter.flush();
		printWriter.close();
	}

	/** 删除 */
	@RequestMapping(value = "/{groupId}/{resourceId}", method = RequestMethod.DELETE)
	public void deleteByGroupResource(@PathVariable("groupId") java.lang.Long groupId,
			@PathVariable("resourceId") java.lang.Long resourceId, HttpServletRequest request,
			HttpServletResponse response, PrintWriter printWriter) {
		Query query = new Query();
		query.addAndCondition("groupId", groupId.toString());
		query.addAndCondition("resourceId", resourceId.toString());
		boolean result = groupresourceService.deleteByQuery(query);
		if (result) {
			printWriter.write(new RWReturnObject(200, "删除数据成功！").toString());
		} else {
			printWriter.write(new RWReturnObject(300, "删除数据失败！").toString());
		}
		printWriter.flush();
		printWriter.close();
	}

}
