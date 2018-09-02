package com.dbapp.spring.demo;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.DefaultResourceLoader;

import java.util.Arrays;

/**
 * @desc:
 * @author: XT
 */
public class BeanFactoryExample {
    public static void main(String[] args) {
        // 注册 中心
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        //  读取器
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.setResourceLoader(new DefaultResourceLoader());
        // 装载构建Bean的定义
        reader.loadBeanDefinitions("spring-demo.xml");
        factory.getBean("helloSpring");
        //factory.getBean("hello");
        System.out.println(Arrays.toString(factory.getBeanDefinitionNames()));
    }
}
