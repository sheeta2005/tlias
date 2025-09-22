package com.sheeta1998.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentParam {
    List<Object> clazzList;
    List<Object>dataList;
}
