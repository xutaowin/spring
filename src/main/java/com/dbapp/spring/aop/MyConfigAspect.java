package com.dbapp.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @desc: 切面
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/9/2
 * @Time： 23:47
 */
public class MyConfigAspect {
    public void doAcceccCheck(){
        System.out.println("前置通知");
    }

    public void doAfterReturning(){
        System.out.println("后置通知");
    }

    public void doAfter(){
        System.out.println("最终通知");
    }

    public void doAfterThrowing(){
        System.out.println("意外通知");
    }

    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("进入方法");
        Object result = pjp.proceed();
        System.out.println("退出方法");
        return result;
    }
}
