package com.sheeta1998.service;

import com.sheeta1998.pojo.JobOption;
import com.sheeta1998.pojo.StudentParam;

import java.util.List;
import java.util.Map;

public interface ReportService {
    JobOption getEmpJobData();

    List<Map> getEmpGenderData();

    StudentParam countStudentsEveryClazz();

    List<Map<String, Object>>getDegreeData();
}
