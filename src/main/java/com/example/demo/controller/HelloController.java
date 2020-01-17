package com.example.demo.controller;

import com.study.starter.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author: xianlehuang
 * @Description:
 * @date: ${date} ${time}
 */
@Controller
public class HelloController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    HelloService helloService;

    @Cacheable
    @ResponseBody
    @RequestMapping("/hello")
    public List<Map<String, Object>> hello(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from tl_p_jyglb");
        return list;
    }

    @ResponseBody
    @RequestMapping("/sayhello")
    public String sayhello(){
        return helloService.sayHello("huangxianle");
    }

}
