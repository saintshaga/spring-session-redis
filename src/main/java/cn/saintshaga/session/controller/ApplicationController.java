package cn.saintshaga.session.controller;

import cn.saintshaga.session.conditional.dao.UserDao;
import cn.saintshaga.session.resolver.TenantId;
import cn.saintshaga.session.response.Response;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;


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

    @RequestMapping(value = {"/user"}, produces = {"application/json"})
    public Map<String, Object> user(OAuth2Authentication user) {
        Map<String, Object> userInfo = Maps.newHashMap();
        userInfo.put("user", user.getUserAuthentication().getPrincipal());
        userInfo.put("authorities", AuthorityUtils.authorityListToSet(user.getUserAuthentication().getAuthorities()));
        return userInfo;
    }


}
