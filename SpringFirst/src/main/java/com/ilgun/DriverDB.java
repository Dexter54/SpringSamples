package com.ilgun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Transactional
public class DriverDB {


    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }


    public void setTemplate(JdbcTemplate template) {
        System.out.println("jdbc setter2");
        this.template = template;
    }

    @Autowired
    @Qualifier("txManager")
    PlatformTransactionManager transactionManager;

    public void save(StudentManager stu) {
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);

        System.out.println(status);
        System.out.println(stu.getStud().getName() + "  " + stu.getStud().getSurname() + "   " +
                stu.getStud().getDep() + "   " + stu.getStud().getAge());

        int result = template.update(
                "INSERT INTO info(name,surname,dep,age)  VALUES (?, ?, ?, ?)", stu.getStud().getName(), stu.getStud().getSurname(), stu.getStud().getDep(), stu.getStud().getAge());

        System.out.println(result);

        transactionManager.commit(status);
        System.out.println(result);
    }
}
