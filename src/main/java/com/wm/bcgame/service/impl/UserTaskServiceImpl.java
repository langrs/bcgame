package com.wm.bcgame.service.impl;

import com.wm.bcgame.base.BaseDao;
import com.wm.bcgame.base.BaseServiceImpl;
import com.wm.bcgame.dao.UserTaskDao;
import com.wm.bcgame.model.UserTask;
import com.wm.bcgame.service.UserTaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 对象功能:UserTask Service Impl 对象
 * 开发人员:LZM
 */
@Service("UserTaskService")
public class UserTaskServiceImpl extends BaseServiceImpl<Long, UserTask> implements UserTaskService
{
	@Resource
	UserTaskDao dao;

	@Override
	protected BaseDao<Long, UserTask> getDao() {
		return dao;
	}

	@Override
	protected Long getUserId(){
		return 1L;
	}
}
