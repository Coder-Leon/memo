package com.flywithxinxin.memo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ConditionalOnWebApplication
// @ConditionalOnWebApplication
// 判断是否为web项目，按条件选择加载bean
// 条件化自动装配
public class WebSecurityConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        InterceptorRegistration loginRegistry = registry.addInterceptor(loginInterceptor);
        loginRegistry.addPathPatterns("/**");

        loginRegistry.excludePathPatterns("/user/login");
        loginRegistry.excludePathPatterns("/user/add");
        loginRegistry.excludePathPatterns("/avail");
    }

}
