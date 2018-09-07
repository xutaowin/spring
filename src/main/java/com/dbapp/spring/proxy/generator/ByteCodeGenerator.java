package com.dbapp.spring.proxy.generator;

import com.dbapp.spring.service.UserService;
import com.dbapp.spring.service.impl.UserServiceImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.file.Files;

/**
 * @desc: 字节码生成
 * @author: XT
 */
public class ByteCodeGenerator {
    /**
     * 根据目标对象生成字节码(JDK)
     * @param target
     * @param <T>
     * @return
     */
    public static <T> byte[] getByteCodeByJdkProxy(T target){
        int accessFlags = Modifier.PUBLIC | Modifier.FINAL;
        byte [] codes = ProxyGenerator.generateProxyClass("Proxy$0", target.getClass().getInterfaces(),accessFlags);
        return codes;
    }

    /**
     * 根据目标对象生成字节码(CGLIB)
     * @param target
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> byte[] getByteCodeByCglib(final T target) throws Exception {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                return methodProxy.invoke(target,objects);
            }
        });
        enhancer.create();
        byte [] codes = enhancer.getStrategy().generate(enhancer);
        return codes;
    }

    public static void main(String[] args) {
        /**
         * 测试jdk
         */
        /*try {
            byte [] codes = ByteCodeGenerator.getByteCodeByJdkProxy(new UserServiceImpl());
            File file = new File(System.getProperty("user.dir")+"/target/UserServiceImpl.class");
            Files.write(file.toPath(),codes);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        final Object target = new UserServiceImpl();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("begin");
                Object obj = methodProxy.invoke(target,objects);
                System.out.println("end");
                return obj;
            }
        });
        UserService userService = (UserService)enhancer.create();
        userService.update();
        /**
         * 测试cglib
         */
        /*try {
            FileOutputStream out = new FileOutputStream(System.getProperty("user.dir")+"/target/UserServiceImpl.class");
            out.write(ByteCodeGenerator.getByteCodeByCglib(new UserServiceImpl()));
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

}
