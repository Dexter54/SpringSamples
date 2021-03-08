package com.ilgun;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
//import jakarta.servlet.http.HttpSession;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller

public class SpringController {

    @Autowired
    private StudentValidator studentValidator;


    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(studentValidator);
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(ModelMap model) {

        Student temp = new Student();
        temp.setAge(18);
        temp.setName("onur");
        model.addAttribute("name", temp.getName());
        model.addAttribute("age", temp.getAge());
        return "index";
    }


    /*@RequestMapping("/sayfa/{id}")
    public ResponseEntity<String> sayfa(@MatrixVariable(required=false, defaultValue="1")int q) {
        return ResponseEntity.ok("<html><body style='background-color:gray'><h1 style='color:red'>Meyveler :" + q +  " !</h1></body></html>");
    }*/

    @GetMapping("/sayfa")
    public ResponseEntity<?> sayfa(@RequestParam MultiValueMap<String, String> multiValueMap) {

        return ResponseEntity.ok("<html><body style='background-color:gray'><h1 style='color:red'>Meyveler :" + multiValueMap.getFirst("firstname")+  " !</h1></body></html>");
    }

    @GetMapping("/cerez")
    public ResponseEntity<?> cerez(
            @CookieValue String JSESSIONID,
            @CookieValue("JSESSIONID") String cerez
    ) {
        return ResponseEntity.ok(JSESSIONID + "<br />" + cerez);
    }


    @RequestMapping("/modelx/{merhaba}")
    public ResponseEntity<String> modelx(
            @ModelAttribute(value = "merhaba") Long id
    ) {
        return ResponseEntity.ok(String.valueOf(id));
    }

    @RequestMapping("/modely")
    public ResponseEntity<String> modely(
            @ModelAttribute(value = "id") Long id
    ) {
        return ResponseEntity.ok(String.valueOf(id));
    }

    @RequestMapping("/form")
    public ModelAndView form(ModelMap modelMap,@ModelAttribute(value = "message") String message) {
        Student stu = new Student();
        modelMap.addAttribute("mesaj", message);
        modelMap.addAttribute("student",stu);
        return new ModelAndView("form", modelMap, HttpStatus.OK);
    }

    @RequestMapping("/son")
    public Object son(@ModelAttribute("student") @Validated  Student student,
                      BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "form";
        }else {
            return ResponseEntity.ok(student.getName() + student.getAge());
        }
    }

}
