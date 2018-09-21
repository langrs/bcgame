package com.wm.bcgame.model;

import com.wm.bcgame.base.AbstractModel;

import java.util.Date;


/**
* 描述：
* @author lzm
* @date 2018/09/07
*/
public class SysNotice extends AbstractModel {

    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //类型
    private Long noticeType;
    //标题
    private String title;
    //公告时间
    private String noticeTime;
    //正文
    private String description;
    //失效日期
    private Date expiry;
///////////////////////////////////////////////////////////////
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getNoticeType() {
        return this.noticeType;
    }

    public void setNoticeType(Long noticeType) {
        this.noticeType = noticeType;
    }
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getNoticeTime() {
        return this.noticeTime;
    }

    public void setNoticeTime(String noticeTime) {
        this.noticeTime = noticeTime;
    }
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Date getExpiry() {
        return this.expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

}