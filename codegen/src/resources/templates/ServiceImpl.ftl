package ${package_name}.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import ${package_name}.base.BaseServiceImpl;
import ${package_name}.base.BaseDao;
import ${package_name}.dao.${table_name}Dao;
import ${package_name}.model.${table_name};
import ${package_name}.service.${table_name}Service;

/**
 * 对象功能:${table_name} Service Impl 对象
 * 开发人员:LZM
 */
@Service("${table_name}Service")
public class ${table_name}ServiceImpl extends BaseServiceImpl<Long, ${table_name}> implements ${table_name}Service
{
	@Resource
	${table_name}Dao dao;

	@Override
	protected BaseDao<Long, ${table_name}> getDao() {
		return dao;
	}

	@Override
	protected Long getUserId(){
		return 1L;
	}
}
