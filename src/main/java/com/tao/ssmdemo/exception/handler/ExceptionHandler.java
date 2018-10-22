package com.tao.ssmdemo.exception.handler;

import com.tao.ssmdemo.utils.Result;
import com.tao.ssmdemo.utils.ResultUtil;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

/**
 * Created by TAO on 2018/10/8.
 */
@ControllerAdvice
public class ExceptionHandler {

    private final static org.slf4j.Logger logger= LoggerFactory.getLogger(ExceptionHandler.class);

    @org.springframework.web.bind.annotation.ExceptionHandler(value=Exception.class)
    @ResponseBody
    public Result handler(Exception e){
        if(e instanceof GirlException){
            GirlException girlException=(GirlException) e;
            return ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }else{
            logger.info("[系统异常]{}",e);
            return ResultUtil.error(-1,"未知错误！");
        }
    }

}
