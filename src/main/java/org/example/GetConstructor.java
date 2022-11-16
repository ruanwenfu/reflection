package org.example;

import org.example.entity.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class GetConstructor {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Student student = new Student("ruanwenfu");
        Class<? extends Student> clz = student.getClass();
        // 通过参数类型获取对应的构造方法
        Constructor<? extends Student> constructor = clz.getConstructor(String.class);
        // 创建时间
        Student student1 = constructor.newInstance("zhangfei");
        System.out.println(student1.getName());
    }
}
