package com.xjf.demo.service;

import com.xjf.demo.dao.DiscussPostMapper;
import com.xjf.demo.entity.DisscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {
    @Autowired
    DiscussPostMapper discussPostMapper;
    public List<DisscussPost>postList(int userId,int offset,int limit){
        return discussPostMapper.selectDiscussPosts(userId,offset,limit);
    }
    public int findDiscussRows(int userId){
        return discussPostMapper.selectDiscussPostrows(userId);
    }
}
