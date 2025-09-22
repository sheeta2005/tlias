package com.sheeta1998.service.impl;

import com.github.pagehelper.PageHelper;
import com.sheeta1998.mapper.ClazzMapper;
import com.sheeta1998.mapper.EmpMapper;
import com.sheeta1998.pojo.Clazz;
import com.sheeta1998.pojo.ClazzQueryParam;
import com.sheeta1998.pojo.Emp;
import com.sheeta1998.pojo.PageResult;
import com.sheeta1998.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;
    @Autowired
    private EmpMapper empMapper;
    @Override
    public PageResult page(ClazzQueryParam clazzQueryParam) {
        PageHelper.startPage(clazzQueryParam.getPage(),clazzQueryParam.getPageSize());
       List<Clazz> list= clazzMapper.findAll(clazzQueryParam).stream().peek( clazz-> {
                   if (clazz.getBeginDate().isAfter(LocalDate.now()) ){
                       clazz.setStatus("未开班");
                   }
                   else if (clazz.getEndDate().isBefore(LocalDate.now()) ){
                       clazz.setStatus("已结课");
                   }
           if (clazz.getMasterId()!=null) {
               Emp emp = empMapper.getById(clazz.getMasterId());
               clazz.setMasterName(emp.getName());
           }
               }
       ).collect(Collectors.toList());
       Long total=list.stream().count();
       return new PageResult(total,list);
    }

    @Override
    public void insert(Clazz clazz) {
        clazzMapper.insert(clazz);
    }

    @Override
    public Clazz findById(Integer id) {
       Clazz clazz=clazzMapper.findById(id);
        if (clazz.getBeginDate().isAfter(LocalDate.now()) ){
            clazz.setStatus("未开班");
        }
        else if (clazz.getEndDate().isBefore(LocalDate.now()) ){
            clazz.setStatus("已结课");
        }
        if (clazz.getMasterId()!=null) {
            Emp emp = empMapper.getById(clazz.getMasterId());
            clazz.setMasterName(emp.getName());
        }
        return clazz;
    }

    @Override
    public void update(Clazz clazz) {
        clazzMapper.update(clazz);
    }

    @Override
    public List<Clazz> findAll() {
        List<Clazz> list= clazzMapper.findAllWithoutPage().stream().peek( clazz-> {
                    if (clazz.getBeginDate().isAfter(LocalDate.now()) ){
                        clazz.setStatus("未开班");
                    }
                    else if (clazz.getEndDate().isBefore(LocalDate.now()) ){
                        clazz.setStatus("已结课");
                    }
                    if (clazz.getMasterId()!=null) {
                        Emp emp = empMapper.getById(clazz.getMasterId());
                        clazz.setMasterName(emp.getName());
                    }
                }
        ).collect(Collectors.toList());
      return list ;
    }

    @Override
    public void deleteById(Integer id) {
        clazzMapper.deleteById(id);
    }
}
