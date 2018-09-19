package com.wm.bcgame.service.impl;

import com.wm.bcgame.base.BaseDao;
import com.wm.bcgame.base.BaseServiceImpl;
import com.wm.bcgame.dao.SysTaskDao;
import com.wm.bcgame.model.SysTask;
import com.wm.bcgame.service.SysTaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 对象功能:SysTask Service Impl 对象
 * 开发人员:LZM
 */
@Service("SysTaskService")
public class SysTaskServiceImpl extends BaseServiceImpl<Long, SysTask> implements SysTaskService
{
	@Resource
	SysTaskDao dao;

	@Override
	protected BaseDao<Long, SysTask> getDao() {
		return dao;
	}

	@Override
	protected Long getUserId(){
		return 1L;
	}
}
