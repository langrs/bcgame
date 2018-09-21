package com.wm;

import freemarker.template.Template;
import org.springframework.util.StringUtils;

import java.io.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

    private final String AUTHOR = "lzm";
    private final String CURRENT_DATE = "2018/09/07";
    private final String tableName = "t_sys_parm";
    private final String packageName = "com.wm.bcgame";
    private final String tableAnnotation = "质量问题";
    private final String URL = "jdbc:mysql://localhost:3306/bcgame";
    private final String USER = "root";
    private final String PASSWORD = "1";
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String diskPath = "D:\\work\\java\\workspace\\bcgame\\codegen\\src\\main\\java\\com\\wm\\bcgame\\";
    private final String mapperPath = "D:\\work\\java\\workspace\\bcgame\\codegen\\src\\resources\\com\\wm\\bcgame\\";

    private final String IGNOR = "disabled,create_time,create_by,last_modified_time,last_modified_by,";
    //    private final String changeTableName = replaceUnderLineAndUpperCase(tableName);
    private String changeTableName;
    private TableInfo tableInfo = new TableInfo();

    public static void main(String[] args) throws Exception {

        App codeGenerateUtils = new App();
        codeGenerateUtils.generate();
    }

    public Connection getConnection() throws Exception {
        Class.forName(DRIVER);
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;
    }

    public void generate() throws Exception {
        try {
            Connection connection = getConnection();
            DatabaseMetaData databaseMetaData = connection.getMetaData();

            ResultSet tables = databaseMetaData.getTables(null, "%", "t_%", new String[]{"TABLE"});
            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
//                changeTableName = replaceUnderLineAndUpperCase(tableName).substring(1);
                System.out.println(tableName);
                tableInfo.setTableName(tableName);
                tableInfo.setChangeTableName(replaceUnderLineAndUpperCase(tableName).substring(1));
                tableInfo.setTableAnnotation("");
                ResultSet resultSet = databaseMetaData.getColumns(null, "%", tableName, "%");
//                生成字段信息
                List<ColumnClass> columnClassList = new ArrayList<>();
                ColumnClass columnClass = null;
                while (resultSet.next()) {
                    //id字段略过
//                    if(resultSet.getString("COLUMN_NAME").equals("id")) continue;
                    columnClass = new ColumnClass();
                    //获取字段名称
                    columnClass.setColumnName(resultSet.getString("COLUMN_NAME"));
                    //获取字段类型
                    columnClass.setColumnType(resultSet.getString("TYPE_NAME").toLowerCase());
//                    转换jdbc类型
                    columnClass.setColumnTypeJdbc(changeJdbcType(columnClass.getColumnType()));
                    //转换字段名称，如 sys_name 变成 SysName
                    columnClass.setChangeColumnName(toLowerCaseFirstOne(replaceUnderLineAndUpperCase(resultSet.getString("COLUMN_NAME"))));
                    //字段在数据库的注释
                    columnClass.setColumnComment(resultSet.getString("REMARKS"));
//            排除特定基列字段
                    if (IGNOR.indexOf(columnClass.getColumnName()) >= 0) {
                        columnClass.setIgnore(true);
                    } else {
                        columnClass.setIgnore(false);
                    }

                    columnClassList.add(columnClass);
                    System.out.println(columnClass);
                }
                Map<String, Object> dataMap = new HashMap<>();
                dataMap.put("model_column", columnClassList);
                //生成实体类
                generateModelFile(dataMap);
                //生成Dao文件
                generateDaoFile(resultSet);
                //生成Mapper文件
                generateMapperFile(dataMap);
                //生成服务层接口文件
                generateServiceInterfaceFile(dataMap);
                //生成服务实现层文件
                generateServiceImplFile(dataMap);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {

        }
    }

    //生成实体类
    private void generateModelFile(Map<String, Object> dataMap) throws Exception {

        final String suffix = ".java";
        final String pkgname = "model\\";
        final String path = diskPath + pkgname + tableInfo.changeTableName + suffix;
        final String templateName = "Model.ftl";
        File mapperFile = new File(path);
        generateFileByTemplate(templateName, mapperFile, dataMap);

    }


    private void generateControllerFile(ResultSet resultSet) throws Exception {
        final String suffix = "Controller.java";
        final String path = diskPath + changeTableName + suffix;
        final String templateName = "Controller.ftl";
        File mapperFile = new File(path);
        Map<String, Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName, mapperFile, dataMap);
    }

    private void generateServiceImplFile(Map<String,Object> dataMap) throws Exception {
        final String suffix = "ServiceImpl.java";
        final String pkgname = "service\\impl\\";
        final String path = diskPath + pkgname + tableInfo.changeTableName + suffix;
        final String templateName = "ServiceImpl.ftl";
        File mapperFile = new File(path);
        generateFileByTemplate(templateName, mapperFile, dataMap);
    }

    private void generateServiceInterfaceFile(Map<String,Object> dataMap) throws Exception {
        final String suffix = "Service.java";
        final String pkgname = "service\\";
        final String path = diskPath + pkgname + tableInfo.changeTableName + suffix;
        final String templateName = "ServiceInterface.ftl";
        File mapperFile = new File(path);
        generateFileByTemplate(templateName, mapperFile, dataMap);
    }


    private void generateDaoFile(ResultSet resultSet) throws Exception {
        final String suffix = "Dao.java";
        final String pkgname = "dao\\";
        final String path = diskPath + pkgname + tableInfo.changeTableName + suffix;
        final String templateName = "DAO.ftl";
        File mapperFile = new File(path);
        Map<String, Object> dataMap = new HashMap<>();
        generateFileByTemplate(templateName, mapperFile, dataMap);

    }

    private void generateMapperFile(Map<String, Object> dataMap) throws Exception {
        final String suffix = "Dao.xml";
        final String pkgname = "dao\\";
        final String path = mapperPath + pkgname + tableInfo.changeTableName + suffix;
        final String templateName = "Mapper.ftl";
        File mapperFile = new File(path);
        generateFileByTemplate(templateName, mapperFile, dataMap);

    }

    //通过freemaker模板生成文件
    private void generateFileByTemplate(final String templateName, File file, Map<String, Object> dataMap) throws Exception {
        Template template = FreeMarkerTemplateUtils.getTemplate(templateName);
        FileOutputStream fos = new FileOutputStream(file);
        dataMap.put("table_name_small", tableInfo.getTableName());
        dataMap.put("table_name", tableInfo.getChangeTableName());
        dataMap.put("author", AUTHOR);
        dataMap.put("date", CURRENT_DATE);
        dataMap.put("package_name", packageName);
        dataMap.put("table_annotation", tableInfo.getTableAnnotation());
        Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"), 10240);
        template.process(dataMap, out);
    }

    //将下划线的表名称替换为驼峰命名
    public String replaceUnderLineAndUpperCase(String str) {
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        int count = sb.indexOf("_");
        while (count != 0) {
            int num = sb.indexOf("_", count);
            count = num + 1;
            if (num != -1) {
                char ss = sb.charAt(count);
                char ia = (char) (ss - 32);
                sb.replace(count, count + 1, ia + "");
            }
        }
        String result = sb.toString().replaceAll("_", "");
        return StringUtils.capitalize(result);
    }

    //首字母转小写
    public String toLowerCaseFirstOne(String str) {
        if(Character.isLowerCase(str.charAt(0))){
            return str;
        }else{
            return (new StringBuilder()).append(Character.toLowerCase(str.charAt(0))).append(str.substring(1)).toString();
        }
}

//转换jdbctype
    private String changeJdbcType(String type){
        String jdbcType = "";
        switch (type){
            case "int":jdbcType = "NUMERIC";break;
            case "smallint":jdbcType="NUMERIC";break;
            case "datetime":jdbcType="TIMESTAMP";break;
            case "varchar":jdbcType="VARCHAR";break;
            case "text":jdbcType="VARCHAR";break;
            case "number":jdbcType="NUMERIC";break;
            case "decimal":jdbcType="NUMERIC";break;
        }
        return jdbcType;
    }
    public class TableInfo{
        private String packageName;
        private String tableAnnotation;
        private String tableName;
        private String changeTableName;

        public String getPackageName() {
            return packageName;
        }

        public void setPackageName(String packageName) {
            this.packageName = packageName;
        }

        public String getTableAnnotation() {
            return tableAnnotation;
        }

        public void setTableAnnotation(String tableAnnotation) {
            this.tableAnnotation = tableAnnotation;
        }

        public String getTableName() {
            return tableName;
        }

        public void setTableName(String tableName) {
            this.tableName = tableName;
        }

        public String getChangeTableName() {
            return changeTableName;
        }

        public void setChangeTableName(String changeTableName) {
            this.changeTableName = changeTableName;
        }
    }

}
