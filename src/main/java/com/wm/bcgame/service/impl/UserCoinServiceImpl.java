package com.wm.bcgame.service.impl;

import com.wm.bcgame.base.BaseDao;
import com.wm.bcgame.base.BaseServiceImpl;
import com.wm.bcgame.dao.UserCoinDao;
import com.wm.bcgame.model.UserCoin;
import com.wm.bcgame.service.UserCoinService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 对象功能:UserCoin Service Impl 对象
 * 开发人员:LZM
 */
@Service("UserCoinService")
public class UserCoinServiceImpl extends BaseServiceImpl<Long, UserCoin> implements UserCoinService
{
	@Resource
	UserCoinDao dao;

	@Override
	protected BaseDao<Long, UserCoin> getDao() {
		return dao;
	}

	@Override
	protected Long getUserId(){
		return 1L;
	}
}
