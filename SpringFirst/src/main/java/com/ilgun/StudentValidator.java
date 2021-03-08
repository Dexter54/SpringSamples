package com.ilgun;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class StudentValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Student.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {

        ValidationUtils.rejectIfEmpty(errors, "name", "boş olamaz");
        ValidationUtils.rejectIfEmpty(errors, "age", "boş olamaz");




    }



}
