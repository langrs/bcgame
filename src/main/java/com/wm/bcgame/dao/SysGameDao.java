package com.wm.bcgame.dao;

import com.wm.bcgame.base.BaseDao;
import com.wm.bcgame.base.QueryMap;
import com.wm.bcgame.model.SysGame;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* 描述：
* @author lzm
* @date 2018/09/07
*/
@Mapper
public interface SysGameDao extends BaseDao<Long,SysGame>{
	/**********************************
	 * 获取总记录数
	 * @param
	 * @return Long
	 *********************************/
	Long getPageCount();
	/**********************************
	 * 获取分页记录数
	 * @return List<SysGame>
	 *********************************/
	List<SysGame> getListPage(QueryMap queryMap);
}