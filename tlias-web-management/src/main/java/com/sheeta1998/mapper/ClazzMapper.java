package com.sheeta1998.mapper;

import com.sheeta1998.pojo.Clazz;
import com.sheeta1998.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClazzMapper {

    Clazz findById(Integer id) ;

    List<Clazz> findAll(ClazzQueryParam clazzQueryParam);

    void insert(Clazz clazz);

    void update(Clazz clazz);

    List<Clazz> findAllWithoutPage();

    void deleteById(Integer id);
}
