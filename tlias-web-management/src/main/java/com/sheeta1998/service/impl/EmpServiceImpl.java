package com.sheeta1998.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sheeta1998.mapper.EmpExprMapper;
import com.sheeta1998.mapper.EmpMapper;
import com.sheeta1998.pojo.Emp;
import com.sheeta1998.pojo.EmpExpr;
import com.sheeta1998.pojo.EmpQueryParam;
import com.sheeta1998.pojo.PageResult;
import com.sheeta1998.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;
    @Override
    public PageResult page(EmpQueryParam empQueryParam) {
        //7原始分页查询
//        //1. 获取总记录数
//        Long total = empMapper.count();
//
//        //2. 获取结果列表
//        Integer start = (page - 1) * pageSize;
//        List<Emp> empList = empMapper.list(start, pageSize);
//
//        //3. 封装结果
//        return new PageResult(total, empList);
        //基于pagehelper实现
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
        List<Emp> empList = empMapper.list(empQueryParam);
        Page<Emp> p= (Page<Emp>) empList;
        return new PageResult(p.getTotal(),p.getResult());
    }

    @Transactional(rollbackFor = Exception.class)      //默认runtimeexception回滚
    @Override
    public void add(Emp emp) {
        //插入员工基本信息
        empMapper.insert(emp);

        //插入员工经历信息

       List<EmpExpr> empExprs =  emp.getExprList();
       if (!CollectionUtils.isEmpty(empExprs)){
           empExprs.forEach(empExpr -> empExpr.setEmpId(emp.getId()));
           empExprMapper.insertBatch(emp.getExprList());
       }

    }

    @Override
    public void delete(Integer[] ids) {
        empMapper.deleteBatch(ids);
        empExprMapper.deleteBatch(ids);
    }

    @Override
    public Emp getInfo(Integer id) {
        return empMapper.getById(id);
    }

    @Override
    public void update(Emp emp) {

        //更新数据
        empMapper.update(emp);
        //删除旧经历
        empExprMapper.deleteBatch(new Integer[]{emp.getId()});
        //增加新经历
        empExprMapper.insertBatch(emp.getExprList());
    }

    @Override
    public List<Emp> findAll() {
  List<Emp> emps= empMapper.findAll();
        return emps;
    }

    @Override
    public List<Emp> hasEmployeesInDepartment(Integer id) {
        List<Emp> list =   empMapper.findByDeptId(id);
        return list;
    }


}
