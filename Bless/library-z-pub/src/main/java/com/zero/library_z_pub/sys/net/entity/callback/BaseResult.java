package com.zero.library_z_pub.sys.net.entity.callback;

/**
 * Created by xiaocai on 2018/5/13.
 */

public class BaseResult<T> {

//    private T data;
    private int errorCode;
    private String errorMsg;

//    public T getData() {
//        return data;
//    }
//
//    public void setData(T data) {
//        this.data = data;
//    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}
