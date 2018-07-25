package com.dbapp.junit;

import com.dbapp.spring.service.impl.UserServiceImpl;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @desc:生成动态代理的字节码文件
 * @author: XT
 */
public class ProxyGeneratorTest {
    public static void main(String[] args) {
        int accessFlags = Modifier.PUBLIC | Modifier.FINAL;
        byte[] proxyClassFile = ProxyGenerator.generateProxyClass(
                "proxy0", new Class[]{UserServiceImpl.class}, accessFlags);
        try {
            Path path = new File(System.getProperty("user.dir")+"/target/UserServiceImpl.class").toPath();
            Files.write(path,proxyClassFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
