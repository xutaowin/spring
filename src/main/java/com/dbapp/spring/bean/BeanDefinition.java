package com.dbapp.spring.bean;

import java.util.List;

/**
 * @desc:
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/9/2
 * @Time： 22:54
 */
public class BeanDefinition {
    private String id;
    private String className;
    private String factoryMethod;
    private String factoryBean;
    private List<PropertyDefinition> propertyDefinitions;

    public BeanDefinition(String id, String className,String factoryMethod,String factoryBean) {
        this.id = id;
        this.className = className;
        this.factoryMethod = factoryMethod;
        this.factoryBean = factoryBean;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getFactoryBean() {
        return factoryBean;
    }

    public void setFactoryBean(String factoryBean) {
        this.factoryBean = factoryBean;
    }

    public String getFactoryMethod() {
        return factoryMethod;
    }

    public void setFactoryMethod(String factoryMethod) {
        this.factoryMethod = factoryMethod;
    }

    public List<PropertyDefinition> getPropertyDefinitions() {
        return propertyDefinitions;
    }

    public void setPropertyDefinitions(List<PropertyDefinition> propertyDefinitions) {
        this.propertyDefinitions = propertyDefinitions;
    }
}
