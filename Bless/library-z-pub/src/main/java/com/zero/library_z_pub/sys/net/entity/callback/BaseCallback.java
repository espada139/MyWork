package com.zero.library_z_pub.sys.net.entity.callback;

/**
 * Created by xiaocai on 2018/5/13.
 */

public interface BaseCallback<T,E> {

    void onSuccess(BaseResult<T> result);
    void onFailure(BaseError<E> error);

}
