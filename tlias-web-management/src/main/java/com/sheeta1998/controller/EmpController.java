package com.sheeta1998.controller;


import com.sheeta1998.pojo.Emp;
import com.sheeta1998.pojo.EmpQueryParam;
import com.sheeta1998.pojo.PageResult;
import com.sheeta1998.pojo.Result;
import com.sheeta1998.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

//    @GetMapping
//    public Result page(@RequestParam(defaultValue = "1") Integer page ,
//                                   @RequestParam(defaultValue = "10") Integer pageSize,
//                                   String name, Integer gender,
//                                   @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate begin,
//                                   @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
//        log.info("查询员工信息, page={}, pageSize={}, name={}, gender={}, begin={}, end={}", page, pageSize, name, gender, begin, end);
//        PageResult pageResult = empService.page(page, pageSize,name, gender, begin, end);
//        return Result.success(pageResult);
//    }

    @GetMapping
    public Result page(EmpQueryParam empQueryParam){

        log.info("查询员工信息{}", empQueryParam);
        PageResult pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }

@PostMapping
    public Result add(@RequestBody Emp emp){
        log.info("新增员工{}", emp);
        empService.add(emp);
        return Result.success();
    }

    @DeleteMapping
        public Result delete(Integer[] ids){
        log.info("接收到id={}", Arrays.asList(ids));
        empService.delete(ids);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("请求员工数据");
        return Result.success(empService.getInfo(id));
    }

    @PutMapping
    public Result update(@RequestBody Emp emp){
        empService.update(emp);
        log.info("请求更改");
        return Result.success();
    }


    @GetMapping("/list")
    public Result findAll(){
        return Result.success( empService.findAll());
    }


}
