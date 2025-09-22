package com.sheeta1998.service;

import com.sheeta1998.pojo.Clazz;
import com.sheeta1998.pojo.ClazzQueryParam;
import com.sheeta1998.pojo.PageResult;

import java.util.List;

public interface ClazzService {
    PageResult page(ClazzQueryParam clazzQueryParam);

    void insert(Clazz clazz);

    Clazz findById(Integer id);

    void update(Clazz clazz);

    List<Clazz> findAll();

    void deleteById(Integer id);
}
