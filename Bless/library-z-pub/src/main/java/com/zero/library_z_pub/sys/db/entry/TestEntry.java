package com.zero.library_z_pub.sys.db.entry;

/**
 * Created by xiaocai on 2018/3/21.
 */

public class TestEntry extends BaseEntry {

    private String user_name;
    private String password;

    @Override
    public String getSql(){

        setTableName("test");

        getSqlBuilder().append("(");
        getSqlBuilder().append("user_name TEXT NOT NULL,");
        getSqlBuilder().append("password TEXT NOT NULL");
        getSqlBuilder().append(");");

        return getSqlBuilder().toString();

    }

    public static TestEntry build()
    {

        return new TestEntry();

    }

}
