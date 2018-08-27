package com.hao.service;

import com.hao.entity.Student;

import java.util.List;

/**
 * 学生信息Service接口
 *
 * @author Administrator
 */
public interface StudentService {
    /**
     * 添加学生信息
     *
     * @param student
     */
    public void add(Student student);

    /**
     * 查询全部学生
     * */
    public List<Student> query();
}
