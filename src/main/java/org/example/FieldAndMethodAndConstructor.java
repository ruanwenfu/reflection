package org.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 分析类的静态情况
 */
public class FieldAndMethodAndConstructor {
    public static void main(String[] args) throws ClassNotFoundException {
        // 加载类
        String name = "java.util.Random";
        Class<?> clz = Class.forName(name);
        // 获取父类
        Class<?> superclass = clz.getSuperclass();
        System.out.println(superclass);
        // 类的修饰符
        int modifiers = clz.getModifiers();
        // 修饰符相关的可以通过Modifier输出
        String s = Modifier.toString(modifiers);
        System.out.println(s);
        // 打印构造方法
        printConstructors(clz);
        System.out.println("----------------");
        // 打印方法
        printMethod(clz);
        System.out.println("----------------");
        // 打印字段
        printFields(clz);
    }

    public static void printConstructors(Class<?> clz){
        // 返回所有声明的构造函数,不包括父类
        Constructor<?>[] declaredConstructors = clz.getDeclaredConstructors();
        // 遍历构造函数
        for (Constructor<?> constructor : declaredConstructors) {
            // 构造函数名
            String name = constructor.getName();
            System.out.println("构造函数名"+name);
            System.out.println("函数修饰符"+Modifier.toString(constructor.getModifiers()));
            // 构造函数的参数
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            List<String> collect = Arrays.stream(parameterTypes).map(Class::getName).collect(Collectors.toList());
            System.out.println("构造函数参数"+String.join(",",collect));
        }
    }

    public static void printMethod(Class<?> clz){
        // 获取所有声明的方法，不包括父类
        Method[] methods = clz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("方法名"+method.getName());
            System.out.println("方法修饰符"+Modifier.toString(method.getModifiers()));
            System.out.println("方法返回值"+method.getReturnType().getName());
            // 方法参数
            Class<?>[] parameterTypes = method.getParameterTypes();
            List<String> collect = Arrays.stream(parameterTypes).map(Class::getName).collect(Collectors.toList());
            System.out.println("方法参数"+String.join(",",collect));
        }
    }

    public static void printFields(Class<?> clz){
        // 获取所有字段，不包括父类
        Field[] fields = clz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("字段名"+field.getName());
            System.out.println("字段修饰符"+Modifier.toString(field.getModifiers()));
            // 字段类型
            Class<?> type = field.getType();
            System.out.println("字段类型"+type.getName());
        }

    }
}
