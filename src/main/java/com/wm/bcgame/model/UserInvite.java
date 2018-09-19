package com.wm.bcgame.model;
import com.wm.bcgame.base.AbstractModel;


/**
* 描述：
* @author lzm
* @date 2018/09/07
*/
public class UserInvite extends AbstractModel {

    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //邀请用户
    private Long userId;
    //被邀用户
    private Long invitedUserId;
    //备注
    private String memo;
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
    public Long getinvitedUserId() {
        return this.invitedUserId;
    }

    public void setinvitedUserId(Long invitedUserId) {
        this.invitedUserId = invitedUserId;
    }
    public String getmemo() {
        return this.memo;
    }

    public void setmemo(String memo) {
        this.memo = memo;
    }

}