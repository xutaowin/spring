package com.dbapp.junit;

import com.dbapp.spring.demo.HelloSpring;
import com.dbapp.spring.demo.HelloSpringAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @desc:
 * @author: XT
 */
public class SpringDemoTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-demo.xml");
        HelloSpring helloSpring = context.getBean(HelloSpring.class);
        /*HelloSpring helloSpring = context.getBean(HelloSpring.class);
        HelloSpring helloSpring1 = (HelloSpring) context.getBean("helloSpring");
        System.out.println(helloSpring == helloSpring1);
        helloSpring.sayHello();
        System.out.println(helloSpring.toString());*/
        //context.destroy();
        /*HelloSpringAware helloSpringAware = (HelloSpringAware)context.getBean("helloSpringAware");
        HelloSpring helloSpring = (HelloSpring)helloSpringAware.getObjectByBeanFactory("helloSpring");
        HelloSpring helloSpring1 = (HelloSpring)helloSpringAware.getObjectByApplicationContext("helloSpring");
        helloSpring.sayHello();
        System.out.println(helloSpring == helloSpring1);*/
    }
}
