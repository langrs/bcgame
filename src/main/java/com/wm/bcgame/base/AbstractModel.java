package com.wm.bcgame.base;

import java.util.Date;

/**
 * 描述：实体的基础类
 * @author lzm
 *
 * @param
 */
public abstract class AbstractModel implements BaseModel {
    // 创建人
    protected Long createBy;
    // 更新人
    protected Long lastModifiedBy;
    // 创建时间
    protected Date createTime;
    // 更新时间
    protected Date lastModifiedTime;
    // 有效标志
    protected Long disabled;

    @Override
    public Long getCreateBy() {
        return this.createBy;
    }

    @Override
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    @Override
    public Date getCreateTime() {
        return this.createTime;
    }

    @Override
    public void setCreateTime(Date createtime) {
        this.createTime = createtime;
    }

    @Override
    public Date getLastModifiedTime() {
        return this.lastModifiedTime;
    }

    @Override
    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    @Override
    public Long getLastModifiedBy() {
        return this.lastModifiedBy;
    }

    @Override
    public void setLastModifiedBy(Long lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @Override
    public Long getDisabled() {
        return this.disabled;
    }

    @Override
    public void setDisabled(Long disabled) {
        this.disabled = disabled;
    }
}
