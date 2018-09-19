package com.wm.bcgame.service.impl;

import com.wm.bcgame.base.BaseDao;
import com.wm.bcgame.base.BaseServiceImpl;
import com.wm.bcgame.dao.UserFavoriteDao;
import com.wm.bcgame.model.UserFavorite;
import com.wm.bcgame.service.UserFavoriteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 对象功能:UserFavorite Service Impl 对象
 * 开发人员:LZM
 */
@Service("UserFavoriteService")
public class UserFavoriteServiceImpl extends BaseServiceImpl<Long, UserFavorite> implements UserFavoriteService
{
	@Resource
	UserFavoriteDao dao;

	@Override
	protected BaseDao<Long, UserFavorite> getDao() {
		return dao;
	}

	@Override
	protected Long getUserId(){
		return 1L;
	}
}
