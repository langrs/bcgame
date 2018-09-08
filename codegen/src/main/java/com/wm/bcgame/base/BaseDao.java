package com.wm.bcgame.base;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<PK extends Serializable,T>
{
    /**********************************
     * 创建实体对象
     * @param model
     * @return
     *********************************/
    public Long create(T model);
    /**********************************
     * 更新实体对象
     * @param model
     * @return
     *********************************/
    public Long update(T model);
    /**********************************
     * 按实体ID删除对象
     * @param modelId
     *********************************/
    public void delete(PK modelId);

    /**********************************
     * 按实体ID获取实体
     * @param modelId
     *********************************/
    public T get(PK modelId);

    /**********************************
     * 按实体IDs删除记录
     * @param ids
     *********************************/
    public void deleteByIds(PK... ids);

    /**********************************
     * 取得所有查询对象
     * @return
     *********************************/
    public List<T> getAll();
    /**********************************
     * 根据条件获得单个对象
     *
     * @param map
     * @return
     *********************************/
    public T getOne(QueryMap map);
    /**********************************
     * 根据条件获得对象列表,使用的条件都是精确查询
     *
     * @param map
     * @return
     *********************************/
    public List<T> getList(QueryMap map);
    /**********************************
     * 根据条件搜索对象列表,如果条件为字符串，默认使用like来匹配
     * @param map
     * @return
     *********************************/
    public List<T> search(QueryMap map);

    //    /**
//     * 按实体业务主键获取实体
//     * @param modelKey
//     */
//    public T getBymodelKey(String modelKey);

    //    /**
//     * 查询实体对象
//     * @param queryFilter
//     * @return
//     */
//    public List<T> query(QueryFilter queryFilter);

}
