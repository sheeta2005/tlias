package com.sheeta1998.controller;


import com.sheeta1998.pojo.Clazz;
import com.sheeta1998.pojo.ClazzQueryParam;
import com.sheeta1998.pojo.PageResult;
import com.sheeta1998.pojo.Result;
import com.sheeta1998.service.ClazzService;
import com.sheeta1998.service.impl.ClazzServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/clazzs")
public class ClazzController {
    @Autowired
private ClazzService clazzService;
    @GetMapping
    public Result query( ClazzQueryParam clazzQueryParam){
        PageResult pageResult= clazzService.page(clazzQueryParam);
        return Result.success(pageResult);
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        log.info("根据id查询教室");
        return Result.success(clazzService.findById(id));
    }

    @PostMapping
    public Result add(@RequestBody Clazz clazz){
            clazzService.insert(clazz);
            log.info("新增班级");
            return Result.success();
    }


    @PutMapping
    public Result update(@RequestBody Clazz clazz){
        clazzService.update(clazz);
        return Result.success();
    }


    @GetMapping("/list")
    public Result getAll(){

        return Result.success(clazzService.findAll());
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        clazzService.deleteById(id);
        log.info("删除班级");
        return Result.success();
    }

}
