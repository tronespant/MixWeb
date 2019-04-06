package com.room.mixweb.designpattern;

/**
 * 原型模式的结构和实现
 * @author dong
 */
public class Prototype {
    class Realizetype implements Cloneable{
        Realizetype(){
            System.out.println("具体原型创建成功");
        }
        public Object clone() throws CloneNotSupportedException {
            System.out.println("具体原型复制成功");
            return (Realizetype)super.clone();
        }
    }
}
