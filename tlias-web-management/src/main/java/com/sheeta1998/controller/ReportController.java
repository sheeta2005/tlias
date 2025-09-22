package com.sheeta1998.controller;


import com.sheeta1998.pojo.JobOption;
import com.sheeta1998.pojo.Result;
import com.sheeta1998.pojo.StudentParam;
import com.sheeta1998.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/report")
@RestController
@Slf4j
public class ReportController {
@Autowired
private ReportService reportService;

    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        log.info("统计各个职位的员工人数");
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }

    /**
     * 统计员工性别信息
     */
    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        log.info("统计员工性别信息");
        List<Map> genderList = reportService.getEmpGenderData();
        return Result.success(genderList);
    }

    @GetMapping("/studentCountData")
    public Result countStudentsEveryClazz(){
        StudentParam studentParam =  reportService.countStudentsEveryClazz();
        return Result.success(studentParam);
    }

    @GetMapping("/studentDegreeData")
    public Result getDegreeData(){
        List<Map<String ,Object> >map=reportService.getDegreeData();
        return Result.success(map);
    }
}
