package com.room.mixweb.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Author:dong
 * @Despriction:
 * @Date:my Create in 13:28 2019/3/18
 * @Modify by:
 */
public class CommonModel <T> {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public void getData(){

    }
}
