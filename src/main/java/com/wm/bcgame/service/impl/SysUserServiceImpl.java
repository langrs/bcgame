package com.wm.bcgame.service.impl;

import com.wm.bcgame.base.BaseDao;
import com.wm.bcgame.base.BaseServiceImpl;
import com.wm.bcgame.dao.SysUserDao;
import com.wm.bcgame.model.SysUser;
import com.wm.bcgame.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 对象功能:SysUser Service Impl 对象
 * 开发人员:LZM
 */
@Service("SysUserService")
public class SysUserServiceImpl extends BaseServiceImpl<Long, SysUser> implements SysUserService
{
	@Resource
	SysUserDao dao;

	@Override
	protected BaseDao<Long, SysUser> getDao() {
		return dao;
	}

	@Override
	protected Long getUserId(){
		return 1L;
	}
}
