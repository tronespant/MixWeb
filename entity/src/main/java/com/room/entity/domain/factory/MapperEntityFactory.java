package com.room.entity.domain.factory;

import com.room.entity.domain.bean.BeanFactory;
import lombok.extern.log4j.Log4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Dong
 * @Description:
 * @Date:Created in 21:492019/4/1
 * @Modificd By:
 * @At : MixWeb
 */
@Log4j
public class MapperEntityFactory implements EntityFactory, BeanFactory {
    private Map<Class,Mapper> realTypeMapper=new HashMap<>();

    private Map<String,PropertyCopier> copierCache=new HashMap<>();

    private static final DefaultMapperFactory DEFAULT_MAPPER_FACTORY=clazz ->{
        String simpleClassName=clazz.getPackage().getName().concat(clazz.getSimpleName());
        try {
            return defaultMapper(Class.forName(simpleClassName));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    };
    /**
     * 默认的属性复制器
     */
    private static final DefaultPropertyCopier DEFAULT_PROPERTY_COPIER=FastBeanCopier::copy;

    private DefaultMapperFactory defaultMapperFactory=DEFAULT_MAPPER_FACTORY;

    private DefaultPropertyCopier defaultPropertyCopier=DEFAULT_PROPERTY_COPIER;

    public MapperEntityFactory() {
    }
    public <T> MapperEntityFactory (Map<Class<T>,Mapper> realTypeMapper){
        this.realTypeMapper.putAll(realTypeMapper);
    }

    public <T> MapperEntityFactory addMapping(Class<T> target,Mapper<? extends T> mapper){
       realTypeMapper.put(target,mapper);
        return this;
    }
    public <T> MapperEntityFactory addCopier(PropertyCopier copier){

        return this;
    }
    private static String defaultMapper(Class<?> forName) {
        return null;
    }

    @Override
    public <T> T newInstance(Class<T> entityClass) {
        return null;
    }

    @Override
    public <T> T newInstance(Class<T> entityClass, Class<? extends T> defaultClass) {
        return null;
    }

    @Override
    public <T> Class<T> getInstanceType(Class<T> entityClass) {
        return null;
    }

    @Override
    public <S, T> T copyProperties(S source, T target) {
        return null;
    }
}
