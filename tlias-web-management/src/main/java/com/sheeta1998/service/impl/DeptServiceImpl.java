package com.sheeta1998.service.impl;

import com.sheeta1998.mapper.DeptMapper;
import com.sheeta1998.pojo.Dept;
import com.sheeta1998.pojo.Result;
import com.sheeta1998.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper mapper;
    @Override
    public List<Dept> findAll() {
        return mapper.findAll();
    }

    @Override
    public Dept findById(Integer id) {
        return mapper.findById(id);
    }

    @Override
    public void update(Dept dept) {
        mapper.update(dept);
        return;
    }


    @Override
    public void delete(Integer id) {
        mapper.delete(id);
    }

    @Override
    public void add(String name) {
        mapper.add(name);
    }




}
