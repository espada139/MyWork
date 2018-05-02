package com.zero.library_z_pub.sys.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.zero.library_z_pub.sys.db.entry.TestEntry;

/**
 * Created by xiaocai on 2018/3/21.
 */

public class DBHelper extends SQLiteOpenHelper {

    private final static String DB_NAME = "z.db";
    private final static int DB_VERSION = 1;

    public DBHelper(Context context)
    {

        this(context, DB_NAME, null, DB_VERSION);

    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {

        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {

        sqlCreate(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
    }

    @Override
    public void onOpen(SQLiteDatabase db)
    {
    }

    private void sqlCreate(SQLiteDatabase db)
    {

        if(db == null)
        {

            return;

        }

        db.execSQL(TestEntry.build().getSql());

    }

    private void sqlUpgrade(SQLiteDatabase db)
    {
    }

}
