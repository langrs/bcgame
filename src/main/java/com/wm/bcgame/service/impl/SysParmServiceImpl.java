package com.wm.bcgame.service.impl;

import com.wm.bcgame.base.BaseDao;
import com.wm.bcgame.base.BaseServiceImpl;
import com.wm.bcgame.dao.SysParmDao;
import com.wm.bcgame.model.SysParm;
import com.wm.bcgame.service.SysParmService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 对象功能:SysParm Service Impl 对象
 * 开发人员:LZM
 */
@Service("SysParmService")
public class SysParmServiceImpl extends BaseServiceImpl<Long, SysParm> implements SysParmService
{
	@Resource
	SysParmDao dao;

	@Override
	protected BaseDao<Long, SysParm> getDao() {
		return dao;
	}

	@Override
	protected Long getUserId(){
		return 1L;
	}
}
