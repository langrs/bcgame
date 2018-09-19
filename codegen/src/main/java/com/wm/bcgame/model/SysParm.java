package com.wm.bcgame.model;
import com.wm.bcgame.base.AbstractModel;
import java.util.Date;




/**
* 描述：
* @author lzm
* @date 2018/09/07
*/
public class SysParm extends AbstractModel {

    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //
    private Long parmCode;
    //
    private String parmValues;
    //
    private String description;
///////////////////////////////////////////////////////////////
    public Long getid() {
        return this.id;
    }

    public void setid(Long id) {
        this.id = id;
    }
    public Long getparmCode() {
        return this.parmCode;
    }

    public void setparmCode(Long parmCode) {
        this.parmCode = parmCode;
    }
    public String getparmValues() {
        return this.parmValues;
    }

    public void setparmValues(String parmValues) {
        this.parmValues = parmValues;
    }
    public String getdescription() {
        return this.description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

}