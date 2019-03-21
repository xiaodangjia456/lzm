package com.source.root.manager.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.source.root.manager.entity.Dictionary;
import com.source.root.manager.model.dictionary.DictionaryModel;
import com.source.root.manager.service.DictionaryService;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController extends BaseRestEasyController<Dictionary, java.lang.Integer> {

	@Autowired
	private DictionaryService dictionaryService;

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
		String type = request.getParameter("type");
		Query query = new Query();
		if (type != null && !type.isEmpty()) {
			if (type == "SQ_" || "SQ_".equals(type)) {
				query.addAndCondition("type", ConditionParams.LK, type);
			} else {
				query.addAndCondition("type", "'" + type + "'");
			}
		}
		int totalResult = dictionaryService.getCountByQuery(query);
		query.addPage(showCount, currentPage, totalResult);
		query.addOrder("id", "desc");
		List<Dictionary> list = dictionaryService.findPage(query);
		model.addAttribute("list", list);
		model.addAttribute("page", query.getPager());
		model.addAttribute("type", type);

		Map<String, String> map = new HashMap<String, String>();
		map = DictionaryModel.getListDictionary();
		model.addAttribute("d_map", map);

		return "min/dictionary/list";
	}

	/** 获取最新信息 */
	@Override
	public void getNewsData(@PathVariable("id") java.lang.Integer id, HttpServletRequest request,
			HttpServletResponse response, PrintWriter printWriter) {
		Query query = new Query();
		query.addAndCondition("id", ConditionParams.LG, id.toString());
		query.addOrder("id", "desc");
		List<Dictionary> list = dictionaryService.findAll(query);
		String resultJson = "";
		if (list.size() > 0) {
			resultJson = "[";
			for (Dictionary entity : list) {
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
		Dictionary dictionary = (Dictionary) dictionaryService.getById(id);
		model.addAttribute("item", dictionary);
		return "min/dictionary/show";
	}

	/** 显示 */
	@Override
	public Dictionary show(@PathVariable("id") java.lang.Integer id, HttpServletRequest request,
			HttpServletResponse response, Model model) throws Exception {
		Dictionary dictionary = (Dictionary) dictionaryService.getById(id);
		model.addAttribute("item", dictionary);
		return dictionary;
	}

	/** 进入新增 */
	@Override
	public String _new(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		model.addAttribute("item", new Dictionary());

		Map<String, String> map = new HashMap<String, String>();
		map = DictionaryModel.getListDictionary();
		model.addAttribute("d_map", map);

		return "min/dictionary/add";
	}

	/** 保存新增,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult */
	@Override
	public void create(Dictionary dictionary, HttpServletRequest request, HttpServletResponse response, PrintWriter printWriter)
			throws Exception {

		boolean result = dictionaryService.saveNotNull(dictionary);
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
		Dictionary dictionary = (Dictionary) dictionaryService.getById(id);
		model.addAttribute("item", dictionary);

		Map<String, String> map = new HashMap<String, String>();
		map = DictionaryModel.getListDictionary();
		model.addAttribute("d_map", map);
		return "min/dictionary/edit";
	}

	/** 保存更新,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult */
	@Override
	public void update(@PathVariable("id") java.lang.Integer id, Dictionary dictionary, HttpServletRequest request,
			HttpServletResponse response, PrintWriter printWriter) throws Exception {

		boolean result = dictionaryService.updateById(dictionary);
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

		boolean result = dictionaryService.deleteById(id);
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
		boolean result = dictionaryService.deleteByQuery(query);

		if (result) {
			printWriter.write(new RWReturnObject(200, "删除数据成功！").toString());
		} else {
			printWriter.write(new RWReturnObject(300, "删除数据失败！").toString());
		}
		printWriter.flush();
		printWriter.close();
	}

}
