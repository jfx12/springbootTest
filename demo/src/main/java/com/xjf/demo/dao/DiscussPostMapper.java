package com.xjf.demo.dao;

import com.xjf.demo.entity.DisscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    List<DisscussPost> selectDiscussPosts(int userId,int offset,int limit);
//    @Param用于对参数取别名
//    如果只有一个参数并且在<if>里使用，则必须加别名
    int selectDiscussPostrows(@Param("userId") int userId);//用于抓取我的帖子
}
