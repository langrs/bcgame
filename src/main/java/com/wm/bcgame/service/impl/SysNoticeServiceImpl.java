package com.wm.bcgame.service.impl;

import com.wm.bcgame.base.BaseDao;
import com.wm.bcgame.base.BaseServiceImpl;
import com.wm.bcgame.dao.SysNoticeDao;
import com.wm.bcgame.model.SysNotice;
import com.wm.bcgame.service.SysNoticeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 对象功能:SysNotice Service Impl 对象
 * 开发人员:LZM
 */
@Service("SysNoticeService")
public class SysNoticeServiceImpl extends BaseServiceImpl<Long, SysNotice> implements SysNoticeService
{
	@Resource
	SysNoticeDao dao;

	@Override
	protected BaseDao<Long, SysNotice> getDao() {
		return dao;
	}

	@Override
	protected Long getUserId(){
		return 1L;
	}
}
