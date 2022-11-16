package org.example;

import java.io.InputStream;
import java.net.URL;

/**
 * 利用反射寻找资源
 */
public class Resource {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clz = Class.forName("org.example.resource.ResourceTest");
        // 获取资源的URL
        URL resource = clz.getResource("../../../a.txt");
        System.out.println(resource);
        // 使用流的方式读取资源
        InputStream resourceAsStream = clz.getResourceAsStream("../../../a.txt");
        System.out.println(resourceAsStream);
    }
}
