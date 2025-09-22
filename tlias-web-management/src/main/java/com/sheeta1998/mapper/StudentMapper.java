package com.sheeta1998.mapper;

import com.sheeta1998.pojo.JobOption;
import com.sheeta1998.pojo.Student;
import com.sheeta1998.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {


    Long count();

    List<Student> list(StudentQueryParam studentQueryParam);

    void insert(Student student);

    Student findById(Integer id);

    void update(Student student);

    void deleteBatch(Integer[] ids);

    @MapKey("jobList")
   List<Map<String, Object>>  countStudentsEveryClazz();

    @MapKey("name")
    List< Map<String, Object>> getDegreeData();
}
