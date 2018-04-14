package com.dbapp.junit;

import com.dbapp.spring.dao.UserDao;
import com.dbapp.spring.dao.impl.UserDaoImpl;
import com.dbapp.spring.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.util.Assert;

/**
 * @desc:
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/10/16
 * @Time： 21:53
 */
public class BeanFactoryTest {
    /**
     * Bean 创建
     */
    @Test
    public void createBeanTest(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        UserServiceImpl userService = factory.createBean(UserServiceImpl.class);
        userService.add();
    }
    /**
     * Bean 存储
     */
    @Test
    public void beanStoreTest(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerSingleton("dao",new UserDaoImpl());
        UserDao userDao = (UserDaoImpl)factory.getBean("dao");
        userDao.add();
    }

    /**
     * 依赖注入
     */
    @Test
    public void dependsTest(){
        try {
            DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
            factory.registerSingleton("dao",new UserDaoImpl());
            UserServiceImpl userService = (UserServiceImpl) factory.createBean(UserServiceImpl.class, AbstractBeanDefinition.AUTOWIRE_BY_TYPE,true);
            userService.add();
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getBeanTest(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions("spring.xml");
        UserServiceImpl userService = (UserServiceImpl) factory.createBean(UserServiceImpl.class, AbstractBeanDefinition.AUTOWIRE_BY_TYPE,true);
        Assert.notNull(userService,"bean不能为空！");
        Assert.notNull(userService.getUserDao(),"dao不能为空！");
        userService.add();
    }
}
