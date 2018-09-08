package com.wm.bcgame.dao;

import com.wm.bcgame.model.UserNotice;
import org.apache.ibatis.annotations.Mapper;
import com.wm.bcgame.base.BaseDao;

/**
* 描述：
* @author lzm
* @date 2018/09/07
*/
@Mapper
public interface UserNoticeDao extends BaseDao<Long,UserNotice>{

}