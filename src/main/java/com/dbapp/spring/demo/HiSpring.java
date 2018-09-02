package com.dbapp.spring.demo;

import lombok.Data;

/**
 * @desc:
 * @author: XT
 */
@Data
public class HiSpring {
    private int id;
    private String name;
    public HiSpring(){

    }

    public HiSpring(int id, String name){
        this.id = id;
        this.name = name;
    }

    public void sayHello(){
        System.out.println("hello spring");
    }

    @Override
    public String toString() {
        return "HelloSpring{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
