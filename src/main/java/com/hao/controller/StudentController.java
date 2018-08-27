package com.hao.controller;

import com.hao.entity.Student;
import com.hao.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("studentList", studentService.query());
        mv.setViewName("studentList.ftl");
        return mv;
    }

    @RequestMapping("/add")
    public String add(Student student) {
        studentService.add(student);
        return null;
    }
}
