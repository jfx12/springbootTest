package com.xjf.demo.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository("xjfnew")//更好的方法定一个bean的id就是spring最底层的bean的注入是根据名字和类型同时确定的
//@Primary可以直接获得最高优先使用权，但是不方便因为若想使用旧版本就无法使用了
public class xjfDaonewImpl implements xjfDao{
    @Override
    public String select() {
        return "xjfnewversion";
    }
}
