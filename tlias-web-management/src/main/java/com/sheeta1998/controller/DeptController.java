package com.sheeta1998.controller;

import com.sheeta1998.exception.HaveStudent;
import com.sheeta1998.pojo.Dept;
import com.sheeta1998.pojo.Result;
import com.sheeta1998.service.DeptService;
import com.sheeta1998.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController  {
    @Autowired
    private DeptService deptService;

    @Autowired
    private EmpService empService;

    //@RequestMapping(value = "/depts", method = RequestMethod.GET)
    @GetMapping
    public Result list() {
     List<Dept>deptList= deptService.findAll();
     return Result.success(deptList);
    }


    //根据id查询部门
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable("id")Integer id) {
        if (id == null || id <= 0) {
            return Result.error("无效的部门ID");
        }
        Dept dept = deptService.findById(id);
        return Result.success(dept);
    }


    //根据id删除部门
    @DeleteMapping
    public Result delete(@RequestParam ("id")Integer id) {
        if (id == null || id <= 0) {
            return Result.error("无效的部门ID");
        }
        List hasEmployees = empService.hasEmployeesInDepartment(id);
        if (!hasEmployees.isEmpty()) {
            throw new HaveStudent("该部门下存在员工，无法删除");
        }
        deptService.delete(id);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Dept dept) {
        if (dept.getName() == null || dept.getName().trim().isEmpty()) {
            return Result.error("部门名称不能为空");
        }
        deptService.add(dept.getName());
        return Result.success();
    }

//更新
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        if (dept.getName() == null || dept.getName().trim().isEmpty()) {
            return Result.error("部门名称不能为空");
        }
        deptService.update(dept);
        return Result.success();
    }


}
