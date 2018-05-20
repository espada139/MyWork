package com.zero.library_z_pub.sys.net.api.service;

import com.zero.library_z_pub.sys.net.api.WanApi;
import com.zero.library_z_pub.sys.net.constant.WanUrl;
import com.zero.library_z_pub.sys.net.entity.callback.BaseResult;

import java.util.Map;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by xiaocai on 2018/5/13.
 */

public interface WanApiService {

    @GET(WanUrl.ARTICAL_LIST)
    public Call<BaseResult<String>> getArticalList(@QueryMap Map<String,String> params);

    @GET(WanUrl.BANNER)
    public Call<BaseResult<String>> getBanner(@QueryMap Map<String,String> params);

    @GET(WanUrl.FRIEND)
    public Call<BaseResult<String>> getFriend(@QueryMap Map<String,String> params);

}
