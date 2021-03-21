package com.ilgun;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class Student {

    private Integer age;


    private String name;

    private String surname;

    private String Dep;


    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;

    }

    public Integer getAge() {

        return age;
    }

    public void setAge(Integer age) {

        this.age = age;
    }

    public void printThrowException(){
        System.out.println("Exception raised");
        throw new IllegalArgumentException();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDep() {
        return Dep;
    }

    public void setDep(String dep) {
        Dep = dep;
    }
}
