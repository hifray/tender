package com.woostar.tender.web.config;

import com.woostar.tender.web.config.interceptor.MyRequestHeaderInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * The type My web mvc configurer.
 *
 * @author huangs
 * @createtime 2017-11-14
 * @description
 */
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyRequestHeaderInterceptor()).addPathPatterns("/**");
    }
}
