package com.zero.library_z_pub.sys.net.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zero.library_z_pub.sys.net.api.service.WanApiService;
import com.zero.library_z_pub.sys.net.entity.callback.BaseCallback;
import com.zero.library_z_pub.sys.net.entity.callback.BaseError;
import com.zero.library_z_pub.sys.net.entity.callback.BaseResult;
import com.zero.library_z_pub.sys.net.helper.RetrofitHelper;

import java.util.Map;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by xiaocai on 2018/5/13.
 */

public class WanApi {

    private WanApiService mWanApiService;
    private Gson mGson;

    private WanApi(){
        init();
    }

    private static WanApi mInstance = new WanApi();

    public static WanApi getInstance(){
        return mInstance;
    }

    private void init(){
        mWanApiService = RetrofitHelper.getInstance().getRetrofit().create(WanApiService.class);
        mGson = new Gson();
    }

    public void getArticalList(Map<String,String> params, final BaseCallback<String, Exception> callback){

        mWanApiService.getArticalList(params).enqueue(new Callback<BaseResult<String>>() {
            @Override
            public void onResponse(Call<BaseResult<String>> call, Response<BaseResult<String>> response) {

                if(response != null && response.body() != null){
                    BaseResult<String> result = null;//new Gson().fromJson(response.body(), new TypeToken<BaseResult<String>>(){}.getType());

                    if (callback != null) {
                        callback.onSuccess(result);
                    }
                }

            }

            @Override
            public void onFailure(Call<BaseResult<String>> call, Throwable t) {

                BaseError be = new BaseError();
                be.setException(t);

                if(callback != null){
                    callback.onFailure(be);
                }

            }
        });

    }

    public void getBanner(Map<String,String> params, final BaseCallback<String,Exception> callback){

        mWanApiService.getBanner(params).enqueue(new Callback<BaseResult<String>>() {
            @Override
            public void onResponse(Call<BaseResult<String>> call, Response<BaseResult<String>> response) {
                if(response != null && response.body() != null){
                    if(callback != null){
                        callback.onSuccess(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResult<String>> call, Throwable t) {
                BaseError be = new BaseError();
                be.setException(t);

                if(callback != null){
                    callback.onFailure(be);
                }
            }
        });

    }

    public void getFriend(Map<String,String> params, final BaseCallback<String,Exception> callback){

        mWanApiService.getFriend(params).enqueue(new Callback<BaseResult<String>>() {
            @Override
            public void onResponse(Call<BaseResult<String>> call, Response<BaseResult<String>> response) {
                if(response != null && response.body() != null){
                    if(callback != null){
                        callback.onSuccess(response.body());
                    }
                }
            }

            @Override
            public void onFailure(Call<BaseResult<String>> call, Throwable t) {
                BaseError be = new BaseError();
                be.setException(t);

                if(callback != null){
                    callback.onFailure(be);
                }
            }
        });

    }

}
