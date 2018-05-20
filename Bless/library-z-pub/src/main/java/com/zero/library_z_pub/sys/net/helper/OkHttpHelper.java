package com.zero.library_z_pub.sys.net.helper;

import okhttp3.OkHttpClient;

/**
 * Created by xiaocai on 2018/5/13.
 */

public class OkHttpHelper {

    private OkHttpClient mClient;

    private static OkHttpHelper mInstance = new OkHttpHelper();

    private OkHttpHelper(){
        init();
    }

    public static OkHttpHelper getInstance(){
        return mInstance;
    }

    public void init(){
        mClient = new OkHttpClient.Builder().build();
    }

    public OkHttpClient getClient(){
        return mClient;
    }

}
