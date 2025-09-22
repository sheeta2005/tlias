package com.sheeta1998.controller;


import com.sheeta1998.pojo.Emp;
import com.sheeta1998.pojo.LoginInfo;
import com.sheeta1998.pojo.LoginInfo;
import com.sheeta1998.pojo.Result;
import com.sheeta1998.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/login")
@RestController
public class LoginContorller {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public Result login(@RequestBody Emp emp){
        LoginInfo logInfo= loginService.log(emp);
        if (logInfo!=null){
            return Result.success(logInfo);
        }
        else{
            return Result.error("登陆失败");
        }

    }

}
