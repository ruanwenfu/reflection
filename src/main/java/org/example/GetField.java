package org.example;

import org.example.entity.Student;

import java.lang.reflect.Field;

/**
 * 分析实例
 * 例如动态获取某个对象的值 获取字段
 */
public class GetField {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Student student = new Student("ruanwenfu");
        Class<? extends Student> clz = student.getClass();
        // 字段描述
        Field name = clz.getDeclaredField("name");
        // 暴力破解
        name.setAccessible(true);
        // 通过Field描述获取传入对象对应的字段
        Object o = name.get(student);
        System.out.println(o);
        // 设置字段的值
        name.set(student,"zhangfei");
        System.out.println(name.get(student));
    }
}
