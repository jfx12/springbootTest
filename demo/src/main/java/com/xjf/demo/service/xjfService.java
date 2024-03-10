package com.xjf.demo.service;


import com.xjf.demo.dao.xjfDao;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class xjfService {

    @Autowired
    private xjfDao xjfDao;//调用数据查询接口
    public xjfService(){
        System.out.println("构造xjfService");
    }
    @PostConstruct
    public void init(){
        System.out.println("初始化xjfService");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("销毁xjfservice");
    }
    public String find(){
        return xjfDao.select();
    }
}
