package com.zero.library_z_pub.sys.db.dao;

import android.database.sqlite.SQLiteDatabase;

import com.zero.library_z_pub.sys.db.DBManager;

/**
 * Created by xiaocai on 2018/3/23.
 */

public class BaseDao {

    public SQLiteDatabase mDb;

    public BaseDao(){

        mDb = DBManager.getInstance().getDb();

    }

}
