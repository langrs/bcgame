package com.wm.bcgame.service;

import com.wm.bcgame.base.BaseService;
import com.wm.bcgame.base.QueryMap;
import com.wm.bcgame.model.SysGame;

import java.util.List;

/**
 * 对象功能:SysGame Service 对象
 * 开发人员:LZM
 */

public interface SysGameService extends BaseService<Long, SysGame>
{
	/**********************************
	 * 获取总记录数
	 * @param
	 * @return Long
	 *********************************/
	Long getPageCount(QueryMap queryMap);
	/**********************************
	 * 获取分页记录数
	 * @return List<SysGame>
	 *********************************/
	List<SysGame> getListPage(QueryMap queryMap);

}
