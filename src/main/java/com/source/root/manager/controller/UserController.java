package com.source.root.manager.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
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
import com.source.root.framework.template.web.other.RMSAuthorityUtile;
import com.source.root.manager.entity.Role;
import com.source.root.manager.entity.SiteUser;
import com.source.root.manager.entity.User;
import com.source.root.manager.service.RoleService;
import com.source.root.manager.service.SiteUserService;
import com.source.root.manager.service.UserService;
import com.source.root.site.entity.Site;
import com.source.root.site.service.SiteService;
import com.source.root.tools.util.MD5Util;

@Controller
@RequestMapping("/user")
public class UserController extends BaseRestEasyController<User, java.lang.Integer> {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private SiteService siteService;
	@Autowired
	private SiteUserService siteuserService;
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

		String showCount = request.getParameter("showCount");
		String currentPage = request.getParameter("currentPage");
		String _userName = request.getParameter("_userName");
		String roleId = request.getParameter("roleId");
		String companyId = request.getParameter("companyId");
		String enabled = request.getParameter("enabled");
		Query query = new Query();
		if (_userName != null && !"".equals(_userName)) {
			query.addAndCondition("name", ConditionParams.LK, _userName);
		}
		if (roleId != null && !"".equals(roleId)) {
			query.addAndCondition("roleId", roleId);
		}
		if (companyId != null && !"".equals(companyId)) {
			query.addAndCondition("companyId", companyId);
		}
		if (enabled != null && !"".equals(enabled)) {
			query.addAndCondition("enabled", "'" + enabled + "'");
		}
		int totalResult = userService.getCountByQuery(query);
		query.addPage(showCount, currentPage, totalResult);
		query.addOrder("id", "desc");
		List<User> list = userService.findPage(query);
		if (list != null) {
			for (User user : list) {
				Role role = new Role();
				role = roleService.getById(user.getRoleId());
				user.setRole(role);
				User userOperater = new User();
				userOperater = userService.getById(user.getOperater());
				user.setUserOperater(userOperater);
			}
		}

		List<Role> r_list = new ArrayList<Role>();
		r_list = roleService.findAll(new Query());

		model.addAttribute("_userName", _userName);
		model.addAttribute("companyId", companyId);
		model.addAttribute("roleId", roleId);
		model.addAttribute("r_list", r_list);
		model.addAttribute("list", list);
		model.addAttribute("page", query.getPager());
		return "min/user/list";
	}

	/** 获取最新信息 */
	@Override
	public void getNewsData(@PathVariable("id") java.lang.Integer id, HttpServletRequest request, HttpServletResponse response, PrintWriter printWriter) {
		Query query = new Query();
		query.addAndCondition("id", ConditionParams.LG, id.toString());
		query.addOrder("id", "desc");
		List<User> list = userService.findAll(query);
		String resultJson = "";
		if (list.size() > 0) {
			resultJson = "[";
			for (User entity : list) {
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
	public String showDetail(@PathVariable("id") java.lang.Integer id, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = (User) userService.getById(id);
		if (user != null) {
			Role role = new Role();
			role = roleService.getById(user.getRoleId());
			user.setRole(role);
			User userOperater = new User();
			userOperater = userService.getById(user.getOperater());
			user.setUserOperater(userOperater);
		}
		model.addAttribute("item", user);
		return "min/user/show";
	}

	/** 显示 */
	@Override
	public User show(@PathVariable("id") java.lang.Integer id, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		User user = (User) userService.getById(id);
		model.addAttribute("item", user);
		return user;
	}

	/** 进入新增 */
	@Override
	public String _new(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		List<Role> r_list = new ArrayList<Role>();
		r_list = roleService.findAll(new Query());
		model.addAttribute("r_list", r_list);

		model.addAttribute("item", new User());
		return "min/user/add";
	}

	/** 保存新增,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult */
	@Override
	public void create(User user, HttpServletRequest request, HttpServletResponse response, PrintWriter printWriter) {
		user.setEnabled("false");
		user.setPassword(MD5Util.MD5(user.getRealPassword()));
		boolean result = userService.saveNotNull(user);
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
		User u = RMSAuthorityUtile.loginUser(request);
		model.addAttribute("u", u);
		List<Role> r_list = new ArrayList<Role>();
		Query r_query = new Query();
		if (u.getCompanyId() != null && u.getCompanyId() > 0) {
			r_query.addAndCondition("id", u.getRoleId().toString());
		}
		r_list = roleService.findAll(r_query);
		model.addAttribute("r_list", r_list);

		User user = (User) userService.getById(id);
		model.addAttribute("item", user);

		return "min/user/edit";
	}

	/** 保存更新,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult */
	@Override
	public void update(@PathVariable("id") java.lang.Integer id, User user, HttpServletRequest request, HttpServletResponse response, PrintWriter printWriter) {

		user.setPassword(MD5Util.MD5(user.getRealPassword()));
		boolean result = userService.updateById(user);
		if (result) {
			printWriter.write(new RWReturnObject(200, "修改数据成功！").toString());
		} else {
			printWriter.write(new RWReturnObject(300, "修改数据失败！").toString());
		}
		printWriter.flush();
		printWriter.close();
	}

	/** 保存更新,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult */
	@RequestMapping(value = "/{id}/enabled/{enabled}", method = RequestMethod.POST)
	public void update(@PathVariable("id") java.lang.Integer id, @PathVariable("enabled") java.lang.String enabled, User user, HttpServletRequest request, HttpServletResponse response, PrintWriter printWriter) throws Exception {
		User u = RMSAuthorityUtile.loginUser(request);
		user.setOperater(u.getId());
		user.setOperatTime(new Date());
		user.setId(id);
		if (enabled == "ok" || "ok".equals(enabled)) {
			user.setEnabled("true");
		} else {
			user.setEnabled("false");
		}
		boolean result = userService.updateById(user);
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

		boolean result = userService.deleteById(id);
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
		for (int i = 0; i < items.length; i++) {
			ids += String.valueOf(items[i]) + ",";
		}
		ids = ids.substring(0, ids.length() - 1);
		Query query = new Query();
		query.addAndCondition("id", ConditionParams.IN, ids);
		boolean result = userService.deleteByQuery(query);

		if (result) {
			printWriter.write(new RWReturnObject(200, "删除数据成功！").toString());
		} else {
			printWriter.write(new RWReturnObject(300, "删除数据失败！").toString());
		}
		printWriter.flush();
		printWriter.close();
	}

	/** 用户分配站点 */
	@RequestMapping(value = "/{id}/init/site/fenpei/page")
	public String initFenPeiPage(@PathVariable("id") java.lang.Integer id, HttpServletRequest request, HttpServletResponse response, Model model) {
		User user = userService.getById(id);
		List<Site> list = siteService.findAll(new Query());
		Query query = new Query();
		query.addAndCondition("userId", id.toString());
		List<SiteUser> su_list = siteuserService.findAll(query);
		// 站点信息
		if (list != null && list.size() > 0) {
			for (Site site : list) {
				int siteId = site.getId();
				// 站点分配信息
				if (su_list != null && su_list.size() > 0) {
					for(SiteUser su : su_list){
						int su_siteId = su.getSiteId();
						if(siteId == su_siteId){
							site.setCheck("true");
						}
					}
				}
			}
		}
		model.addAttribute("user", user);
		model.addAttribute("list", list);
		model.addAttribute("userId", id);
		return "min/siteuser/add";
	}

}
