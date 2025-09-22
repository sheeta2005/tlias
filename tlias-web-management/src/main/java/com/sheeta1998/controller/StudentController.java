package com.sheeta1998.controller;

import com.sheeta1998.pojo.Result;
import com.sheeta1998.pojo.Student;
import com.sheeta1998.pojo.StudentQueryParam;
import com.sheeta1998.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
   @Autowired
    StudentService studentService;
    @GetMapping
    public Result query( StudentQueryParam studentQueryParam){
        return Result.success(studentService.query(studentQueryParam));
    }

    @PostMapping
    public Result add(@RequestBody Student student){
        studentService.add(student);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        return Result.success(studentService.findById(id));
    }


    @PutMapping
    public Result update(@RequestBody Student student){
        studentService.update(student);
        return Result.success();
    }

    @PutMapping("/violation/{id}/{score}")
    public Result scoreCalc(@PathVariable Integer id,
                                            @PathVariable Integer score) {
            studentService.score(id,score);

        return Result.success();
    }

@DeleteMapping("/{ids}")
    public Result deleteBatch(@PathVariable Integer[] ids){
        studentService.deleteBatch(ids);
        return Result.success();

}


}
