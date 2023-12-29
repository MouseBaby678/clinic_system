package com.qlu.config;

import com.qlu.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        //配置登录的拦截器，让其拦截所有的一/admin开始的路径
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/manager/**");
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/doctor/**");
    }
}
