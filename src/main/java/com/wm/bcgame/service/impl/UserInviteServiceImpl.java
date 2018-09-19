package com.wm.bcgame.service.impl;

import com.wm.bcgame.base.BaseDao;
import com.wm.bcgame.base.BaseServiceImpl;
import com.wm.bcgame.dao.UserInviteDao;
import com.wm.bcgame.model.UserInvite;
import com.wm.bcgame.service.UserInviteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 对象功能:UserInvite Service Impl 对象
 * 开发人员:LZM
 */
@Service("UserInviteService")
public class UserInviteServiceImpl extends BaseServiceImpl<Long, UserInvite> implements UserInviteService
{
	@Resource
	UserInviteDao dao;

	@Override
	protected BaseDao<Long, UserInvite> getDao() {
		return dao;
	}

	@Override
	protected Long getUserId(){
		return 1L;
	}
}
