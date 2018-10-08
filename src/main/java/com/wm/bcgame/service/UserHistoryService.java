package com.wm.bcgame.service;

import com.wm.bcgame.base.BaseService;
import com.wm.bcgame.base.QueryMap;
import com.wm.bcgame.model.UserHistory;

/**
 * 对象功能:UserHistory Service 对象
 * 开发人员:LZM
 */

public interface UserHistoryService extends BaseService<Long, UserHistory>
{
	//	获取用户每日登录的游戏款数
	Integer getDailyGameCount(QueryMap queryMap);
}
