package com.dbapp.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @desc: JDK动态代理 实现一个接口：InvocationHandler 一个类：proxy
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/9/2
 * @Time： 23:16
 */
public class JDKDynamicProxy implements InvocationHandler {
    //只写一个代理类 都能代理
    private Object targetObject;//委托类也就是目标对象

    /**
     * 返回代理对象
     * @param targetObject
     * @return
     */
    public Object bind(Object targetObject){
        this.targetObject = targetObject;
        return Proxy.newProxyInstance(this.targetObject.getClass().getClassLoader(),
                this.targetObject.getClass().getInterfaces(),this);
    }

    /**
     * 代理对象调用对应的方法时，会自动调用invoke方法，有统一的入口，设计模式中的门面模式
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //写对应的增强代码
        System.out.println("日志记录开始");
        //真是的服务，必须由委托者来提供
        Object obj = method.invoke(this.targetObject,args);
        System.out.println("日志记录结束");
        return obj;
    }
}
