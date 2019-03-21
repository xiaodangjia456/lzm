package com.source.root.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.source.root.framework.comm.pager.Query;
import com.source.root.framework.template.dao.IBaseDao;
import com.source.root.framework.template.service.BaseServiceImpl;
import com.source.root.manager.dao.GroupDao;
import com.source.root.manager.dao.UsergroupDao;
import com.source.root.manager.entity.Group;
import com.source.root.manager.entity.Groupuser;
import com.source.root.manager.service.GroupService;

@Service("groupService")
public class GroupServiceImpl extends BaseServiceImpl<Group, java.lang.Long>
		implements GroupService {

	@Autowired
	private GroupDao groupDao;
	@Autowired
	private UsergroupDao usergroupDao;


	@SuppressWarnings("rawtypes")
	@Override
	protected IBaseDao getBaseDao() {
		// TODO Auto-generated method stub
		return groupDao;
	}

	public String getZtreeGroupAndUser(Query query) {
		String result = "";
		List<Group> list = groupDao.findAll(query);
		if (list.size() > 0) {
			result = "[";
			for (Group group : list) {
				result += group.getTreeJson() + ",";
				Query _query = new Query();
				_query.addAndCondition("ug.groupId", group.getId().toString());
				_query.addAndCondition("u.id", "ug.userId");
				List<Groupuser> gu_list = usergroupDao.findUserAndGroup(_query);
				for (Groupuser gu : gu_list) {
					result += gu.getTreeJson() + ",";
				}
			}
			result = result.substring(0, result.length() - 1) + "]";
		}
		return result;
	}

	public String getZtree(Query query) {
		String result = "";
		List<Group> list = groupDao.findAll(query);
		if (list.size() > 0) {
			result = "[";
			for (Group group : list) {
				result += group.getTreeJson() + ",";
			}
			result = result.substring(0, result.length() - 1) + "]";
		}
		return result;
	}
}
