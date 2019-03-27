package com.sl.ly.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**").addResourceLocations("file:D:\\lyImg\\");
    }

    public void addInterceptors(InterceptorRegistry registry){
        //registry.addInterceptor(new AuthenticationInterceptor()).addPathPatterns("/**/*").excludePathPatterns("/**/swagger-resources/**","/**/v2/**");
    }
}
