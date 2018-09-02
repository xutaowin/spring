package com.dbapp.spring.demo;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.util.Arrays;

/**
 * @desc:
 * @author: XT
 */
public class BeanDefinitionReaderExample {
    public static void main(String[] args) {
        System.out.println("========================1====================");
        //注册中心
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //读取器
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        //资源加载器
        Resource resource = reader.getResourceLoader().getResource("spring-demo.xml");
        //装载构建Bean的定义
        reader.loadBeanDefinitions(resource);
        beanFactory.getAliases("helloSpring");
        beanFactory.getBeanDefinition("helloSpring");
        System.out.println(Arrays.toString(beanFactory.getBeanDefinitionNames()));
        System.out.println("========================2====================");
        //注册中心
        BeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();
        //读取器
        XmlBeanDefinitionReader reader2 = new XmlBeanDefinitionReader(registry);
        //资源加载器
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource2 = resourceLoader.getResource("spring-demo.xml");
        reader2.loadBeanDefinitions(resource2);
        registry.getAliases("helloSpring");
        registry.getBeanDefinition("helloSpring");
        System.out.println(Arrays.toString(registry.getBeanDefinitionNames()));
    }
}
