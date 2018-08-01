package com.woostar.tender.web.config;

import com.woostar.tender.web.config.interceptor.MyRequestHeaderInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Class MyWebMvcConfig
 *
 * @author huangshuo
 * Created on 2017-11-14
 */
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {
    /**
     * Method addInterceptors
     *
     * @param registry of type InterceptorRegistry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyRequestHeaderInterceptor()).addPathPatterns("/**");
    }
}
