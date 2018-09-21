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
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getParmCode() {
        return this.parmCode;
    }

    public void setParmCode(Long parmCode) {
        this.parmCode = parmCode;
    }
    public String getParmValues() {
        return this.parmValues;
    }

    public void setParmValues(String parmValues) {
        this.parmValues = parmValues;
    }
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}