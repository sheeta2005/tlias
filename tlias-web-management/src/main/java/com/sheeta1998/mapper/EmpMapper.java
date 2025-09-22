package com.sheeta1998.mapper;

import com.sheeta1998.pojo.Emp;
import com.sheeta1998.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {

//    /**
//     * 原始分页查询
//     * @return
//     */
//    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id ")
//    Long count();
//
//    @Select("select e.*, d.name deptName from emp as e left join dept as d on e.dept_id = d.id limit #{start}, #{pageSize}")
//    List<Emp> list(Integer start, Integer pageSize);

    /**
     * 基于插件pagehelper的分页查询
     */
       //@Select("select e.*, d.name deptName from emp as e left join dept as d on e.dept_id = d.id order by e.update_time desc ")
    List<Emp> list(EmpQueryParam empQueryParam);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) values (#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},NOW(),#{deptId},NOW(),NOW())")
    void insert(Emp emp);

    void deleteBatch(Integer[] ids);

    Emp getById(Integer id);


    void update(Emp emp);


    @MapKey("pos")
    List<Map<String, Object>> countEmpJobData();

    @MapKey("g")
    List<Map> countEmpGenderData();

    List<Emp> findAll();

    List<Emp> findByDeptId(Integer id);

    Emp findByNamePassword(String name, String password);
}
