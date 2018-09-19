package com.wm.bcgame.service.impl;

import com.wm.bcgame.base.BaseDao;
import com.wm.bcgame.base.BaseServiceImpl;
import com.wm.bcgame.dao.UserHistoryDao;
import com.wm.bcgame.model.UserHistory;
import com.wm.bcgame.service.UserHistoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 对象功能:UserHistory Service Impl 对象
 * 开发人员:LZM
 */
@Service("UserHistoryService")
public class UserHistoryServiceImpl extends BaseServiceImpl<Long, UserHistory> implements UserHistoryService
{
	@Resource
	UserHistoryDao dao;

	@Override
	protected BaseDao<Long, UserHistory> getDao() {
		return dao;
	}

	@Override
	protected Long getUserId(){
		return 1L;
	}
}
