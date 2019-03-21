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
import com.source.root.manager.entity.Chooseauthoritytype;
import com.source.root.manager.service.ChooseauthoritytypeService;

@Controller
@RequestMapping("/chooseauthoritytype")
public class ChooseauthoritytypeController extends BaseRestEasyController<Chooseauthoritytype, java.lang.Long> {

	@Autowired
	private ChooseauthoritytypeService chooseauthoritytypeService;

	@SuppressWarnings("unused")
	private final String LIST_ACTION = "redirect:/min/chooseauthoritytype";

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
		String showCount = request.getParameter("showCount");
		String currentPage = request.getParameter("currentPage");
		String _userName = request.getParameter("_userName");
		Query query = new Query();
		if (_userName != null && !"".equals(_userName)) {
			query.addAndCondition("name", ConditionParams.LK, _userName);
		}
		int totalResult = chooseauthoritytypeService.getCountByQuery(query);
		query.addPage(showCount, currentPage, totalResult);
		query.addOrder("id", "desc");
		List<Chooseauthoritytype> list = chooseauthoritytypeService
				.findPage(query);
		model.addAttribute("list", list);
		model.addAttribute("page", query.getPager());
		model.addAttribute("_userName", _userName);
		return "manager/Chooseauthoritytype/list";
	}

	/** 获取最新信息 */
	@Override
	public void getNewsData(@PathVariable("id") java.lang.Long id,
			HttpServletRequest request, HttpServletResponse response,
			PrintWriter printWriter) {
		Query query = new Query();
		query.addAndCondition("id", ConditionParams.LG, id.toString());
		query.addOrder("id", "desc");
		List<Chooseauthoritytype> list = chooseauthoritytypeService
				.findAll(query);
		if (list.size() > 0) {
			String resultJson = "[";
			for (Chooseauthoritytype entity : list) {
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
	public String showDetail(@PathVariable("id") java.lang.Long id,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		Chooseauthoritytype chooseauthoritytype = (Chooseauthoritytype) chooseauthoritytypeService
				.getById(id);
		model.addAttribute("chooseauthoritytype", chooseauthoritytype);
		return "";
	}

	/** 显示 */
	@Override
	public Chooseauthoritytype show(@PathVariable("id") java.lang.Long id,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws Exception {
		Chooseauthoritytype chooseauthoritytype = (Chooseauthoritytype) chooseauthoritytypeService
				.getById(id);
		model.addAttribute("entity", chooseauthoritytype);
		return chooseauthoritytype;
	}

	/** 进入新增 */
	@Override
	public String _new(HttpServletRequest request,
			HttpServletResponse response, Model model) throws Exception {
		model.addAttribute("entity", new Chooseauthoritytype());
		return "manager/Chooseauthoritytype/edit";
	}

	/** 保存新增,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult */
	@Override
	public void create(Chooseauthoritytype chooseauthoritytype,
			HttpServletRequest request, HttpServletResponse response,
			PrintWriter printWriter) throws Exception {
		String enable = chooseauthoritytype.getEnable();
		if (enable == "true" || "true".equals(enable)) {
			Query query = new Query();
			List<Chooseauthoritytype> list = chooseauthoritytypeService
					.findAll(query);
			if (list.size() > 0) {
				for (Chooseauthoritytype c : list) {
					c.setEnable("false");
					chooseauthoritytypeService.updateById(c);
				}
			}
		}
		boolean result = chooseauthoritytypeService
				.saveNotNull(chooseauthoritytype);
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
		Chooseauthoritytype chooseauthoritytype = (Chooseauthoritytype) chooseauthoritytypeService
				.getById(id);
		model.addAttribute("entity", chooseauthoritytype);
		return "manager/Chooseauthoritytype/edit";
	}

	/** 保存更新,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult */
	@Override
	public void update(@PathVariable("id") java.lang.Long id,
			Chooseauthoritytype chooseauthoritytype,
			HttpServletRequest request, HttpServletResponse response,
			PrintWriter printWriter) throws Exception {
		boolean result = false;
		String enable = chooseauthoritytype.getEnable();
		if (enable == "true" || "true".equals(enable)) {
			Query query = new Query();
			List<Chooseauthoritytype> list = chooseauthoritytypeService
					.findAll(query);
			if (list.size() > 0) {
				for (Chooseauthoritytype c : list) {
					if (c.getId().toString() == id.toString()
							|| id.toString().equals(c.getId().toString())) {
						result = chooseauthoritytypeService
								.updateById(chooseauthoritytype);
					} else {
						c.setEnable("false");
						chooseauthoritytypeService.updateById(c);
					}
				}
			}
		} else {
			result = chooseauthoritytypeService.updateById(chooseauthoritytype);
		}
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
		boolean result = chooseauthoritytypeService.deleteById(id);
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
		String ids = "";
		for (int i = 0; i < items.length; i++) {
			ids += String.valueOf(items[i]) + ",";
		}
		ids = ids.substring(0, ids.length() - 1);
		Query query = new Query();
		query.addAndCondition("id", ConditionParams.IN, ids);
		boolean result = chooseauthoritytypeService.deleteByQuery(query);
		if (result) {
			printWriter.write(new RWReturnObject(200, "删除数据成功！").toString());
		} else {
			printWriter.write(new RWReturnObject(300, "删除数据失败！").toString());
		}
		printWriter.flush();
		printWriter.close();
	}

}
