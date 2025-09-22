package com.sheeta1998.controller;

import com.sheeta1998.pojo.Result;
import com.sheeta1998.util.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RequestMapping("/upload")
@RestController
public class UploadController {
    /*本地存储
//    @PostMapping
//    public String upload(String name, Integer age, MultipartFile file) throws IOException {
//        log.info("开始上传文件");
//        String  a=file.getOriginalFilename();
//        String ex=  a.substring(a.lastIndexOf('.'));
//        String newName= UUID.randomUUID().toString()+ex;
//        file.transferTo(new File("D:/images/" + file.getOriginalFilename()));
//        return "上传成功";
//    }
     */
    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;
    /**
     * 基于阿里云
     */
    @PostMapping
    public Result upload(MultipartFile file) throws Exception {
        log.info("文件上传：{}",file.getOriginalFilename());
       String url=  aliyunOSSOperator.upload(file.getBytes(),file.getOriginalFilename());
        log.info("文件上传oss：url:{}",url);
        return Result.success(url);
    }
}
