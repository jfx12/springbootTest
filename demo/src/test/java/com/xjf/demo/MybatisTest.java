package com.xjf.demo;

import com.xjf.demo.dao.DiscussPostMapper;
import com.xjf.demo.dao.UserMapper;
import com.xjf.demo.entity.DisscussPost;
import com.xjf.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = DemoApplication.class)
public class MybatisTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Test
    public void SelectTest(){
        User user=userMapper.selectById(101);
        System.out.println(user.toString());
    }
    @Test
    public void insertTest(){
        User user=new User();
        user.setUsername("xjf");
        user.setPassword("123456");
        user.setEmail("233434@qq.com");
        user.setSalt("32312");
        user.setCreateTime(new Date());
//        user.setActivationCode("13213312214124");
        user.setHeaderUrl("http://images.nowcoder.com/head/999.png");

        int rows=userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }
    @Test
    public void updateTest(){
        int rows=userMapper.updateStatus(150,1);//返回做修改的行
        System.out.println(rows);
        rows=userMapper.updateHeader(150,"http://images.nowcoder.com/head/998.png");
        System.out.println(rows);
    }

    @Test
    public void SelectDiscussPostTest(){
        List<DisscussPost> list=discussPostMapper.selectDiscussPosts(0,0,10);
        for(DisscussPost disscussPost:list)
            System.out.println(disscussPost);
        int rows=discussPostMapper.selectDiscussPostrows(0);
        System.out.println(rows);
    }
}
