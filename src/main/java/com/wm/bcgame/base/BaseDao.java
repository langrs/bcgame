package com.wm.bcgame.base;

import com.wm.bcgame.base.QueryMap;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<PK extends Serializable,T>
{
    /**********************************
     * 创建实体对象
     * @param model 实体对象
     * @return Long
     *********************************/
    Long create(T model);
    /**********************************
     * 更新实体对象
     * @param model 实体对象
     * @return Long
     *********************************/
    Long update(T model);
    /**********************************
     * 按实体ID删除对象
     * @param modelId 主键
     *********************************/
    void delete(PK modelId);

    /**********************************
     * 按实体ID获取实体
     * @param modelId 实体对象
     *********************************/
    T get(PK modelId);

    /**********************************
     * 取得所有查询对象
     * @return List<T>
     *********************************/
    List<T> getAll();
    /**********************************
     * 根据条件获得单个对象
     *
     * @param map 查询条件map
     * @return T
     *********************************/
    T getOne(QueryMap map);
    /**********************************
     * 根据条件获得对象列表,使用的条件都是精确查询
     *
     * @param map 查询条件map
     * @return List<T>
     *********************************/
    List<T> getList(QueryMap map);
    /**********************************
     * 根据条件搜索对象列表,如果条件为字符串，默认使用like来匹配
     * @param map 查询条件map
     * @return List<T>
     *********************************/
    List<T> search(QueryMap map);

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
//    /**********************************
//     * 按实体IDs删除记录
//     * @param ids
//     *********************************/
//    public void deleteByIds(PK... ids);
}
