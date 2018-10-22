package com.tao.ssmdemo.controller;

import com.tao.ssmdemo.dao.UserMapper;
import com.tao.ssmdemo.domain.User;
import com.tao.ssmdemo.enums.ResultEnum;
import com.tao.ssmdemo.exception.handler.GirlException;
import com.tao.ssmdemo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.BindException;
import java.util.List;

/**
 * Created by TAO on 2018/9/30.
 */

@ResponseBody
@Controller
//@RestController
@RequestMapping("/demo")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value="/user",method= RequestMethod.GET)
    public List<User> query(){
        List<User> userList = userMapper.selectUserByName("beyLi");
        return userList;
    }

    @RequestMapping(value="/save",method=RequestMethod.GET)
    //@Valid中的提示信息被bindingResult绑定
    public void saveUser(@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            //统一异常处
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
            //System.out.print(ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage()));
        }else
            userMapper.save(user);
            //ResultUtil.success(girlRepository.save(girl));
    }

}
