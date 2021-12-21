package com.sframe.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ClassName ProductAdapter
 * @Description TODO
 * @Author mumu
 * @Date 2020/3/26 6:28 下午
 * @Version 1.0
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class AccountServerAdapter extends WebMvcConfigurerAdapter {

    @Autowired
    private RequestLogInterceptor requestLogInterceptor;

    @Autowired
    private I18Config i18Config;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestLogInterceptor).addPathPatterns("/**");
        registry.addInterceptor(i18Config.localeChangeInterceptor());
    }

}
