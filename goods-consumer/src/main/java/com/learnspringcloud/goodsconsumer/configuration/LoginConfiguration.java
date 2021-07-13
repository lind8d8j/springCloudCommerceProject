package com.learnspringcloud.goodsconsumer.configuration;

import com.learnspringcloud.goodsconsumer.filter.SysIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class LoginConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new SysIntercepter())
                .addPathPatterns("/goods/**")
                .excludePathPatterns("/goods/getAll");
    }
}
