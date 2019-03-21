package com.source.root.manager.service;

import com.source.root.framework.comm.pager.Query;
import com.source.root.framework.template.service.IBaseService;
import com.source.root.manager.entity.Group;

public interface GroupService extends IBaseService<Group, java.lang.Long> {

	String getZtree(Query query);

	String getZtreeGroupAndUser(Query query);

}
