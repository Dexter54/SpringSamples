package com.ilgun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


import javax.sql.DataSource;
import java.sql.SQLException;

public class StudentManager {


    private Student stud;

    public StudentManager(Student temp) {
        System.out.println("Student Manager Cons");
        stud = temp;
    }

    public Student getStud(){
        return stud;

    }

    public void setStud(Student temp){
        System.out.println("Stud manager setstud");
        stud = temp;
    }





}
