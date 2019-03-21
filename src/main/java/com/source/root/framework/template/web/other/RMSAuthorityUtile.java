package com.source.root.framework.template.web.other;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.source.root.framework.comm.pager.Query;
import com.source.root.manager.dao.RoleDao;
import com.source.root.manager.entity.Role;
import com.source.root.manager.entity.User;
import com.source.root.site.dao.SiteDao;
import com.source.root.site.entity.Site;

@Service("RMSAuthority")
public class RMSAuthorityUtile {

	@Autowired
	private RoleDao roleDao;
	@Autowired
	private SiteDao siteDao;

	/**
	 * 当前登录用户
	 * 
	 * @param request
	 * @return
	 */
	public User loginUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		return user;
	}

	/**
	 * 当前登录用户ID
	 * 
	 * @param request
	 * @return
	 */
	public Integer loginUserID(HttpServletRequest request) {
		if (loginUser(request) == null || "".equals(loginUser(request))) {
			return null;
		} else {
			return loginUser(request).getId();
		}
	}

	/**
	 * 当前登录用户真实姓名
	 * 
	 * @param request
	 * @return
	 */
	public String loginRealName(HttpServletRequest request) {
		if (loginUser(request) == null || "".equals(loginUser(request))) {
			return null;
		} else {
			return loginUser(request).getRealName();
		}
	}

	/**
	 * 当前登录用户账号
	 * 
	 * @param request
	 * @return
	 */
	public String loginName(HttpServletRequest request) {
		if (loginUser(request) == null || "".equals(loginUser(request))) {
			return null;
		} else {
			return loginUser(request).getName();
		}
	}

	/**
	 * 当前登录用户电话
	 * 
	 * @param request
	 * @return
	 */
	public String loginUserPhone(HttpServletRequest request) {
		if (loginUser(request) == null || "".equals(loginUser(request))) {
			return null;
		} else {
			return loginUser(request).getPhone();
		}
	}

	/**
	 * 当前登录用户角色ID
	 * 
	 * @param request
	 * @return
	 */
	public Integer loginRoleId(HttpServletRequest request) {
		if (loginUser(request) == null || "".equals(loginUser(request))) {
			return null;
		} else {
			return loginUser(request).getRoleId();
		}
	}

	/**
	 * 当前用户角色等级
	 * 
	 * @param request
	 * @return
	 */
	public Role loginUserRole(HttpServletRequest request) {
		Integer roleId = loginRoleId(request);
		Role role = roleDao.getById(roleId);
		return role;
	}
	/**
	 * 当前用户角色等级
	 * 
	 * @param request
	 * @return
	 */
	public String loginUserRoleLevels(HttpServletRequest request) {
		Role role = loginUserRole(request);
		return role != null ? role.getLevels() : "";
	}

	/**
	 * 当前用户站点列表
	 * @param request
	 * @return
	 */
	public List<Site> loginUserSite(HttpServletRequest request) {
		// 当前用户级别
		String role_levels = loginUserRoleLevels(request);
		List<Site> list = new ArrayList<Site>();
		if(StringUtils.isNotBlank(role_levels)){
			// 管理员
			if(role_levels.equals("ADMIN")){
				list = siteDao.findAll(new Query());
			// 其他用户
			}else{
				Query query = new Query();
				query.addAndCondition("su.siteId", "s.id");
				query.addAndCondition("su.userId", loginUserID(request).toString());
				list = siteDao.findAllByUserId(query);
			}
		}
		return list;
	}

	/**
	 * 当前用户站点Id+","
	 * @param request
	 * @return
	 */
	public String loginUserSiteIdString(HttpServletRequest request) {
		String result = "";
		List<Site> list = loginUserSite(request);
		if (list != null && list.size() > 0) {
			for (Site s : list) {
				result += s.getId() + ",";
			}
			if (StringUtils.isNotBlank(result) && result.contains(",")) {
				result = result.substring(0, result.length() - 1);
			}
		}
		return result;
	}

	public String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
			ip = request.getHeader("Proxy-Client-IP");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
			ip = request.getHeader("WL-Proxy-Client-IP");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
			ip = request.getHeader("HTTP_CLIENT_IP");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
			ip = request.getRemoteAddr();
		if ("127.0.0.1".equals(ip) || "0:0:0:0:0:0:0:1".equals(ip))
			try {
				ip = InetAddress.getLocalHost().getHostAddress();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return ip;
	}
}
