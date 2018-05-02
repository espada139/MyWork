package com.zero.library_z_pub.net;

import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2018/3/9.
 */

public class OkHttpHelper {

    private OkHttpClient mClient = null;

    private static class SingletonHolder {
        private static final OkHttpHelper INSTANCE = new OkHttpHelper();
    }

    private OkHttpHelper(){

        init();

    }

    public static final OkHttpHelper getInstance()
    {

        return SingletonHolder.INSTANCE;

    }

    public void init()
    {

        mClient = new OkHttpClient();

    }

    public OkHttpClient getClient()
    {

        return mClient;

    }

}
