package com.room.mixweb.designpattern;

/**
 * @author  dong
 * 单例设计模式
 */
public class Singleton {
    /**
     * 懒汉式单例
     */
    public static class LazySingletion{

        private LazySingletion() {
        }

        private static volatile LazySingletion instance=null;

        public static synchronized LazySingletion getInstance(){
            if (instance==null){
                instance=new LazySingletion();
            }
            return instance;
        }
    }

    /**
     * 饿汉式单例模式
     */
    private static class HungraySingleton{
        private static  final HungraySingleton instance=new HungraySingleton();
        private HungraySingleton(){}
        public static HungraySingleton getInstance(){
            return instance;
        }
    }

}
