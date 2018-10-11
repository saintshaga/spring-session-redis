package cn.saintshaga.session.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by huang on 18-9-25.
 */
@Slf4j
//@Component
//@Order(FilterCommon.APP_REQUEST_WRAPPER_FILTER_MAX_ORDER)
public class LowPriorityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("This is filter {}", filterConfig.getFilterName());
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("I am low priority filter.");
        if(request instanceof HttpServletRequest) {
            log.info(((HttpServletRequest) request).getRequestURL().toString());
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("Destroying low priority filter!");
    }
}
