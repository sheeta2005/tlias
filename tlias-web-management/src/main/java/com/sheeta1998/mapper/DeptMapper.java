package com.sheeta1998.mapper;

import com.sheeta1998.pojo.Dept;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Mapper
public interface DeptMapper {

    @Results({
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    @Select("select * from dept order by update_time desc;")
    List<Dept> findAll();

    @Results({
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    @Select("select * from dept where id = #{id}")
    Dept findById(Integer id);

    @Delete("delete from dept where id =#{id}")
    void delete(Integer id);

//增加添加的方法
    @Insert("insert into dept (name, create_time, update_time) values (#{name}, NOW(), NOW())")
    void add(String name);

    @Update("update dept set name = #{name},update_time=NOW()where id=#{id}")
    void update(Dept dept);


}
