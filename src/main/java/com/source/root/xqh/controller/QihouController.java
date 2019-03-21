
package com.source.root.xqh.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
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
import com.source.root.framework.template.web.other.RMSAuthorityUtile;
import com.source.root.site.entity.Site;
import com.source.root.xqh.entity.Qihou;
import com.source.root.xqh.service.QihouService;

@Controller
@RequestMapping("/qihou")
public class QihouController extends BaseRestEasyController<Qihou,java.lang.Integer>{

	@Autowired
	private QihouService qihouService;
	@Autowired
	private RMSAuthorityUtile RMSAuthorityUtile;

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
		String role_levels = RMSAuthorityUtile.loginUserRoleLevels(request);
		String showCount = request.getParameter("showCount");
		String currentPage = request.getParameter("currentPage");
		String siteId = request.getParameter("siteId");
		Query query = new Query();

		if (!role_levels.equals("ADMIN")) {
			String siteIds = RMSAuthorityUtile.loginUserSiteIdString(request);
			if (StringUtils.isNotBlank(siteIds)) {
				query.addAndCondition("siteId", ConditionParams.IN, siteIds);
			} else {
				query.addAndCondition("siteId", ConditionParams.IS, "null");
			}
		} else {
			// 管理员
			if (StringUtils.isNotBlank(siteId)) {
				query.addAndCondition("siteId", siteId);
			}
		}
		int totalResult = qihouService.getCountByQuery(query);
		query.addPage(showCount, currentPage, totalResult);
		query.addOrder("id", "desc");
		List<Qihou> list = qihouService.findPage(query);
		model.addAttribute("list", list);
		model.addAttribute("siteId", siteId);
		model.addAttribute("page", query.getPager());
		// 当前用户所有站点
		List<Site> s_List = RMSAuthorityUtile.loginUserSite(request);
		model.addAttribute("s_List", s_List);
		return "qixiang/qihou/list";
	}

	
	/** 获取最新信息 */
	@Override
	public void getNewsData(@PathVariable("id") java.lang.Integer id,
			HttpServletRequest request, HttpServletResponse response, PrintWriter printWriter) {
		Query query = new Query();
		query.addAndCondition("id", ConditionParams.LG, id.toString());
		query.addOrder("id", "desc");
		List<Qihou> list = qihouService.findAll(query);
		String resultJson = "";
		if (list.size() > 0) {
			resultJson = "[";
			for (Qihou entity : list) {
				resultJson += entity.getJson() + ",";
			}
			resultJson = resultJson.substring(0, resultJson.length() - 1) + "]";
		} 
		printWriter.write(resultJson);
		printWriter.flush();
		printWriter.close();
	}


	/** 详细信息 */
	@Override
	public String showDetail(@PathVariable("id") java.lang.Integer id,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		Qihou qihou = (Qihou)qihouService.getById(id);
		model.addAttribute("qihou",qihou);
		return "";
	}
	
	/** 显示 */
	@Override
	public Qihou show(@PathVariable("id") java.lang.Integer id, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		Qihou qihou = (Qihou)qihouService.getById(id);
		model.addAttribute("qihou",qihou);
		return qihou;
	}

	/** 进入新增 */
	@Override
	public String _new(HttpServletRequest request,HttpServletResponse response, Model model) throws Exception {
		model.addAttribute("qihou", new Qihou());
		return "/qihou/new";
	}
	
	/** 保存新增,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult  */
	@Override
	public void create(Qihou qihou, HttpServletRequest request, HttpServletResponse response, PrintWriter printWriter) throws Exception {
		boolean result = qihouService.saveNotNull(qihou);
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
	public String edit(@PathVariable("id") java.lang.Integer id, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		Qihou qihou = (Qihou)qihouService.getById(id);
		model.addAttribute("qihou",qihou);
		return "/qihou/edit";
	}
	
	/** 保存更新,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult  */
	@Override
	public void update(@PathVariable("id") java.lang.Integer id, Qihou qihou, HttpServletRequest request,HttpServletResponse response, PrintWriter printWriter) throws Exception {
		boolean result = qihouService.updateById(qihou);
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
	public void delete(@PathVariable("id") java.lang.Integer id, HttpServletRequest request, HttpServletResponse response, PrintWriter printWriter) {
		boolean result = qihouService.deleteById(id);
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
	public void batchDelete(@RequestParam("items") java.lang.Integer[] items, HttpServletRequest request, HttpServletResponse response, PrintWriter printWriter) {
		String ids = "";
		for(int i = 0; i < items.length; i++) {
			ids += String.valueOf(items[i]) + ",";
		}
		ids = ids.substring(0, ids.length() - 1);
		Query query = new Query();
		query.addAndCondition("id", ConditionParams.IN, ids);
		boolean result = qihouService.deleteByQuery(query);
		if (result) {
			printWriter.write(new RWReturnObject(200, "删除数据成功！").toString());
		} else {
			printWriter.write(new RWReturnObject(300, "删除数据失败！").toString());
		}
		printWriter.flush();
		printWriter.close();
	}
	
}

