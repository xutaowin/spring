package com.dbapp.spring.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @desc: CGLIB动态代理
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/9/2
 * @Time： 23:32
 */
public class CglibDynamicProxy implements MethodInterceptor {
    private Object targetObject;//委托对象，也就是代理的目标对象
    //代理对象和委托者绑定
    public Object bind(Object targetObject){
        this.targetObject = targetObject;
        //Cglib中的核心对象，该类用于生成代理对象
        Enhancer enhancer = new Enhancer();
        //指定委托类为父类
        enhancer.setSuperclass(this.targetObject.getClass());
        //使用代理，需要一个对应的代理对象
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGLIB日志记录开始");
        //委托类变成了父类。调用真正的服务提供者
        Object obj = methodProxy.invoke(this.targetObject,args);
        System.out.println("CGLIB日志记录结束");
        return obj;
    }
}
