package com.tao.ssmdemo.exception.handler;

import com.tao.ssmdemo.enums.ResultEnum;

/**
 * Created by TAO on 2018/10/8.
 */
public class GirlException extends RuntimeException{
    private Integer code;

    //直接传值，code和提示信息硬编码写死
   /* public GirlException(Integer code,String msg) {
        super(msg);
        this.code = code;
    }*/

    //改版后枚举维护，code值和所对应的提示信息
    public GirlException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code=resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
