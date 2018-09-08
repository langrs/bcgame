package com.wm.bcgame.base;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public abstract class BaseServiceImpl<PK extends Serializable, T extends Serializable> implements BaseService<PK,T> {

    protected abstract BaseDao<PK, T> getDao();

    protected abstract Long getUserId();

    @Override
    public Long create(T model) {
        //初始化新增用户和时间
        setCreateInfo(model);
        return getDao().create(model);
    }

    @Override
    public Long update(T model) {
        //设置更新用户和时间
        setUpdateInfo(model);
        return getDao().update(model);
    }

    @Override
    public void delete(PK modelId) {
        getDao().delete(modelId);
    }

    @Override
    public void deleteByIds(PK... ids) {
        for(PK id:ids){
            delete(id);
        }
    }

    @Override
    public T get(PK modelId) {
        return getDao().get(modelId);
    }

    @Override
    public List<T> getAll() {
        return getDao().getAll();
    }

    @Override
    public T getOne(QueryMap map) {
        return getDao().getOne(map);
    }

    @Override
    public List<T> getList(QueryMap map) {
        return getDao().getList(map);
    }

    @Override
    public List<T> search(QueryMap map) {
        return getDao().search(map);
    }

    private void setCreateInfo(T model) {
        if (model instanceof AbstractModel) {
            @SuppressWarnings("unchecked")
            AbstractModel abstractModel = (AbstractModel) model;
//            创建人
            if (abstractModel.getCreateBy() == null || abstractModel.getCreateBy().equals("")) {
                abstractModel.setCreateBy(getUserId());
            }
//            创建时间
            if (abstractModel.getCreateTime() == null) {
                abstractModel.setCreateTime(new Date());
            }
//            有效标志
            abstractModel.setDisabled(0L);

        }
    }
    private void setUpdateInfo(T model){
        if(model instanceof AbstractModel){
            AbstractModel abstractModel = (AbstractModel) model;
            abstractModel.setLastModifiedBy(getUserId());
            abstractModel.setLastModifiedTime(new Date());
        }
    }
}
