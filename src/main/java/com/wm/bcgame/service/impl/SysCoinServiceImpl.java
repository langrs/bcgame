package com.wm.bcgame.service.impl;

import com.wm.bcgame.base.BaseDao;
import com.wm.bcgame.base.BaseServiceImpl;
import com.wm.bcgame.dao.SysCoinDao;
import com.wm.bcgame.model.SysCoin;
import com.wm.bcgame.service.SysCoinService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 对象功能:SysCoin Service Impl 对象
 * 开发人员:LZM
 */
@Service("SysCoinService")
public class SysCoinServiceImpl extends BaseServiceImpl<Long, SysCoin> implements SysCoinService
{
	@Resource
	SysCoinDao dao;

	@Override
	protected BaseDao<Long, SysCoin> getDao() {
		return dao;
	}

	@Override
	protected Long getUserId(){
		return 1L;
	}
}
