package com.zero.library_z_pub.sys.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by xiaocai on 2018/3/21.
 */

public class DBManager {

    private static class SingleHolder {

        private final static DBManager INSTANCE = new DBManager();

    }

    private DBHelper mDBHelper = null;
    private SQLiteDatabase mDb;

    private DBManager()
    {
    }

    public static DBManager getInstance(){

        return SingleHolder.INSTANCE;

    }

    public void init(Context context){

        if(context == null){

            return;

        }

        if(mDBHelper == null){

            mDBHelper = new DBHelper(context);

        }

        if(mDBHelper != null && mDb == null){

            mDb = mDBHelper.getWritableDatabase();

        }

    }

    public SQLiteDatabase getDb(){

        return this.mDb;

    }

    public void closeDB()
    {

        if(mDBHelper != null)
        {

            mDBHelper.close();

        }

    }

}
