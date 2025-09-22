package com.sheeta1998.exception;

import com.sheeta1998.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    //处理异常
    @ExceptionHandler(Exception.class)
    public Result ex(Exception e){//方法形参中指定能够处理的异常类型
        e.printStackTrace();//打印堆栈中的异常信息
        //捕获到异常之后，响应一个标准的Result
        return Result.error("对不起,操作失败,请联系管理员");
    }
    @ExceptionHandler(HaveStudent.class)
    public Result hs(HaveStudent hs){
        hs.printStackTrace();
        return Result.error("该部门下仍有员工，无法删除");
    }
}