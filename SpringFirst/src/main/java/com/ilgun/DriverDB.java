package com.ilgun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

public class DriverDB {


    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }


    public void setTemplate(JdbcTemplate template) {
        System.out.println("jdbc setter");
        this.template = template;
    }

    @Transactional
    public void save(StudentManager stu) {

        System.out.println(stu.getStud().getName() + "  " + stu.getStud().getSurname() + "   " +
                stu.getStud().getDep() + "   " + stu.getStud().getAge());

        template.update(
                "INSERT INTO info(name,surname,dep,age)  VALUES (?, ?, ?, ?)", stu.getStud().getName(), stu.getStud().getSurname(), stu.getStud().getDep(), stu.getStud().getAge());
    }
}
