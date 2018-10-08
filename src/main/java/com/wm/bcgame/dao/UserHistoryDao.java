package com.wm.bcgame.dao;

import com.wm.bcgame.base.BaseDao;
import com.wm.bcgame.base.QueryMap;
import com.wm.bcgame.model.UserHistory;
import org.apache.ibatis.annotations.Mapper;

/**
* 描述：
* @author lzm
* @date 2018/09/07
*/
@Mapper
public interface UserHistoryDao extends BaseDao<Long,UserHistory>{
//	获取用户每日登录的游戏款数
	Integer getDailyGameCount(QueryMap queryMap);
}