package com.zero.library_z_pub.sys.db.dao;

import java.util.List;

/**
 * Created by xiaocai on 2018/3/23.
 */

public interface IDao<T> {

    public List<T> query();
    public T queryRaw();
    public void insert();
    public void update();
    public void delete();

}
