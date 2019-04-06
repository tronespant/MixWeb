package com.room.mixweb.model;

import com.room.mixweb.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: Dong
 * @Description:
 * @Date:Created in 2:342019/3/30
 * @Modificd By:
 * @At : MixWeb
 */
@Mapper
public interface UserMapper {
    @Select("select * from user;")
    public List<User> find();
}
