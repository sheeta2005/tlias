package com.sheeta1998.service.impl;

import com.sheeta1998.mapper.EmpMapper;
import com.sheeta1998.mapper.LoginMapper;
import com.sheeta1998.pojo.Emp;
import com.sheeta1998.pojo.LoginInfo;
import com.sheeta1998.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private EmpMapper empMapper;

    @Override
    public LoginInfo log(Emp emp) {
        String name =emp.getUsername();
        String password=emp.getPassword();
        Emp realEmp= empMapper.findByNamePassword(name,password);
        if (realEmp!=null){
            return new LoginInfo(realEmp.getId(),realEmp.getUsername(),realEmp.getName(),"shit");
        }
        else {
            return null;
        }

    }
}
