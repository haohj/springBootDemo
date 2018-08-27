package com.hao.service.impl;

import com.hao.dao.StudentDao;
import com.hao.entity.Student;
import com.hao.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    @Override
    public void add(Student student) {
        studentDao.save(student);
    }

    @Override
    public List<Student> query() {
        return studentDao.findAll();
    }
}
