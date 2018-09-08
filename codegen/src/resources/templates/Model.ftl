package ${package_name}.model;
import com.wm.bcgame.base.AbstractModel;
import java.util.Date;




/**
* 描述：${table_annotation}
* @author ${author}
* @date ${date}
*/
public class ${table_name} extends AbstractModel {

    private static final long serialVersionUID = 1L;

<#if model_column?exists>
    <#list model_column as model>
        <#if model.ignore = false >
    //${model.columnComment!}
            <#if (model.columnType = 'varchar' || model.columnType = 'text')>
                <#assign datetype='String' />
            <#elseif (model.columnType = 'timestamp' || model.columnType = 'datetime')>
                <#assign datetype='Date' />
            <#elseif (model.columnType = 'decimal' || model.columnType = 'numeric')>
                <#assign datetype='Double' />
            <#elseif (model.columnType = 'int' || model.columnType = 'smallint')>
                <#assign datetype='Long'/>
            </#if>
    private ${datetype} ${model.changeColumnName?uncap_first};
        </#if>
    </#list>
</#if>
///////////////////////////////////////////////////////////////
<#if model_column?exists>
    <#list model_column as model>
        <#if model.ignore = false >
            <#if (model.columnType = 'varchar' || model.columnType = 'text')>
                <#assign datetype='String' />
            <#elseif (model.columnType = 'timestamp' || model.columnType = 'datetime')>
                <#assign datetype='Date' />
            <#elseif (model.columnType = 'decimal' || model.columnType = 'numeric')>
                <#assign datetype='Double' />
            <#elseif (model.columnType = 'int' || model.columnType = 'smallint')>
                <#assign datetype='Long'/>
            </#if>
    public ${datetype} get${model.changeColumnName}() {
        return this.${model.changeColumnName?uncap_first};
    }

    public void set${model.changeColumnName}(${datetype} ${model.changeColumnName?uncap_first}) {
        this.${model.changeColumnName?uncap_first} = ${model.changeColumnName?uncap_first};
    }
        </#if>
    </#list>
</#if>

}