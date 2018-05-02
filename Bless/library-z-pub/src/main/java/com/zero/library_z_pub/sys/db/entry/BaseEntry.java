package com.zero.library_z_pub.sys.db.entry;

import java.util.HashMap;

/**
 * Created by xiaocai on 2018/3/21.
 */

public abstract class BaseEntry {

    private StringBuilder sqlBuilder = new StringBuilder();

    private String tableName;

    public void setTableName(String table_name){

        tableName = table_name;

        sqlBuilder.append("CREATE TABLE ");
        sqlBuilder.append(tableName);

    }

    public StringBuilder getSqlBuilder()
    {

        return sqlBuilder;

    }

    public abstract String getSql();

    public String toString()
    {

        return sqlBuilder.toString();

    }

}
