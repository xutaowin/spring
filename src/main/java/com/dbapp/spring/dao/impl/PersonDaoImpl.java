package com.dbapp.spring.dao.impl;

import com.dbapp.spring.dao.PersonDao;
import org.springframework.stereotype.Repository;

/**
 * @desc:
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/9/2
 * @Time： 22:18
 */
@Repository
/*@Scope("prototype")*/
public class PersonDaoImpl implements PersonDao {
    public PersonDaoImpl(){
        System.out.println("==========PersonDaoImpl Constructor==========");
    }
    //@PostConstruct
    public void init(){
        System.out.println("========PersonDao init===========");
    }
    public void save() {
        System.out.println("PersonDao save()");
    }
    //@PreDestroy
    public void destory(){
        System.out.println("========PersonDao destory===========");
    }
}
