package com.dbapp.spring.context.support;

import com.dbapp.spring.context.DbappApplicationContext;
import com.dbapp.spring.bean.BeanDefinition;
import com.dbapp.spring.bean.PropertyDefinition;
import org.apache.commons.beanutils.ConvertUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassPathXmlDbappApplicationContext implements DbappApplicationContext {

    private List<BeanDefinition> beanDefinitions = new ArrayList<BeanDefinition>();
    private Map<String,Object> singletons = new HashMap<String, Object>();
    private List<PropertyDefinition> propertyDefinitions = null;
    public ClassPathXmlDbappApplicationContext(String configLocation){
        this.readConfig(configLocation);//读取配置文件
        this.instanceBeans();//实例化bean
        this.injectObject();//注入依赖对象
    }

    private void readConfig(String configLocation) {
        SAXReader saxReader = new SAXReader();
        Document document = null;
        try {
            URL configPath = this.getClass().getClassLoader().getResource(configLocation);
            document = saxReader.read(configPath);
            Map<String,String> nsMap = new HashMap<String, String>();
            nsMap.put("ns","http://www.springframework.org/schema/beans");//加入命名空间
            XPath xbean = document.createXPath("//ns:beans/ns:bean");//创建beans/bean的查询路径
            xbean.setNamespaceURIs(nsMap);//设置命名空间
            List<Element> beans = xbean.selectNodes(document);//获取文档下所有的bean
            BeanDefinition beanDefinition = null;
            PropertyDefinition propertyDefinition = null;
            for(Element element:beans){
                propertyDefinitions = new ArrayList<PropertyDefinition>();
                String id = element.attributeValue("id");//获取id
                String className = element.attributeValue("class");//获取class
                String factoryMethod = element.attributeValue("factory-method");//获取factoryMethod
                String factoryBean = element.attributeValue("factory-bean");//获取factoryBean
                beanDefinition = new BeanDefinition(id,className,factoryMethod,factoryBean);
                XPath xproperty = element.createXPath("ns:property");
                xproperty.setNamespaceURIs(nsMap);//设置命名空间
                List<Element> propertys = xproperty.selectNodes(element);//获取bean element下所有的property
                for(Element propertyElement:propertys){
                    String name = propertyElement.attributeValue("name");
                    String ref = propertyElement.attributeValue("ref");
                    String value = propertyElement.attributeValue("value");
                    propertyDefinition = new PropertyDefinition(name,ref,value);
                    propertyDefinitions.add(propertyDefinition);
                }
                beanDefinition.setPropertyDefinitions(propertyDefinitions);
                beanDefinitions.add(beanDefinition);
            }
        } catch (Exception e) {
        }
    }

    private void instanceBeans() {
        try {
            for(BeanDefinition beanDefinition:beanDefinitions){
                if(beanDefinition.getFactoryMethod()==null||"".equals(beanDefinition.getFactoryMethod())){//构造器
                    if (beanDefinition.getClassName()!=null&&!"".equals(beanDefinition.getClassName())) {
                        singletons.put(beanDefinition.getId(),Class.forName(beanDefinition.getClassName()).newInstance());
                    }
                }else{
                    if (beanDefinition.getClassName()!=null&&!"".equals(beanDefinition.getClassName())) {//静态工厂方法
                        if(beanDefinition.getFactoryBean()==null||"".equals(beanDefinition.getFactoryBean())){
                            Method staticMethod = Class.forName(beanDefinition.getClassName()).getDeclaredMethod(beanDefinition.getFactoryMethod());
                            singletons.put(beanDefinition.getId(),staticMethod.invoke(null));//参数是null，因为这是静态方法，不需要借助实例运行
                        }
                    } else {//工厂方法
                        String factoryBeanClassName = getFactoryBeanClassName(beanDefinition.getFactoryBean());
                        Method method = Class.forName(factoryBeanClassName).getDeclaredMethod(beanDefinition.getFactoryMethod());
                        singletons.put(beanDefinition.getId(),method.invoke(Class.forName(factoryBeanClassName).newInstance()));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void injectObject() {
        for(BeanDefinition beanDefinition:beanDefinitions){
            Object bean = getBean(beanDefinition.getId());
            try {
                if (bean!=null) {
                    PropertyDescriptor[] ps =Introspector.getBeanInfo(bean.getClass()).getPropertyDescriptors();//获取bean的属性
                    for(PropertyDefinition propertyDefinition:beanDefinition.getPropertyDefinitions()){
                        for(PropertyDescriptor psItem : ps){
                            if(psItem.getName().equals(propertyDefinition.getName())){
                                Method setMethod = psItem.getWriteMethod();//获取属性的set方法
                                if(setMethod!=null){
                                    Object value = null;
                                    System.out.println("propertyName:"+psItem.getName()+"propertyType:"+psItem.getPropertyType());
                                    if(propertyDefinition.getRef()!=null&&!"".equals(propertyDefinition.getRef())){
                                        value = singletons.get(propertyDefinition.getRef());
                                    }else{
                                        value = ConvertUtils.convert(propertyDefinition.getValue(),psItem.getPropertyType());//将String转化成属性对应类型的值
                                    }
                                    setMethod.setAccessible(true);//取消java权限控制检查
                                    setMethod.invoke(bean,value);//把引用对象注入到属性
                                }
                                break;
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Object getBean(String id){
        return singletons.get(id);
    }

    public String getFactoryBeanClassName(String factoryBeanName) {
        for(BeanDefinition beanDefinition:beanDefinitions){
            if(beanDefinition.getId().equals(factoryBeanName)){
                return beanDefinition.getClassName();
            }
        }
        return null;
    }
}
