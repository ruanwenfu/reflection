package org.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

// 构造反射
public class NewInstance {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // var className = "java.util.Random";
        var className = "org.example.entity.Student";
        Class<?> clz = Class.forName(className);
        // 获取对象的无参构造 如果对象没有无参构造将会报错
        Constructor<?> constructor = clz.getConstructor();
        // newInstance创建实例
        Object o = constructor.newInstance();
        System.out.println(o.getClass());
    }
}
