package com.xjf.demo.controller;

//import ch.qos.logback.core.model.Model;
import com.xjf.demo.service.xjfService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@RequestMapping("/xjff")
@Controller
public class xjfController {
    @Autowired
    private xjfService xjfService;//依赖调入服务端口
    @RequestMapping("/hello")
    @ResponseBody
    public String sayHelo(){
        return "Hello Spring!";
    }
    @RequestMapping("/data")
    @ResponseBody
    public String getData(){
        return  xjfService.find();
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        //获取请求数据
        System.out.println(httpServletRequest.getMethod());
        System.out.println(httpServletRequest.getServletPath());
        Enumeration<String> enumeration=httpServletRequest.getHeaderNames();
        while(enumeration.hasMoreElements()){
            String name=enumeration.nextElement();
            String value=httpServletRequest.getHeader(name);
            System.out.println(name+":"+value);
        }
        System.out.println(httpServletRequest.getParameter("code"));

        //返回响应数据
        httpServletResponse.setContentType("text/html;charaset=utf-8");
        PrintWriter writer= null;
        try {
            writer = httpServletResponse.getWriter();
            writer.write("<h1>xjf</h1>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            writer.close();
        }

    }

    @RequestMapping(path = "/my",method = RequestMethod.GET)
    @ResponseBody
    public String my(
            @RequestParam(name = "limit",required = false,defaultValue = "21") int limit,
            @RequestParam(name = "c",required = false,defaultValue = "212") int current)
    {
        System.out.println("limit="+limit+"\n"+"current="+current);
        return "my";
    }

    //通过路径变量进行传参
    @RequestMapping(path = "/mmy/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String myy(
            @PathVariable("id") int id){
        return "id"+id+"为的我";
    }

    //post请求进行提交数据接收参数
    @RequestMapping(path = "/student",method = RequestMethod.POST)
    @ResponseBody//响应为字符串这样注释
    public String String(String name, String age){//参数名字和表单一致就可以接收到
        return "name为"+name+"age为"+age+"Success!";
    }
    //传送HTML文件
    //第一种直接传ModelandView
    @RequestMapping(path = "/teacher",method = RequestMethod.GET)
    public ModelAndView getTeacher(){
        ModelAndView mav=new ModelAndView();
        mav.addObject("name","xjf");
        mav.addObject("age","21");
        mav.setViewName("/demo/view");
        return mav;
    }
    //第二种先把参数传给model然后返回模板路径
    @RequestMapping(path = "school",method = RequestMethod.GET)
    public String getSchool(Model model){
        model.addAttribute("name","xjf");
        model.addAttribute("age",31);
        return "demo/view";
    }
    //传送json字符串
    @RequestMapping(path = "/stu",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Integer>stu(){
        Map<String,Integer>stu=new HashMap<>();
        stu.put("张三",14);
        stu.put("王五",23);
        return stu;
    }
    @RequestMapping(path = "/stus",method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Integer>>stus(){
        List<Map<String,Integer>>stus=new ArrayList<>();
        Map<String,Integer>stu=new HashMap<>();
        stu.put("张三",14);
        stu.put("王五",23);
        stus.add(stu);
        stu=new HashMap<>();
        stu.put("张三",14);
        stu.put("王五",23);
        stus.add(stu);
        stu=new HashMap<>();
        stu.put("张三",14);
        stu.put("王五",23);
        stus.add(stu);
        stu=new HashMap<>();
        stu.put("张三",14);
        stu.put("王五",23);
        stus.add(stu);
        return stus;
    }

}
