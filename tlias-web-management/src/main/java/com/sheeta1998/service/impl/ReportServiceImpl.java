package com.sheeta1998.service.impl;

import com.sheeta1998.mapper.EmpMapper;
import com.sheeta1998.mapper.StudentMapper;
import com.sheeta1998.pojo.JobOption;
import com.sheeta1998.pojo.StudentParam;
import com.sheeta1998.service.ReportService;
import com.sheeta1998.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    EmpMapper empMapper;
    @Autowired
    StudentMapper studentMapper;

    @Override
    public JobOption getEmpJobData() {
        List<Map<String,Object>> list = empMapper.countEmpJobData();
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("total")).toList();
        return new JobOption(jobList, dataList);
    }

    @Override
    public List<Map> getEmpGenderData() {


        return empMapper.countEmpGenderData();
    }

    @Override
    public StudentParam countStudentsEveryClazz() {
        List<Map<String,Object>> list =studentMapper.countStudentsEveryClazz();
        List<Object> clazzNameList =  list.stream().map(dataMap -> dataMap.get("job_list")).toList();
        List<Object> dataList =list.stream().map(d->d.get("data_list")).toList();
        return new  StudentParam(clazzNameList,dataList);
    }

    @Override
    public     List<Map<String, Object>> getDegreeData() {

      return   studentMapper.getDegreeData();
    }


}
