package com.zero.library_z_pub.sys.net.helper;

import com.zero.library_z_pub.sys.net.constant.WanUrl;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xiaocai on 2018/5/13.
 */

public class RetrofitHelper {

    Retrofit mRetrofit;

    private static RetrofitHelper mInstance = new RetrofitHelper();

    private RetrofitHelper(){
        init();
    }

    public static RetrofitHelper getInstance(){
        return mInstance;
    }

    private void init(){
        mRetrofit = new Retrofit.Builder()
//                .client(OkHttpHelper.getInstance().getClient())
                .baseUrl(WanUrl.BASE_URL)
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Retrofit getRetrofit(){
        return mRetrofit;
    }

}
