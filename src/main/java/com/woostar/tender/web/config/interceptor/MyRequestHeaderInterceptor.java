package com.woostar.tender.web.config.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class MyRequestHeaderInterceptor
 *
 * @author huangshuo
 * Created on 2017-11-14
 */
public final class MyRequestHeaderInterceptor implements HandlerInterceptor {

    /**
     * Constructor MyRequestHeaderInterceptor creates a new MyRequestHeaderInterceptor instance.
     */
    public MyRequestHeaderInterceptor() {
        super();
    }

    /**
     * Method preHandle
     *
     * @param httpServletRequest of type HttpServletRequest
     * @param httpServletResponse of type HttpServletResponse
     * @param o of type Object
     * @return boolean
     * @throws Exception when
     */
    @Override
    public boolean preHandle(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse,
                             final Object o) throws Exception {
        // *跨域访问
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "http://localhost:8081");
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PATCH, PUT, OPTIONS, HEAD, TRACE");
        return true;
    }

    /**
     * Method postHandle
     *
     * @param httpServletRequest of type HttpServletRequest
     * @param httpServletResponse of type HttpServletResponse
     * @param o of type Object
     * @param modelAndView of type ModelAndView
     * @throws Exception when
     */
    @Override
    public void postHandle(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse,
                           final Object o, final ModelAndView modelAndView) throws Exception {

    }

    /**
     * Method afterCompletion
     *
     * @param httpServletRequest of type HttpServletRequest
     * @param httpServletResponse of type HttpServletResponse
     * @param o of type Object
     * @param e of type Exception
     * @throws Exception when
     */
    @Override
    public void afterCompletion(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse,
                                final Object o, final Exception e) throws Exception {

    }
}
