package com.wm.bcgame.service.impl;

import com.wm.bcgame.base.BaseDao;
import com.wm.bcgame.base.BaseServiceImpl;
import com.wm.bcgame.dao.UserSigninDao;
import com.wm.bcgame.model.UserSignin;
import com.wm.bcgame.service.UserSigninService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 对象功能:UserSignin Service Impl 对象
 * 开发人员:LZM
 */
@Service("UserSigninService")
public class UserSigninServiceImpl extends BaseServiceImpl<Long, UserSignin> implements UserSigninService
{
	@Resource
	UserSigninDao dao;

	@Override
	protected BaseDao<Long, UserSignin> getDao() {
		return dao;
	}

	@Override
	protected Long getUserId(){
		return 1L;
	}
}
