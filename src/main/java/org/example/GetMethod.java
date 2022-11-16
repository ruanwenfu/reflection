package org.example;

import org.example.entity.Student;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 利用反射调用任意方法
 */
public class GetMethod {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Student student = new Student("ruanwenfu");
        Class<? extends Student> clz = student.getClass();
        Method m = clz.getMethod("getName");  // 通过方法名和方法参数获取方法
        String invoke = (String)m.invoke(student);
        System.out.println(invoke);
    }
}
