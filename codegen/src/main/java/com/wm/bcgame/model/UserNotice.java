package com.wm.bcgame.model;
import com.wm.bcgame.base.AbstractModel;
import java.util.Date;




/**
* 描述：
* @author lzm
* @date 2018/09/07
*/
public class UserNotice extends AbstractModel {

    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //
    private Long userId;
    //
    private Long noticeId;
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
    public Long getnoticeId() {
        return this.noticeId;
    }

    public void setnoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }

}