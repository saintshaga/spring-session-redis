package cn.saintshaga.session;

import cn.saintshaga.session.resolver.CollaboTenantMethodArgumentResolver;
import cn.saintshaga.session.response.ResponseMethodReturnValueHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * Created by huang on 18-9-20.
 */
@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
public class Application implements WebMvcConfigurer{

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new CollaboTenantMethodArgumentResolver());
    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
        returnValueHandlers.add(new ResponseMethodReturnValueHandler());
    }

}
