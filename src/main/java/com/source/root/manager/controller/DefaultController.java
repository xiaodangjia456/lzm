package com.source.root.manager.controller;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.source.root.framework.comm.objectsutil.RWReturnObject;
import com.source.root.framework.comm.pager.Query;
import com.source.root.framework.interceptor.aop.AopMthod;
import com.source.root.framework.template.web.other.RMSAuthorityUtile;
import com.source.root.manager.entity.Logs;
import com.source.root.manager.entity.Role;
import com.source.root.manager.entity.User;
import com.source.root.manager.model.menu.LeftMenu1Model;
import com.source.root.manager.service.LogsService;
import com.source.root.manager.service.ResourceService;
import com.source.root.manager.service.RoleService;
import com.source.root.manager.service.UserService;
import com.source.root.tools.util.MD5Util;

@Controller
@RequestMapping(value = "/default")
@SuppressWarnings({ "unused", "deprecation" })
public class DefaultController {
	@Autowired
	private UserService userService;
	@Autowired
	private ResourceService resourceService;
	@Autowired
	private LogsService logsService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private RMSAuthorityUtile RMSAuthorityUtile;

	private static Logger logger = Logger.getLogger(AopMthod.class);

	/**
	 * 主框架页面,包括top、center和bottom
	 * 
	 * @return
	 */
	@RequestMapping(value = "/welcome")
	public String welcome(HttpServletRequest request, HttpServletResponse response, Model model) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null || "".equals(user)) {
			return "login";
		}
		Role role = new Role();
		role = roleService.getById(user.getRoleId());
		user.setRole(role);
		model.addAttribute("user", user);
		if (user != null) {
			return "min/iframe/welcome";
		} else {
			return "login";
		}
	}

	@RequestMapping(value = "/get/left/menu")
	public void getLeftMenuResource(HttpServletRequest request, HttpServletResponse response, PrintWriter printWriter) {
		List<LeftMenu1Model> list = new ArrayList<LeftMenu1Model>();
		list = resourceService.getLeftMenu(request);
		String resultJson = "";
		Gson gson = new Gson();
		Type type = new TypeToken<List<LeftMenu1Model>>() {
		}.getType();
		resultJson = gson.toJson(list, type);
		printWriter.write(resultJson);
		printWriter.flush();
		printWriter.close();
	}

	/**
	 * 框架页（底部）
	 * 
	 * @param session
	 * @param model
	 * @return
	 * @author Mr.Hao
	 * @version 2013-1-4 下午02:54:55
	 */
	@RequestMapping(value = "/right")
	public String toRightPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "min/iframe/right";
	}

	/**
	 * 框架页（底部）
	 * 
	 * @param session
	 * @param model
	 * @return
	 * @author Mr.Hao
	 * @version 2013-1-4 下午02:54:55
	 */
	@RequestMapping(value = "/tologin")
	public String tologin(HttpServletRequest request, HttpServletResponse response, Model model) {
		Cookie[] cookies = request.getCookies();
		String userName = "";
		String pwd = "";
		String user[] = new String[2];
		if (cookies != null) {
			for (Cookie coo : cookies) {
				if (coo.getName() == "cookie_User" || "cookie_User".equals(coo.getName())) {
					String user_msg = coo.getValue();
					user = user_msg.split("_");
					userName = user[0];
					pwd = user[1];
				}
			}
			Query query = new Query();
			query.addAndCondition("name", "'" + userName + "'");
			query.addAndCondition("password", "'" + MD5Util.MD5(pwd) + "'");
			query.addAndCondition("enabled", "'true'");
			List<User> users = userService.findAll(query);
			int size = users.size();
			if (size > 0) {
				HttpSession session = request.getSession();
				session.setAttribute("user", users.get(0));
				session.setAttribute("userName", userName);
				Logs logs = new Logs();
				logs.setCreatTime(new Date());
				logs.setMethod("getLogin");
				logs.setRecord("用户登陆成功!");
				logs.setTableName("user");
				logs.setUser("id:" + users.get(0).getId() + ",name:" + users.get(0).getName());
				String ipAddr = RMSAuthorityUtile.getIpAddr(request);
				logs.setIpAddr(ipAddr);
				logsService.save(logs);

				logger.error("恭喜您，" + users.get(0).getName() + "登陆成功!");
				return "redirect:/min/default/welcome";
			} else {
				return "login";
			}
		} else {
			return "login";
		}
	}

	/**
	 * 框架页（底部）
	 * 
	 * @param session
	 * @param model
	 * @return
	 * @author Mr.Hao
	 * @version 2013-1-4 下午02:54:55
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void getLogin(HttpServletRequest request, HttpServletResponse response, PrintWriter printWriter){
		String resultJson = "";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String autoLogin = request.getParameter("autoLogin");
		String validateCode = request.getParameter("validateCode");
		HttpSession session = request.getSession();
		String sessionCode = (String) session.getAttribute("RANDOMVALIDATECODEKEY");
		if (validateCode != null && !"".equals(validateCode)) {
			if (sessionCode != null && !"".equals(sessionCode)) {
				if (!sessionCode.equalsIgnoreCase(validateCode)) {
					resultJson = new RWReturnObject(300, "验证码不正确！").toString();
				}
			} else {
				resultJson = new RWReturnObject(300, "验证码不正确！").toString();
			}
		} else {
			resultJson = new RWReturnObject(301, "验证码不能为空！").toString();
		}
		if (autoLogin == "1" || "1".equals(autoLogin)) {
			int seconds = 7 * 24 * 60 * 60;
			Cookie cookie = new Cookie("cookie_User", username + "_" + password);
			cookie.setMaxAge(seconds);
			cookie.setPath(request.getContextPath());
			response.addCookie(cookie);
		}
		if ((username != null && !username.isEmpty()) && (password != null && !password.isEmpty())) {
			Query query = new Query();
			query.addAndCondition("name", "'" + username + "'");
			query.addAndCondition("password", "'" + MD5Util.MD5(password) + "'");
			query.addAndCondition("enabled", "'true'");
			List<User> user = userService.findAll(query);
			int size = user.size();
			if (size > 0) {
				session.setAttribute("user", user.get(0));
				session.setAttribute("userName", username);
				Logs logs = new Logs();
				logs.setCreatTime(new Date());
				logs.setMethod("getLogin");
				logs.setRecord("用户登陆成功");
				logs.setTableName("user");
				logs.setUser("id:" + user.get(0).getId() + ",name:" + user.get(0).getName());
				String ipAddr = RMSAuthorityUtile.getIpAddr(request);
				logs.setIpAddr(ipAddr);
				logsService.save(logs);

				logger.error("恭喜您，" + user.get(0).getName() + "登陆成功!");
				resultJson = new RWReturnObject(200, "登录成功！").toString();
			} else {
				resultJson = new RWReturnObject(400, "账号或密码错误！").toString();
			}
		} else {
			resultJson = new RWReturnObject(401, "账号或密码错误！").toString();
		}
		printWriter.write(resultJson);
		printWriter.flush();
		printWriter.close();
	}

	/**
	 * 退出
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/to/logout")
	public String toLogout(HttpServletRequest request, HttpServletResponse response, Model model) {
		String userId = RMSAuthorityUtile.loginUserID(request).toString();
		String userName = RMSAuthorityUtile.loginName(request);
		String nowUrl = request.getRequestURL().toString();
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		session.removeValue("user");
		session.removeAttribute("userName");
		session.removeValue("userName");
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie coo : cookies) {
				if (coo.getName() == "cookie_User" || "cookie_User".equals(coo.getName())) {
					coo = new Cookie(coo.getName(), null);
					coo.setMaxAge(0);
					coo.setPath(request.getContextPath());
					response.addCookie(coo);
				}
			}
		}
		Logs logs = new Logs();
		logs.setCreatTime(new Date());
		logs.setMethod("toLogout");
		logs.setRecord("用户退出登陆成功");
		logs.setTableName("user");
		logs.setUser("id:" + userId + ",name:" + userName);
		String ipAddr = RMSAuthorityUtile.getIpAddr(request);
		logs.setIpAddr(ipAddr);
		logsService.save(logs);

		logger.error("恭喜您，" + userName + "退出登陆成功!");
		if (nowUrl.contains("/min/")) {
			return "redirect:/min/default/tologin";
		} else {
			return "redirect:/app/default/tologin";
		}
	}

	/**
	 * 框架页（底部）
	 * 
	 * @param session
	 * @param model
	 * @return
	 * @author Mr.Hao
	 * @version 2013-1-4 下午02:54:55
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/register/page", method = RequestMethod.GET)
	public String getRegisterPage(HttpServletRequest request, HttpServletResponse response, Model model)
			throws UnsupportedEncodingException {
		return "min/user/register";
	}

	/**
	 * 框架页（底部）
	 * 
	 * @param session
	 * @param model
	 * @return
	 * @author Mr.Hao
	 * @version 2013-1-4 下午02:54:55
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String getRegister(HttpServletRequest request, HttpServletResponse response, Model model)
			throws UnsupportedEncodingException {
		boolean result = false;
		Query r_query = new Query();
		r_query.addAndCondition("levels", "'KEHU'");
		Role role = roleService.getByQuery(r_query);

		String name = request.getParameter("name");
		String realPassword = request.getParameter("realPassword");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String realName = request.getParameter("realName");
		String companyName = request.getParameter("companyName");
		String companyNameEn = request.getParameter("companyNameEn");
		String creditCode = request.getParameter("creditCode");
		String juridicalPerson = request.getParameter("juridicalPerson");
		String companyPhone = request.getParameter("companyPhone");
		String companyEmail = request.getParameter("companyEmail");
		String companyUrl = request.getParameter("companyUrl");
		String companyAddress = request.getParameter("companyAddress");


			User user = new User();
			user.setAddress(companyAddress);
			user.setCreateTime(new Date());
			user.setEmail(email);
			user.setEnabled("false");
			user.setName(name);
			user.setPassword(MD5Util.MD5(realPassword));
			user.setPhone(phone);
			user.setRealName(realName);
			user.setRoleId(role.getId());
			user.setRealPassword(realPassword);
			result = userService.saveNotNull(user);
		if (result) {
			return "redirect:/min/default/success";
		} else {
			return "redirect:/min/default/failed";
		}
	}

	@RequestMapping(value = "/failed")
	public String failed(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "error/failed";
	}

	@RequestMapping(value = "/success")
	public String success(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "error/success";
	}

}
