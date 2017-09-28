package com.dbapp.spring.service.impl;

import com.dbapp.spring.dao.PersonDao;
import com.dbapp.spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @desc:
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/9/2
 * @Time： 21:53
 */
@Service("personService")
public class PersonServiceImpl implements PersonService {

    private String name;
    private Integer age;
    private int num;
    @Autowired
    //@Qualifier("personDao")
    //@Resource(name="personDao")
    private PersonDao personDao;

    public  PersonServiceImpl(){
        System.out.println("====PersonServiceImpl Constructor====");
    }

    /**
     * 构造函数注入
     * @param personDao
     */
    /*public PersonServiceImpl(PersonDao personDao){
        this.personDao = personDao;
    }*/

    public void save() {
        //System.out.println("name:"+name+",age:"+age+",num:"+num);
        //personDao.save();
        System.out.println("PersonService save();");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setNum(int num) {
        this.num = num;
    }

    //@Autowired
    /*public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }*/
}
