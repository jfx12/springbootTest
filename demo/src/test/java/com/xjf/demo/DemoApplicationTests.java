package com.xjf.demo;

import com.xjf.demo.dao.xjfDao;
import com.xjf.demo.dao.xjfDaoImpl;
import com.xjf.demo.service.xjfService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@ContextConfiguration(classes = DemoApplication.class)
class DemoApplicationTests implements ApplicationContextAware {

	@Test
	void contextLoads() {
	}
	private ApplicationContext applicationContext;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}
	@Test
	public void applicationcontext(){
		System.out.println(this.applicationContext);
		xjfDao xjfDao=applicationContext.getBean("xjf",xjfDao.class);
		System.out.println(xjfDao.select());
		xjfDao xjfDao1=applicationContext.getBean("xjfnew",xjfDao.class);
		System.out.println(xjfDao1.select());

	}

	@Test
	public void applicationService(){
		xjfService xjfService=applicationContext.getBean(com.xjf.demo.service.xjfService.class);
		System.out.println(xjfService);
	}

	@Test
	public void applicationDataForm(){
		SimpleDateFormat simpleDateFormat=applicationContext.getBean(SimpleDateFormat.class);
		System.out.println(simpleDateFormat.format(new Date()));
	}

	@Autowired
	private xjfDao xjfDao;
	@Autowired
	@Qualifier("xjfnew")
	private xjfDao xjfDao1;
	@Autowired
	private xjfService service;
	@Autowired
	private SimpleDateFormat simpleDateFormat;
	@Test
	public void Di(){
		System.out.println(xjfDao);
		System.out.println(xjfDao1);
		System.out.println(service);
		System.out.println(simpleDateFormat);
	}
}
