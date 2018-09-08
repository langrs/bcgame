package ${package_name}.service;

import ${package_name}.base.BaseService;
<#--定义import的实体包名 ,这里可以考虑把整个包名都使用变量来控制-->
import ${package_name}.model.${table_name};
/**
 * 对象功能:${table_name} Service 对象
 * 开发人员:LZM
 */

public interface ${table_name}Service extends BaseService<Long, ${table_name}>
{

}
