package com.source.root.manager.controller;

import java.io.PrintWriter;

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
import com.source.root.framework.template.web.controller.BaseRestEasyController;
import com.source.root.manager.entity.Grouparea;
import com.source.root.manager.service.GroupareaService;

@Controller
@RequestMapping("/grouparea")
public class GroupareaController extends BaseRestEasyController<Grouparea, java.lang.Long> {

	@Autowired
	private GroupareaService groupareaService;

	@SuppressWarnings("unused")
	private final String LIST_ACTION = "redirect:/grouparea";

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
		return "grouparea/index";
	}

	/** 详细信息 */
	@Override
	public String showDetail(@PathVariable("id") java.lang.Long id,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		Grouparea grouparea = (Grouparea) groupareaService.getById(id);
		model.addAttribute("grouparea", grouparea);
		return "";
	}

	/** 显示 */
	@Override
	public Grouparea show(@PathVariable("id") java.lang.Long id,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws Exception {
		Grouparea grouparea = (Grouparea) groupareaService.getById(id);
		model.addAttribute("grouparea", grouparea);
		return grouparea;
	}

	/** 进入新增 */
	@Override
	public String _new(HttpServletRequest request,
			HttpServletResponse response, Model model) throws Exception {
		model.addAttribute("grouparea", new Grouparea());
		return "grouparea/new";
	}

	/** 保存新增,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult */
	@Override
	public void create(Grouparea grouparea, HttpServletRequest request,
			HttpServletResponse response, PrintWriter printWriter)
			throws Exception {
		boolean result = groupareaService.save(grouparea);
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
		Grouparea grouparea = (Grouparea) groupareaService.getById(id);
		model.addAttribute("grouparea", grouparea);
		return "grouparea/edit";
	}

	/** 保存更新,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult */
	@Override
	public void update(@PathVariable("id") java.lang.Long id,
			Grouparea grouparea, HttpServletRequest request,
			HttpServletResponse response, PrintWriter printWriter)
			throws Exception {
		boolean result = groupareaService.update(grouparea);
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
		boolean result = groupareaService.deleteById(id);
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
			groupareaService.deleteById(items[i]);
		}
		printWriter.write(new RWReturnObject(200, "").toString());
		printWriter.flush();
		printWriter.close();
	}

}
