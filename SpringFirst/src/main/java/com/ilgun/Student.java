package com.ilgun;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class Student {

    private Integer age;


    private String name;


    public String getName() {
        System.out.println("name : " + name);
        return name;
    }

    public void setName(String name) {
        System.out.println("setter1 : ");
        this.name = name;

    }

    public Integer getAge() {
        System.out.println("age : " + age);
        return age;
    }

    public void setAge(Integer age) {
        System.out.println("setter2 : ");
        this.age = age;
    }

    public void printThrowException(){
        System.out.println("Exception raised");
        throw new IllegalArgumentException();
    }
}
