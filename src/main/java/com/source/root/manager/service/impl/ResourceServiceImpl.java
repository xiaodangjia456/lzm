package com.source.root.manager.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.source.root.framework.comm.pager.Query;
import com.source.root.framework.template.dao.IBaseDao;
import com.source.root.framework.template.service.BaseServiceImpl;
import com.source.root.manager.dao.ResourceDao;
import com.source.root.manager.dao.RoleDao;
import com.source.root.manager.entity.Resource;
import com.source.root.manager.entity.Role;
import com.source.root.manager.entity.User;
import com.source.root.manager.model.menu.LeftMenu1Model;
import com.source.root.manager.model.menu.LeftMenu2Model;
import com.source.root.manager.model.menu.LeftMenu3Model;
import com.source.root.manager.service.ResourceService;

@Service("resourceService")
public class ResourceServiceImpl extends BaseServiceImpl<Resource, java.lang.Integer> implements ResourceService {

	@Autowired
	private ResourceDao resourceDao;
	@Autowired
	private RoleDao roleDao;

	@Override
	protected IBaseDao<?,?> getBaseDao() {
		// TODO Auto-generated method stub
		return resourceDao;
	}

	public List<LeftMenu1Model> getLeftMenu(HttpServletRequest request) {
		List<LeftMenu1Model> list = new ArrayList<LeftMenu1Model>();
 		String contextPath = request.getContextPath();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Integer roleId = user.getRoleId();
		Query q = new Query();
		q.addAndCondition("isAble", "'true'");
		q.addAndCondition("id", roleId.toString());
		Role role = new Role();
		role = roleDao.getByQuery(q);
		list = getLeftMenu1(contextPath, role, user);
		return list;
	}

	public List<LeftMenu1Model> getLeftMenu1(String contextPath, Role role, User user) {
		List<LeftMenu1Model> list = new ArrayList<LeftMenu1Model>();
		List<Resource> rList = new ArrayList<Resource>();
		Query query = new Query();
		String roleLevel = role.getLevels();
		if (roleLevel == "ADMIN" || "ADMIN".equals(roleLevel)) {
			query.addAndCondition("inheritCode", "0");
			query.addAndCondition("levels", "0");
			query.addAndCondition("isAbleTable", "'true'");
			query.addOrder("resourceCode", "desc");
			rList = resourceDao.findAll(query);
		} else {
			query.addAndCondition("rr.roleId", role.getId().toString());
			query.addAndCondition("rr.resourceId", "r.id");
			query.addAndCondition("r.inheritCode", "0");
			query.addAndCondition("r.levels", "0");
			query.addAndCondition("r.isAbleTable", "'true'");
			query.addOrder("resourceCode", "desc");
			rList = resourceDao.findByRoleId(query);
		}
		if (rList != null) {
			for (Resource r0 : rList) {
				LeftMenu1Model lmm1 = new LeftMenu1Model();
				List<LeftMenu2Model> list2 = getLeftMenu2(contextPath, r0, role, user);
				lmm1.setId(r0.getId().toString());
				lmm1.setChildMenus(list2);
				lmm1.setIcon("&#xe600;");
				lmm1.setIsHeader("0");
				lmm1.setName(r0.getResourceName());
				lmm1.setOrder(r0.getResourceCode());
				lmm1.setParentId(r0.getInheritCode().toString());
				if (r0.getResourceUrl() != null && !r0.getResourceUrl().isEmpty()) {
					lmm1.setUrl(contextPath + r0.getResourceUrl());
				} else {
					lmm1.setUrl("");
				}
				list.add(lmm1);
			}
		}
		return list;
	}

	public List<LeftMenu2Model> getLeftMenu2(String contextPath, Resource resource, Role role, User user) {
		List<LeftMenu2Model> list = new ArrayList<LeftMenu2Model>();
		List<Resource> rList = new ArrayList<Resource>();
		Query query = new Query();
		String roleLevel = role.getLevels();
		if (roleLevel == "ADMIN" || "ADMIN".equals(roleLevel)) {
			query.addAndCondition("inheritCode", resource.getId().toString());
			query.addAndCondition("levels", "1");
			query.addAndCondition("isAbleTable", "'true'");
			query.addOrder("resourceCode", "asc");
			rList = resourceDao.findAll(query);
		} else {
			query.addAndCondition("rr.roleId", role.getId().toString());
			query.addAndCondition("rr.resourceId", "r.id");
			query.addAndCondition("r.inheritCode", resource.getId().toString());
			query.addAndCondition("r.isAbleTable", "'true'");
			query.addAndCondition("r.levels", "1");
			query.addOrder("resourceCode", "asc");
			rList = resourceDao.findByRoleId(query);
		}
		if (rList != null) {
			for (Resource r0 : rList) {
				LeftMenu2Model lmm2 = new LeftMenu2Model();
				List<LeftMenu3Model> list3 = getLeftMenu3(contextPath, r0, role, user);
				lmm2.setId(r0.getId().toString());
				lmm2.setChildMenus(list3);
				lmm2.setIcon("&#xe610;");
				lmm2.setIsHeader("0");
				lmm2.setName(r0.getResourceName());
				lmm2.setOrder(r0.getResourceCode());
				lmm2.setParentId(r0.getInheritCode().toString());
				if (r0.getResourceUrl() != null && !r0.getResourceUrl().isEmpty()) {
					lmm2.setUrl(contextPath + r0.getResourceUrl());
				} else {
					lmm2.setUrl("");
				}
				list.add(lmm2);
			}
		}
		return list;
	}

	public List<LeftMenu3Model> getLeftMenu3(String contextPath, Resource resource, Role role, User user) {
		List<LeftMenu3Model> list = new ArrayList<LeftMenu3Model>();
		List<Resource> rList = new ArrayList<Resource>();
		Query query = new Query();
		String roleLevel = role.getLevels();
		if (roleLevel == "ADMIN" || "ADMIN".equals(roleLevel)) {
			query.addAndCondition("inheritCode", resource.getId().toString());
			query.addAndCondition("levels", "2");
			query.addAndCondition("isAbleTable", "'true'");
			query.addOrder("resourceCode", "asc");
			rList = resourceDao.findAll(query);
		} else {
			query.addAndCondition("rr.roleId", role.getId().toString());
			query.addAndCondition("rr.resourceId", "r.id");
			query.addAndCondition("r.inheritCode", resource.getId().toString());
			query.addAndCondition("r.levels", "2");
			query.addAndCondition("r.isAbleTable", "'true'");
			query.addOrder("resourceCode", "asc");
			rList = resourceDao.findByRoleId(query);
		}
		if (rList != null) {
			for (Resource r0 : rList) {
				LeftMenu3Model lmm3 = new LeftMenu3Model();
				lmm3.setId(r0.getId().toString());
				lmm3.setIcon("&#xe602;");
				lmm3.setIsHeader("0");
				lmm3.setName(r0.getResourceName());
				lmm3.setOrder(r0.getResourceCode());
				lmm3.setParentId(r0.getInheritCode().toString());
				if (r0.getResourceUrl() != null && !r0.getResourceUrl().isEmpty()) {
					lmm3.setUrl(contextPath + r0.getResourceUrl());
				} else {
					lmm3.setUrl("");
				}
				list.add(lmm3);
			}
		}
		return list;
	}

	public List<Resource> findByRoleId(Query query) {
		return resourceDao.findByRoleId(query);
	}
}
