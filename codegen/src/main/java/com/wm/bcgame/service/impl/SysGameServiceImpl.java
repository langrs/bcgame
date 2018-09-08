package com.wm.bcgame.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.wm.bcgame.base.BaseServiceImpl;
import com.wm.bcgame.base.BaseDao;
import com.wm.bcgame.dao.SysGameDao;
import com.wm.bcgame.model.SysGame;
import com.wm.bcgame.service.SysGameService;

/**
 * 对象功能:SysGame Service Impl 对象
 * 开发人员:LZM
 */
@Service("SysGameService")
public class SysGameServiceImpl extends BaseServiceImpl<Long, SysGame> implements SysGameService
{
	@Resource
	SysGameDao dao;

	@Override
	protected BaseDao<Long, SysGame> getDao() {
		return dao;
	}

	@Override
	protected Long getUserId(){
		return 1L;
	}
}
