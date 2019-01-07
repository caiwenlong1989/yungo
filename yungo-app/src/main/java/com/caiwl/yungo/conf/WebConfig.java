package com.caiwl.yungo.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Bean
    public SmsCodeInterceptor getSmsCodeInterceptor() {
        return new SmsCodeInterceptor();
    }

    @Bean
    public CustomerIdInterceptor getCustomerIdInterceptor() {
        return new CustomerIdInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getSmsCodeInterceptor())
                .addPathPatterns("/app/v1/pub/smsCode/*");
        registry.addInterceptor(getCustomerIdInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/app/v1/pub/smsCode/*");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new CustomerIdMethodArgumentResolver());
    }
}
