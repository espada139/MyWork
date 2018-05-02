package com.zero.library_z_pub.sys.provider;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

/**
 * Created by Administrator on 2018/3/16.
 */

public class ContactsHelper {

    private final static String CONTACT_URI = "content://com.android.contacts/contacts";

    private static class SingleTonHolder {

        private final static ContactsHelper INSTANCE = new ContactsHelper();

    }

    private Context mContext; //使用getApplicationContext()获取的Context

    private ContactsHelper()
    {
    }

    public static ContactsHelper getInstance(){

        return SingleTonHolder.INSTANCE;

    }

    public void init(Context context)
    {

        mContext = context;

    }

    public void getContacts()
    {

        Uri uri = ContactsContract.Contacts.CONTENT_URI;

        String[] projection = new String[]{ContactsContract.Contacts._ID, ContactsContract.Contacts.DISPLAY_NAME};

        Cursor cursor = mContext.getContentResolver().query(uri, projection, null, null, null);

        if(cursor != null)
        {

            while (cursor.moveToNext())
            {

                Long id = cursor.getLong(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                String displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));

                System.out.println(">>>> debug ContactsHelper id = "+id+" display_name = "+displayName);

            }

        }

    }

}
