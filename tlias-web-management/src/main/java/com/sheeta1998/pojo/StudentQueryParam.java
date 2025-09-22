package com.sheeta1998.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentQueryParam {
    private String name;
    private Integer degree;
    private  Integer clazzId;
    private Integer page;
    private  Integer pageSize;
}
