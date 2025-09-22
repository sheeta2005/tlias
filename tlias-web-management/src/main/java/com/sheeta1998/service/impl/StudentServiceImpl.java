package com.sheeta1998.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sheeta1998.mapper.ClazzMapper;
import com.sheeta1998.mapper.StudentMapper;
import com.sheeta1998.pojo.Clazz;
import com.sheeta1998.pojo.PageResult;
import com.sheeta1998.pojo.Student;
import com.sheeta1998.pojo.StudentQueryParam;
import com.sheeta1998.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;
    @Autowired
    ClazzMapper clazzMapper;
    @Override
    public PageResult query(StudentQueryParam studentQueryParam) {

        PageHelper.startPage(studentQueryParam.getPage(),studentQueryParam.getPageSize());
        List<Student> list=studentMapper.list(studentQueryParam);
        Page<Student> p=(Page<Student>)list;

        return new PageResult(p.getTotal(),
                p.getResult().stream().peek(a->{
                    Clazz clazz = clazzMapper.findById(a.getClazzId());
                    a.setClazzName(clazz.getName());
                }
        ).collect(Collectors.toList()));
    }

    @Override
    public void add(Student student) {
        studentMapper.insert(student);
    }

    @Override
    public Student findById(Integer id) {
        return studentMapper.findById(id);
    }

    @Override
    public void update(Student student) {
        studentMapper.update(student);
    }

    @Override
    public void deleteBatch(Integer[] ids) {

        studentMapper.deleteBatch(ids);
    }

    @Override
    public void score(Integer id, Integer score) {
        Student student = studentMapper.findById(id);
        Integer i = student.getViolationCount().intValue();
        i++;
        student.setViolationCount(Short.valueOf(i.toString()));
         Short Result=(short)(student.getViolationScore()+score);
         student.setViolationScore(Result);
         studentMapper.update(student);
    }
}
