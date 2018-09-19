package com.wm.bcgame.service.impl;

import com.wm.bcgame.base.BaseDao;
import com.wm.bcgame.base.BaseServiceImpl;
import com.wm.bcgame.dao.UserIntegralDao;
import com.wm.bcgame.model.UserIntegral;
import com.wm.bcgame.service.UserIntegralService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 对象功能:UserIntegral Service Impl 对象
 * 开发人员:LZM
 */
@Service("UserIntegralService")
public class UserIntegralServiceImpl extends BaseServiceImpl<Long, UserIntegral> implements UserIntegralService
{
	@Resource
	UserIntegralDao dao;

	@Override
	protected BaseDao<Long, UserIntegral> getDao() {
		return dao;
	}

	@Override
	protected Long getUserId(){
		return 1L;
	}
}
