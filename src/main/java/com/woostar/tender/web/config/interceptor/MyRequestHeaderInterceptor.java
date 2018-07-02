package com.woostar.tender.web.config.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The type My request header interceptor.
 *
 * @author huangs
 * @createtime 2017-11-14
 * @description http请求header拦截器
 */
public final class MyRequestHeaderInterceptor implements HandlerInterceptor {

    /**
     * Instantiates a new My request header interceptor.
     */
    public MyRequestHeaderInterceptor() {
        super();
    }

    @Override
    public boolean preHandle(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse,
                             final Object o) throws Exception {
        /*
        跨域访问
         */
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "http://localhost:8081");
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PATCH, PUT, OPTIONS, HEAD, TRACE");
        return true;
    }

    @Override
    public void postHandle(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse,
                           final Object o, final ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse,
                                final Object o, final Exception e) throws Exception {

    }
}
