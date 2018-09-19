package com.wm.bcgame.service.impl;

import com.wm.bcgame.base.BaseDao;
import com.wm.bcgame.base.BaseServiceImpl;
import com.wm.bcgame.dao.UserOnlineDao;
import com.wm.bcgame.model.UserOnline;
import com.wm.bcgame.service.UserOnlineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 对象功能:UserOnline Service Impl 对象
 * 开发人员:LZM
 */
@Service("UserOnlineService")
public class UserOnlineServiceImpl extends BaseServiceImpl<Long, UserOnline> implements UserOnlineService
{
	@Resource
	UserOnlineDao dao;

	@Override
	protected BaseDao<Long, UserOnline> getDao() {
		return dao;
	}

	@Override
	protected Long getUserId(){
		return 1L;
	}
}
