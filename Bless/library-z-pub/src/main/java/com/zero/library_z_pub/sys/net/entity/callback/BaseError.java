package com.zero.library_z_pub.sys.net.entity.callback;

/**
 * Created by xiaocai on 2018/5/13.
 */

public class BaseError<E> {

    private int code;
    private String msg;
    private E exception;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public E getException() {
        return exception;
    }

    public void setException(E exception) {
        this.exception = exception;
    }
}
