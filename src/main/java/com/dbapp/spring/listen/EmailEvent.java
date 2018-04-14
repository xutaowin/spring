package com.dbapp.spring.listen;

import org.springframework.context.ApplicationEvent;

/**
 * @desc:
 * @company: DBAPP
 * @author: xutao
 * @DateTime： 2017/10/24 17:30
 */
public class EmailEvent extends ApplicationEvent {
    private static final long serialVersionUID = 1L;
    public String address;
    public String text;

    public EmailEvent(Object source) {
        super(source);
    }

    public EmailEvent(Object source, String address, String text) {
        super(source);
        this.address = address;
        this.text = text;
    }

    public void print(){
        System.out.println("hello spring event!");
    }
}
