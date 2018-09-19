package com.wm.bcgame.dao;

import com.wm.bcgame.base.BaseDao;
import com.wm.bcgame.model.UserCoin;
import org.apache.ibatis.annotations.Mapper;

/**
* 描述：
* @author lzm
* @date 2018/09/07
*/
@Mapper
public interface UserCoinDao extends BaseDao<Long,UserCoin>{

}