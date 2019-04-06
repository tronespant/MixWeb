package com.room.mixweb.utils;


import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.log4j.Log4j;
import org.springframework.boot.configurationprocessor.json.JSONArray;

import java.util.Collection;

/**
 * @Author:dong
 * @Despriction:
 * @Date:my Create in 14:36 2019/3/17
 * @Modify by:
 */
@Log4j
public class TranformToJson<T> {

    static Gson gson=new Gson();

    public  String listToJson(Collection<T> collection,String[] exclusionFiled){
        String json = gson.toJson(collection);
        if (!"".equals(json)&&json!=null){
            return json;
        }
        log.debug("转换失败!!");
        return null;
    }
    public  String listToJsonByEx(Collection<T> collection,String[] exclusionFiled){



        String json = this.getGson(exclusionFiled).toJson(collection);

        if (!"".equals(json)&&json!=null){
            return json;
        }
        log.debug("转换失败!!");
        return null;
    }
    public Gson getGson(String[] exclusionFiled){
        Gson exGson= new GsonBuilder().addSerializationExclusionStrategy(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes fieldAttr) {
                for (int i=0;i<exclusionFiled.length;i++){
                    if (fieldAttr.getName().equals(exclusionFiled[i])){
                        return true;
                    }
                }

                return false;
            }

            @Override
            public boolean shouldSkipClass(Class<?> aClass) {
                return false;
            }
        }).create();
        return exGson;
    }
    public String toJsonByObject(T t,String[] exclusionFiled){
        String json = this.getGson(exclusionFiled).toJson(t);

        if (json!=null&&!"".equals(json)){
            return json;
        }
        log.debug("转换出错!");
        return "";
    }
}
