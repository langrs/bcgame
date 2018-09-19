package com.wm.bcgame.service.impl;

import com.wm.bcgame.base.BaseDao;
import com.wm.bcgame.base.BaseServiceImpl;
import com.wm.bcgame.dao.UserCoinDDao;
import com.wm.bcgame.model.UserCoinD;
import com.wm.bcgame.service.UserCoinDService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 对象功能:UserCoinD Service Impl 对象
 * 开发人员:LZM
 */
@Service("UserCoinDService")
public class UserCoinDServiceImpl extends BaseServiceImpl<Long, UserCoinD> implements UserCoinDService
{
	@Resource
	UserCoinDDao dao;

	@Override
	protected BaseDao<Long, UserCoinD> getDao() {
		return dao;
	}

	@Override
	protected Long getUserId(){
		return 1L;
	}
}
