package com.wm.bcgame.service.impl;

import com.wm.bcgame.base.BaseDao;
import com.wm.bcgame.base.BaseServiceImpl;
import com.wm.bcgame.dao.SysSlideshowDao;
import com.wm.bcgame.model.SysSlideshow;
import com.wm.bcgame.service.SysSlideshowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 对象功能:SysSlideshow Service Impl 对象
 * 开发人员:LZM
 */
@Service("SysSlideshowService")
public class SysSlideshowServiceImpl extends BaseServiceImpl<Long, SysSlideshow> implements SysSlideshowService
{
	@Resource
	SysSlideshowDao dao;

	@Override
	protected BaseDao<Long, SysSlideshow> getDao() {
		return dao;
	}

	@Override
	protected Long getUserId(){
		return 1L;
	}
}
