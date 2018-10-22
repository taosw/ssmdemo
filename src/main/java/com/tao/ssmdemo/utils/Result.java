package com.tao.ssmdemo.utils;

/**
 * Created by TAO on 2018/10/8.
 */
public class Result<T> {
    /**错误码*/
    private Integer code;
    /**提示信息*/
    private String msg;
    /**返回的data具体内容*/
    private T data;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

}
