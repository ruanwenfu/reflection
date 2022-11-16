package org.example;

import org.example.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException {
        // 获取Class对象的三种方式
        // 方式一
        Student student = new Student("xiaoming");
        Class<? extends Student> aClass = student.getClass();
        // 方式二
        Class<?> aClass1 = Class.forName("org.example.entity.Student");
        // 方式三
        Class<Student> studentClass = Student.class;
        System.out.println(aClass == aClass1);
        System.out.println(aClass == studentClass);

        System.out.println(int.class);
    }
}
