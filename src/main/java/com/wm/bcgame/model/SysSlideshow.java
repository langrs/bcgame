package com.wm.bcgame.model;
import com.wm.bcgame.base.AbstractModel;


/**
* 描述：
* @author lzm
* @date 2018/09/07
*/
public class SysSlideshow extends AbstractModel {

    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //
    private String name;
    //
    private String description;
    //
    private String url;
///////////////////////////////////////////////////////////////
    public Long getid() {
        return this.id;
    }

    public void setid(Long id) {
        this.id = id;
    }
    public String getname() {
        return this.name;
    }

    public void setname(String name) {
        this.name = name;
    }
    public String getdescription() {
        return this.description;
    }

    public void setdescription(String description) {
        this.description = description;
    }
    public String geturl() {
        return this.url;
    }

    public void seturl(String url) {
        this.url = url;
    }

}