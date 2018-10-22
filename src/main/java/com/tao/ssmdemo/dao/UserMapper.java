package com.tao.ssmdemo.dao;

import com.tao.ssmdemo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by TAO on 2018/9/30.
 */
@Mapper   //声明是一个Mapper,与springbootApplication中的@MapperScan二选一
@Repository
public interface UserMapper {

    List<User> selectUserByName(String name);

    void save(User user);

}
