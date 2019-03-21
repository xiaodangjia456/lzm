
package com.source.root.site.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
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
import com.source.root.manager.entity.City;
import com.source.root.manager.entity.User;
import com.source.root.manager.service.CityService;
import com.source.root.manager.service.UserService;
import com.source.root.site.entity.Site;
import com.source.root.site.service.SiteService;
import com.source.root.tools.format.PinYinUtil;

@Controller
@RequestMapping("/site")
public class SiteController extends BaseRestEasyController<Site,java.lang.Integer>{

	@Autowired
	private SiteService siteService;
	@Autowired
	private CityService cityService;	
	@Autowired
	private UserService userService;
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
		String _siteName = request.getParameter("_siteName");
		String sheng = request.getParameter("sheng");
		String shi = request.getParameter("shi");
		String xian = request.getParameter("xian");
		String showCount = request.getParameter("showCount");
		String currentPage = request.getParameter("currentPage");
		
		Query query = new Query();
		// 管理员校验
		if(!role_levels.equals("ADMIN")){
			String siteIds = RMSAuthorityUtile.loginUserSiteIdString(request);
			if(StringUtils.isNotBlank(siteIds)){
				query.addAndCondition("id", ConditionParams.IN, siteIds);
			}else{
				query.addAndCondition("id", ConditionParams.IS, "null");
			}
		}
		if(sheng!=null && !sheng.isEmpty()){
			query.addAndCondition("sheng", "'"+sheng+"'");
		}
		if(shi!=null && !shi.isEmpty()){
			query.addAndCondition("shi", "'"+shi+"'");
		}
		if(xian!=null && !xian.isEmpty()){
			query.addAndCondition("xian", "'"+xian+"'");
		}
		if(_siteName!=null && !_siteName.isEmpty()){
			query.addAndCondition("siteName", ConditionParams.LK, _siteName);
		}
		int totalResult = siteService.getCountByQuery(query);
		query.addPage(showCount, currentPage, totalResult);
		query.addOrder("id", "desc");
		List<Site> list = siteService.findPage(query);
		if(list!=null){
			for(Site site:list){
				User user = new User();
				user = userService.getById(site.getOperater());
				site.setUser(user);
			}
		}
		
		// 地区（省）
		List<City> c_list = new ArrayList<City>();
		Query c_query = new Query();
		c_query.addAndCondition("level", "0");
		c_list = cityService.findAll(c_query);
		
		
		model.addAttribute("c_list", c_list);
		model.addAttribute("list", list);
		model.addAttribute("page", query.getPager());
		model.addAttribute("_siteName", _siteName);
		model.addAttribute("sheng", sheng);
		model.addAttribute("shi", shi);
		model.addAttribute("xian", xian);
		return "site_device/site/list";
	}

	
	/** 获取最新信息 */
	@Override
	public void getNewsData(@PathVariable("id") java.lang.Integer id,
			HttpServletRequest request, HttpServletResponse response,
			PrintWriter printWriter) {
		Query query = new Query();
		query.addAndCondition("id", ConditionParams.LG, id.toString());
		query.addOrder("id", "desc");
		List<Site> list = siteService.findAll(query);
		String resultJson = "";
		if (list.size() > 0) {
			resultJson = "[";
			for (Site entity : list) {
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
	public String showDetail(@PathVariable("id") java.lang.Integer id,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		Site site = (Site)siteService.getById(id);
		User user = new User();
		user = userService.getById(site.getOperater());
		site.setUser(user);
		model.addAttribute("item",site);
		return "site_device/site/show";
	}
	
	/** 显示 */
	@Override
	public Site show(@PathVariable("id") java.lang.Integer id, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		Site site = (Site)siteService.getById(id);
		model.addAttribute("item",site);
		return site;
	}

	/** 进入新增 */
	@Override
	public String _new(HttpServletRequest request,HttpServletResponse response, Model model) throws Exception {
		model.addAttribute("item", new Site());
		
		List<City> c_list = new ArrayList<City>();
		Query query = new Query();
		query.addAndCondition("level", "0");
		c_list = cityService.findAll(query);
		model.addAttribute("c_list", c_list);
		return "site_device/site/add";
	}
	
	/** 保存新增,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult  */
	@Override
	public void create(Site site, HttpServletRequest request, HttpServletResponse response, PrintWriter printWriter) throws Exception {
		int id = RMSAuthorityUtile.loginUserID(request);
		if(StringUtils.isNotBlank(site.getSiteName())){
			String siteAlias = PinYinUtil.LowerCase(site.getSiteName());
			site.setSiteAlias(siteAlias);
		}
		site.setCreateTime(new Date());
		site.setOperater(id);
		boolean result = siteService.saveNotNull(site);
		if (result) {
			printWriter.write(new RWReturnObject(200, "删除数据成功！").toString());
		} else {
			printWriter.write(new RWReturnObject(300, "删除数据失败！").toString());
		}
		printWriter.flush();
		printWriter.close();
	}
	
	/** 编辑 */
	@Override
	public String edit(@PathVariable("id") java.lang.Integer id, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		Site site = (Site)siteService.getById(id);
		model.addAttribute("item",site);
		
		List<City> c_list = new ArrayList<City>();
		Query query = new Query();
		query.addAndCondition("level", "0");
		c_list = cityService.findAll(query);
		model.addAttribute("c_list", c_list);
		return "site_device/site/edit";
	}
	
	/** 保存更新,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult  */
	@Override
	public void update(@PathVariable("id") java.lang.Integer id, Site site, HttpServletRequest request,HttpServletResponse response, PrintWriter printWriter) throws Exception {
		if(StringUtils.isNotBlank(site.getSiteName())){
			String siteAlias = PinYinUtil.LowerCase(site.getSiteName());
			site.setSiteAlias(siteAlias);
		}
		boolean result = siteService.updateById(site);
		if (result) {
			printWriter.write(new RWReturnObject(200, "删除数据成功！").toString());
		} else {
			printWriter.write(new RWReturnObject(300, "删除数据失败！").toString());
		}
		printWriter.flush();
		printWriter.close();
	}
	
	/** 删除 */
	@Override
	public void delete(@PathVariable("id") java.lang.Integer id, HttpServletRequest request, HttpServletResponse response, PrintWriter printWriter) {
		boolean result = siteService.deleteById(id);
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
		boolean result = siteService.deleteByQuery(query);
		if (result) {
			printWriter.write(new RWReturnObject(200, "删除数据成功！").toString());
		} else {
			printWriter.write(new RWReturnObject(300, "删除数据失败！").toString());
		}
		printWriter.flush();
		printWriter.close();
	}
	
}

