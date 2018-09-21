package com.wm.bcgame.model;
import com.wm.bcgame.base.AbstractModel;


/**
* 描述：
* @author lzm
* @date 2018/09/07
*/
public class UserHistory extends AbstractModel {

    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //
    private Long userId;
    //历史类型
    private Long historyType;
    //历史ID
    private Long historyId;
///////////////////////////////////////////////////////////////
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getHistoryType() {
        return this.historyType;
    }

    public void setHistoryType(Long historyType) {
        this.historyType = historyType;
    }
    public Long getHistoryId() {
        return this.historyId;
    }

    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
    }

}