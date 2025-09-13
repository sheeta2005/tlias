package com.sheeta1998.controller.impl;

import com.sheeta1998.controller.DeptController;
import com.sheeta1998.pojo.Dept;
import com.sheeta1998.pojo.Result;
import com.sheeta1998.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptControllerImpl implements DeptController {
    @Autowired
    private DeptService deptService;

    @Override
    @RequestMapping("/depts")
    public Result list() {
     List<Dept>list= deptService.findAll();
    

    }



}
