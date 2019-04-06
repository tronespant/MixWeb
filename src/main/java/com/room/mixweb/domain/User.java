package com.room.mixweb.domain;

import lombok.Data;

/**
 * @Author:dong
 * @Despriction:
 * @Date:my Create in 15:52 2019/3/19
 * @Modify by:
 */
@Data
public class User {
    private int id;
    private String name;
    private String age;

    public User() {
    }

    public User(int id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }
}
