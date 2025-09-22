package com.sheeta1998.service;

import com.sheeta1998.pojo.Emp;
import com.sheeta1998.pojo.EmpQueryParam;
import com.sheeta1998.pojo.PageResult;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface EmpService {
    PageResult page(EmpQueryParam empQueryParam);

    void add(Emp emp);

    void delete(Integer[] ids);

    Emp getInfo(Integer id);

    void update(Emp emp);

    List<Emp> findAll();

    List<Emp> hasEmployeesInDepartment(Integer id);
}
