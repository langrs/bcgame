package com.wm.bcgame.base;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体基础接口
 * @author lzm
 *
 */
public interface BaseModel extends Serializable {
    /**
     * 返回创建人ID
     * @return
     */
    public Long getCreateBy();
    /**
     * 设置设置人ID
     * @param createBy
     */
    public void setCreateBy(Long createBy);
    /**
     * 返回创建时间
     * @return
     */
    public Date getCreateTime();
    /**
     * 设置创建时间
     * @param createtime
     */
    public void setCreateTime(Date createtime);
    /**
     * 返回更新时间
     * @return
     */
    public Date getLastModifiedTime();
    /**
     * 设置更新时间
     * @param lastModifiedTime
     */
    public void setLastModifiedTime(Date lastModifiedTime);
    /**
     * 返回更新人ID
     * @return
     */
    public Long getLastModifiedBy();
    /**
     * 设置更新人ID
     * @param lastModifiedBy
     */
    public void setLastModifiedBy(Long lastModifiedBy);
    /**
     * 返回有效标志
     * @return
     */
    public Long getDisabled();
    /**
     * 设置有效标志
     * @param disabled
     */
    public void setDisabled(Long disabled);

}
