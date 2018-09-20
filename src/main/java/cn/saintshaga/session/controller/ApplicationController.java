package cn.saintshaga.session.controller;

import cn.saintshaga.session.conditional.dao.UserDao;
import cn.saintshaga.session.resolver.TenantId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
@Slf4j
public class ApplicationController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/home")
    public String home(HttpSession session, TenantId tenantId) {
        System.out.println(userDao.getAllUserIds());
        return "Hello, World! Timeout session: "+session.getMaxInactiveInterval() + tenantId.getTenantId();
    }

    @RequestMapping("/session")
    public String session(@RequestParam("user") String user, HttpSession session) {
        if(session.getAttribute("user")  == null){
            session.setAttribute("user",user);
            return "沒有login! login user :" + user;
        }

        return "已經login, user :"+session.getAttribute("user").toString();
    }


    @RequestMapping("/health/v1/requestStatus")
    public String testHealthPage(){
        return "This is health page. This page do not require auth!";
    }


}
