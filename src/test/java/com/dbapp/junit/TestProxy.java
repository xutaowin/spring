package com.dbapp.junit;

import com.dbapp.spring.proxy.CglibDynamicProxy;
import com.dbapp.spring.proxy.JDKDynamicProxy;
import com.dbapp.spring.proxy.StaticProxy;
import com.dbapp.spring.service.UserService;
import com.dbapp.spring.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @desc: 测试代理
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/9/2
 * @Time： 23:11
 */
public class TestProxy {
    @Test
    public void testStaticProxy(){
        //生成对应的代理对象
        StaticProxy proxy = new StaticProxy(new UserServiceImpl());
        proxy.add();
    }
    @Test
    public void testJDKDynamicProxy(){
        //生成对应的代理对象
        JDKDynamicProxy proxy = new JDKDynamicProxy();
        //需要绑定对应的委托者
        UserService service = (UserService)proxy.bind(new UserServiceImpl());
        //通过代理对象调用方法
        service.add();
    }
    @Test
    public void testCglibDynamicProxy(){
        //生成对应的代理对象
        CglibDynamicProxy proxy = new CglibDynamicProxy();
        //需要绑定对应的委托者
        UserService service = (UserService)proxy.bind(new UserServiceImpl());
        //通过代理对象调用方法
        service.add();
    }
}
