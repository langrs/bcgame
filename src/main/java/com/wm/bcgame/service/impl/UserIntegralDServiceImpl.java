package com.wm.bcgame.service.impl;

import com.wm.bcgame.base.BaseDao;
import com.wm.bcgame.base.BaseServiceImpl;
import com.wm.bcgame.dao.UserIntegralDDao;
import com.wm.bcgame.model.UserIntegralD;
import com.wm.bcgame.service.UserIntegralDService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 对象功能:UserIntegralD Service Impl 对象
 * 开发人员:LZM
 */
@Service("UserIntegralDService")
public class UserIntegralDServiceImpl extends BaseServiceImpl<Long, UserIntegralD> implements UserIntegralDService
{
	@Resource
	UserIntegralDDao dao;

	@Override
	protected BaseDao<Long, UserIntegralD> getDao() {
		return dao;
	}

	@Override
	protected Long getUserId(){
		return 1L;
	}
}
