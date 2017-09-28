package com.dbapp.spring.factory;

import com.dbapp.spring.service.PersonService;
import com.dbapp.spring.service.impl.PersonServiceImpl;

/**
 * @desc:
 * @Company :DBAPP
 * @Created By xutao
 * @Date： 2017/9/2
 * @Time： 22:00
 */
public class PersonServiceFactory {
    public static PersonService createPersonService(){
        return new PersonServiceImpl();
    }
    public PersonService createPersonService2(){
        return new PersonServiceImpl();
    }
}
