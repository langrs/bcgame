package com.wm.bcgame.model;
import com.wm.bcgame.base.AbstractModel;


/**
* 描述：
* @author lzm
* @date 2018/09/07
*/
public class UserOnline extends AbstractModel {

    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //
    private Long userId;
    //在线分钟时长
    private Long duration;
    //在线日期
    private String onlineDate;
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
    public Long getduration() {
        return this.duration;
    }

    public void setduration(Long duration) {
        this.duration = duration;
    }
    public String getonlineDate() {
        return this.onlineDate;
    }

    public void setonlineDate(String onlineDate) {
        this.onlineDate = onlineDate;
    }

}