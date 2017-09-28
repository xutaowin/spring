package com.dbapp.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @desc: 基于注解定义一个切面
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/9/2
 * @Time： 23:47
 */
@Aspect
public class MyAnnotationAspect {
    /**
     * 第一个*返回值 service..表示service包以及子包 *表示所有 (..)表示0到多个参数
     */
    @Pointcut("execution (* com.dbapp.spring.service..*.*(..))")
    public void anyMethod(){}//声明一个切入点

    @Before("anyMethod() && args(name)")
    public void doAcceccCheck(String name){
        System.out.println("前置通知:"+name);
    }

    @AfterReturning(pointcut = "anyMethod()",returning = "result")
    public void doAfterReturning(String result){
        System.out.println("后置通知:"+result);
    }

    @After("anyMethod()")
    public void doAfter(){
        System.out.println("最终通知");
    }

    @AfterThrowing(pointcut = "anyMethod()",throwing = "e")
    public void doAfterThrowing(Exception e){
        System.out.println("意外通知:"+e);
    }

    @Around("anyMethod()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("进入方法");
        Object result = pjp.proceed();
        System.out.println("退出方法");
        return result;
    }
}
