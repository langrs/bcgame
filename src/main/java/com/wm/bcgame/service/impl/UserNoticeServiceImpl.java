package com.wm.bcgame.service.impl;

import com.wm.bcgame.base.BaseDao;
import com.wm.bcgame.base.BaseServiceImpl;
import com.wm.bcgame.dao.UserNoticeDao;
import com.wm.bcgame.model.UserNotice;
import com.wm.bcgame.service.UserNoticeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 对象功能:UserNotice Service Impl 对象
 * 开发人员:LZM
 */
@Service("UserNoticeService")
public class UserNoticeServiceImpl extends BaseServiceImpl<Long, UserNotice> implements UserNoticeService
{
	@Resource
	UserNoticeDao dao;

	@Override
	protected BaseDao<Long, UserNotice> getDao() {
		return dao;
	}

	@Override
	protected Long getUserId(){
		return 1L;
	}
}
