package com.sheeta1998.mapper;

import com.sheeta1998.pojo.Emp;
import com.sheeta1998.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 员工经历
 */
@Mapper
public interface EmpExprMapper {


    void insertBatch(List<EmpExpr> empExprs);

    void deleteBatch(Integer[] ids);
}
