package cn.saintshaga.session.filter;

import cn.saintshaga.session.gson.SessionDetail;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by huang on 18-9-21.
 */
public class SessionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(!(request instanceof  HttpServletRequest)) {
            chain.doFilter(request, response);
            return;
        }
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession(false);
        if(session == null) {

        }
        SessionDetail sessionDetail = (SessionDetail) session.getAttribute("sessionDetail");
        if(sessionDetail == null) {

        }
    }

    @Override
    public void destroy() {

    }
}
