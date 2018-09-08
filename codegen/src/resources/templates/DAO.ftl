package ${package_name}.dao;

import ${package_name}.model.${table_name};
import org.apache.ibatis.annotations.Mapper;
import com.wm.bcgame.base.BaseDao;

/**
* 描述：${table_annotation}
* @author ${author}
* @date ${date}
*/
@Mapper
public interface ${table_name}Dao extends BaseDao<Long,${table_name}>{

}