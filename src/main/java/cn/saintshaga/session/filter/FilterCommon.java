package cn.saintshaga.session.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;

/**
 * Created by huang on 18-9-25.
 */
public class FilterCommon {

    /**
     * Filters that wrap the servlet request used by Application should be ordered less than or equal to this.
     */
    public static final int APP_REQUEST_WRAPPER_FILTER_MAX_ORDER = FilterRegistrationBean.REQUEST_WRAPPER_FILTER_MAX_ORDER - 100;
    /**
     * Filters that wrap the servlet request used by Application should be ordered more than or equal to this.
     */
    public static final int APP_REQUEST_WRAPPER_FILTER_MIN_ORDER = FilterRegistrationBean.REQUEST_WRAPPER_FILTER_MAX_ORDER - 10000;

}
