package com.room.mixweb.domain;

import lombok.Data;

/**
 * @Author:dong
 * @Despriction:
 * @Date:my Create in 15:49 2019/3/17
 * @Modify by:
 */
@Data
public class PageFormData<T>{
    private int code;
    private String msg;
    private int count;
    private java.util.List<T> data;

    //private String data;
}
