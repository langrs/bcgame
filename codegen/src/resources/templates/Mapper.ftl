<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${package_name}.dao.${table_name}Dao">
    <resultMap id="${table_name}" type="${package_name}.model.${table_name}">
	<#list model_column as col>
	<#if col.columnName == "id">
		<id property="id" column="id" jdbcType="NUMERIC" />
    <#else>
		<result property= "${col.changeColumnName}" column="${col.columnName}" jdbcType="${col.columnTypeJdbc}" />
    </#if>
    </#list>
    </resultMap>

    <sql id="whereId">
        id=${r'#'}{id}
    </sql>

    <sql id="columns">
	<#list model_column as col>
        <#if (model_column?size - 1) = col_index>
            ${col.columnName}
        <#else>
            ${col.columnName},
        </#if>
    </#list>
    </sql>

    <sql id="dynamicWhere">
        <where>
		<#list model_column as col>
		<#if col.columnType == "datetime">
       	<if test="${col.changeColumnName}Start != null"> AND  ${col.columnName} <![CDATA[ >= ]]> ${r'#'}{${col.changeColumnName}Start} AND ${col.columnName} <![CDATA[ < ]]> ${r'#'}{${col.changeColumnName}End}</if>
        <#else>
       	<if test="${col.changeColumnName} != null"> AND ${col.columnName} like '%${r'$'}{${col.changeColumnName}}%' </if>
        </#if>
        </#list>
        </where>
    </sql>

    <sql id="oneWhere">
        <where>
		<#list model_column as col>
		<#if col.columnType == "datetime">
       	<if test="${col.changeColumnName}Start != null"> AND ${col.columnName} <![CDATA[ >= ]]> ${r'#'}{${col.changeColumnName}Start} AND ${col.columnName} <![CDATA[ < ]]> ${r'#'}{${col.changeColumnName}End}</if>
        <#else>
       	<if test="${col.changeColumnName} != null"> AND ${col.columnName} = ${r'#'}{${col.changeColumnName}}</if>
        </#if>
        </#list>
        </where>
    </sql>

    <insert id="create" parameterType="${package_name}.model.${table_name}">
        INSERT INTO ${table_name_small}
        (<include refid="columns"/>)
        VALUES(
		<#list model_column as col>
            <#if (model_column?size - 1) = col_index>
                ${r'#'}{${col.changeColumnName},jdbcType=${col.columnTypeJdbc}}
            <#else>
                ${r'#'}{${col.changeColumnName},jdbcType=${col.columnTypeJdbc}},
            </#if>
        </#list>
        )
    </insert>

    <delete id="delete" parameterType="java.lang.Long">
        DELETE FROM ${table_name_small}
        WHERE
        <include refid="whereId"/>
    </delete>
    <update id="update" parameterType="${package_name}.model.${table_name}">
        UPDATE ${table_name_small} SET
		<#list model_column as col>
            <#if (model_column?size - 1) = col_index>
                ${col.columnName}=${r'#'}{${col.changeColumnName},jdbcType=${col.columnTypeJdbc}}
            <#else>
                ${col.columnName}=${r'#'}{${col.changeColumnName},jdbcType=${col.columnTypeJdbc}},
            </#if>
        </#list>
        WHERE
        <include refid="whereId"/>
    </update>

    <select id="get" parameterType="java.lang.Long" resultMap="${table_name}">
        SELECT <include refid="columns"/>
        FROM ${table_name_small}
        WHERE
        <include refid="whereId"/>
    </select>

    <select id="query" resultMap="${table_name}">
        SELECT <include refid="columns"/>
        FROM ${table_name_small}
        <include refid="dynamicWhere" />
    </select>
    <select id="search" resultMap="${table_name}">
        SELECT <include refid="columns"/>
        FROM ${table_name_small}
        <include refid="dynamicWhere" />
    </select>
    <select id="getOne" resultMap="${table_name}">
        SELECT <include refid="columns"/>
        FROM ${table_name_small}
        <include refid="oneWhere" />
    </select>

    <select id="getList" resultMap="${table_name}">
        SELECT <include refid="columns"/>
        FROM ${table_name_small}
        <include refid="oneWhere" />
    </select>

    <select id="getAll" resultMap="${table_name}">
        SELECT <include refid="columns"/>
        FROM ${table_name_small}
    </select>
</mapper>