package com.hao.controller;

import com.hao.entity.Student;
import com.hao.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;

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

    /**
     * 添加学生信息
     *
     * @param student
     * @param bindingResult
     * @return
     */
    @RequestMapping("/add")
    public String add(@Valid Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return bindingResult.getFieldError().getDefaultMessage();
        } else {
            studentService.add(student);
            return null;
        }
    }
}
