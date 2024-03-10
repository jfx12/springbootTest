package com.xjf.demo.controller;

import com.xjf.demo.entity.DisscussPost;
import com.xjf.demo.entity.Page;
import com.xjf.demo.entity.User;
import com.xjf.demo.service.DiscussPostService;
import com.xjf.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    DiscussPostService discussPostService;
    @Autowired
    UserService userService;

    @RequestMapping(path = "/index",method = RequestMethod.GET)
    public String GetIndexPage(Model model, Page page){
        //方法调用前，SpringMVC会自动实例化model和page，并将page注入model
        //所以，在thymeleaf中可以直接访问page对象中的数据
        page.setRows(discussPostService.findDiscussRows(0));
        page.setPath("/index");
        List<DisscussPost>postList=discussPostService.postList(0,page.getOffset(),page.getLimit());
        List<Map<String,Object>> mappostList=new ArrayList<>();
        if(postList!=null){
           for(DisscussPost disscussPost:postList){
               Map<String,Object>map=new HashMap<>();
               map.put("post",disscussPost);
               User user=userService.selectUserById(disscussPost.getUserId());
               map.put("user",user);
               mappostList.add(map);
           }
        }
        model.addAttribute("mappostList",mappostList);
        model.addAttribute("page",page);
        return "/index";
    }
}
