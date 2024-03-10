package com.xjf.demo.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository("xjf")
@Primary
public class xjfDaoImpl implements xjfDao{
    @Override
    public String select() {
        return "xjf";
    }
}
