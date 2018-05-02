package com.zero.library_z_pub.sys.db.dao;

import com.zero.library_z_pub.sys.db.DBManager;

import java.util.List;

/**
 * Created by xiaocai on 2018/3/22.
 */

public class TestDao extends BaseDao implements IDao<String> {

    public TestDao(){

        super();

    }

    @Override
    public List<String> query(){

        return null;

    }

    @Override
    public String queryRaw(){

        return null;

    }

    @Override
    public void insert(){
    }

    @Override
    public void update(){
    }

    @Override
    public void delete(){
    }

    public static TestDao build(){

        return new TestDao();

    }

}
