package com.tao.ssmdemo.dao;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by TAO on 2018/10/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    /// @Ignore
    public void selectUserByName() throws Exception {
        int count=userMapper.selectUserByName("beyLi").size();
        Assert.assertEquals(2,count);
    }

}
