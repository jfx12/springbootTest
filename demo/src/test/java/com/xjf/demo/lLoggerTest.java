package com.xjf.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
//在正常情况下测试类是需要@RunWith的，作用是告诉java你这个类通过用什么运行环境运行，
// 例如启动和创建spring的应用上下文。否则你需要为此在启动时写一堆的环境配置代码。
// 你在IDEA里去掉@RunWith仍然能跑是因为在IDEA里识别为一个JUNIT的运行环境，
// 相当于就是一个自识别的RUNWITH环境配置。但在其他IDE里并没有。

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = DemoApplication.class)
public class lLoggerTest {
    private static final Logger logger= LoggerFactory.getLogger(lLoggerTest.class);
    @Test
    public void testLogger(){
        System.out.println(logger.getName());
        logger.debug("debug log");
        logger.info("info log");
        logger.warn("warn log");
        logger.error("error log");

    }
}
