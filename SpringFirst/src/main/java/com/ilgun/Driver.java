package com.ilgun;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Driver {

    public static void main(String[] args) {
        /*ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        HelloWorld obj = (HelloWorld) context.getBean("HelloWorld");
        obj.getMessage();*/

        /*ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        JavaCollection jc=(JavaCollection)context.getBean("xjavaCollection");

        jc.getAddressList();
        jc.getAddressSet();
        jc.getAddressMap();
        jc.getAddressProp();*/

        /*Car temp = new Car();
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringFirstConfig.class);

        HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
        helloWorld.setMessage(temp);
        helloWorld.getMessage();*/

        ApplicationContext context = new ClassPathXmlApplicationContext("src/main/webapp/WEB-INF/spring-config.xml");

        Student student = (Student) context.getBean("student");
        student.getName();
        student.getAge();
        student.printThrowException();

    }
}
