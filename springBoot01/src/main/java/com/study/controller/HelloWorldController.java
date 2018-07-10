package com.study.controller;

import com.study.dao.UserRepository;
import com.study.domain.NeoProperties;
import com.study.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

/**
 * Created by liuxin on 2018/5/13.
 */
@Controller
public class HelloWorldController {
    @Autowired
    private NeoProperties neoProperties;
    @Autowired
    private UserRepository userRepository;
    @RequestMapping(value = "/hello1",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Object index() {
        return neoProperties;
    }
    @RequestMapping("hi")
    public String getHelloPage(Locale locale, Model model){
        model.addAttribute("greeting", "Hello!");
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("currentTime", formattedDate);
        return "hello";
    }
    /**
     *
     * @Description: 
     * @class: HelloWorldController
     * @auther: liuxin
     * @date: 16:15 2018/7/9 
     * @param: []
     * @return: com.study.domain.User
     *
     */
    @RequestMapping("getUser")
    @ResponseBody
    @Cacheable("user-key1")
    public User redis(){
        User user = userRepository.findByUserName("bb2");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }
    @RequestMapping("getUUID")
    @ResponseBody
    public String getUUid(HttpSession session){
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }
}
