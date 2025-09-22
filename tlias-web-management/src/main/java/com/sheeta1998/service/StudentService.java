package com.sheeta1998.service;

import com.sheeta1998.pojo.PageResult;
import com.sheeta1998.pojo.Student;
import com.sheeta1998.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {
    PageResult query(StudentQueryParam studentQueryParam);

    void add(Student student);

    Student findById(Integer id);

    void update(Student student);

    void deleteBatch(Integer[] ids);

    void score(Integer id, Integer score);
}
