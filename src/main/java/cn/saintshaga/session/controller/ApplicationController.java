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

}
