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
    public Long getid() {
        return this.id;
    }

    public void setid(Long id) {
        this.id = id;
    }
    public Long getuserId() {
        return this.userId;
    }

    public void setuserId(Long userId) {
        this.userId = userId;
    }
    public Long gethistoryType() {
        return this.historyType;
    }

    public void sethistoryType(Long historyType) {
        this.historyType = historyType;
    }
    public Long gethistoryId() {
        return this.historyId;
    }

    public void sethistoryId(Long historyId) {
        this.historyId = historyId;
    }

}