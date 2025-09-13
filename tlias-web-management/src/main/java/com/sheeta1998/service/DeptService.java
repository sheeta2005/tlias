package com.sheeta1998.service;


import com.sheeta1998.pojo.Dept;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DeptService {

    List<Dept> findAll();

    void delete(Integer id);

    void add(String name);

    Dept findById(Integer id);

    void update(Dept dept);
}
