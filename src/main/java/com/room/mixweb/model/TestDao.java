package com.room.mixweb.model;

import com.room.mixweb.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @Author: Dong
 * @Description:
 * @Date:Created in 2:042019/3/30
 * @Modificd By:
 * @At : MixWeb
 */
@Mapper()
public interface TestDao {
    @Select("select * from user;")
    public List<User> find();
}
