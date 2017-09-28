package com.dbapp.junit;

import com.dbapp.spring.service.StaffInfoService;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @desc:
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/9/2
 * @Time： 23:57
 */
public class SpringAopTest {
    @Test
    public void test(){
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("spring-aop.xml");
        StaffInfoService staffInfoService = (StaffInfoService)ctx.getBean("staffInfoService");
        staffInfoService.save("xx");
    }
    @Test
    public void testConfig(){
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("spring-aop.xml");
        StaffInfoService staffInfoService = (StaffInfoService)ctx.getBean("staffInfoService");
        System.out.println("=============================");
        staffInfoService.save("xx");
        System.out.println("=============================");
        staffInfoService.getStaffName(1);
        System.out.println("=============================");
        staffInfoService.update("xx",1);
    }
}
