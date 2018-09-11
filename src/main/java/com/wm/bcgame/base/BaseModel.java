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
     * @return Long
     */
    Long getCreateBy();
    /**
     * 设置设置人ID
     * @param createBy 创建人
     */
    void setCreateBy(Long createBy);
    /**
     * 返回创建时间
     * @return Date
     */
    Date getCreateTime();
    /**
     * 设置创建时间
     * @param createtime 创建时间
     */
    void setCreateTime(Date createtime);
    /**
     * 返回更新时间
     * @return Date
     */
    Date getLastModifiedTime();
    /**
     * 设置更新时间
     * @param lastModifiedTime 最后更新时间
     */
    void setLastModifiedTime(Date lastModifiedTime);
    /**
     * 返回更新人ID
     * @return Long
     */
    Long getLastModifiedBy();
    /**
     * 设置更新人ID
     * @param lastModifiedBy 最后更新人
     */
    void setLastModifiedBy(Long lastModifiedBy);
    /**
     * 返回有效标志
     * @return Long
     */
    Long getDisabled();
    /**
     * 设置有效标志
     * @param disabled 有效标志
     */
    void setDisabled(Long disabled);

}
