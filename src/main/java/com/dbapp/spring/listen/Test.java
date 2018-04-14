package com.dbapp.spring.listen;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {  
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
          
        //HelloBean hello = (HelloBean) context.getBean("helloBean");  
        //hello.setApplicationContext(context);  
        EmailEvent event = new EmailEvent("hello","boylmx@163.com","this is a email text!");  
        context.publishEvent(event);  
        //System.out.println();  
    }  
}  