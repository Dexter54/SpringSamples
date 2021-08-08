package com.ilgun;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
//import jakarta.servlet.http.HttpSession;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.sql.DataSource;
import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;

@Controller
public class SpringController {

    @Autowired
    DriverDB driver;

    @Autowired
    Student temp;

    /*@Autowired
    private StudentValidator studentValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(studentValidator);
    }*/

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(ModelMap model) {

        model.addAttribute("name", temp.getName());
        model.addAttribute("surname", temp.getSurname());
        model.addAttribute("Dep", temp.getDep());
        model.addAttribute("age", temp.getAge());
        return "index";

    }


    @RequestMapping(value = "/ExcelView", method = RequestMethod.GET)
    public ModelAndView getExcel(){
        System.out.println("getExcel!");

        List<Link> links = new LinkedList<Link>();
        links.add(new Link("Android", "android.com"));
        links.add(new Link("Spring", "spring.io"));
        links.add(new Link("Firebase", "firebase.com"));

        return new ModelAndView("ExcelXlsxView", "model", links);
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

    @RequestMapping("/form")
    public ModelAndView form(ModelMap modelMap,@ModelAttribute(value = "studentmanager") StudentManager stu) {

        modelMap.addAttribute("studentmanager",stu);
        return new ModelAndView("form", modelMap, HttpStatus.OK);
    }

    @RequestMapping("/son")
    public Object son(@ModelAttribute("studentmanager") StudentManager stu
    ) {

        driver.save(stu);

        return ResponseEntity.ok(stu.getStud().getName()+ "  " + stu.getStud().getSurname() +  "   " +
                stu.getStud().getDep()  + "   " + stu.getStud().getAge());


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



}
