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
    //标题
    private String title;
    //正文
    private String description;
    //失效日期
    private Date expiry;
///////////////////////////////////////////////////////////////
    public Long getid() {
        return this.id;
    }

    public void setid(Long id) {
        this.id = id;
    }
    public String gettitle() {
        return this.title;
    }

    public void settitle(String title) {
        this.title = title;
    }
    public String getdescription() {
        return this.description;
    }

    public void setdescription(String description) {
        this.description = description;
    }
    public Date getexpiry() {
        return this.expiry;
    }

    public void setexpiry(Date expiry) {
        this.expiry = expiry;
    }

}