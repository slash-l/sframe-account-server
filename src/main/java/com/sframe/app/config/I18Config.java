package com.sframe.app.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

/**
 * @ClassName I18Config
 * @Description 国际化配置文件
 * @Author mumu
 * @Date 2020/3/22 9:25 下午
 * @Version 1.0
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class I18Config extends WebMvcConfigurerAdapter {

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        // 默认语言
        slr.setDefaultLocale(Locale.CHINA);
        return slr;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        // 前端接受的国际化语言参数名
        // ...?lang=zh_CN   中文
        // ...?lang=en_US   英文
        lci.setParamName("lang");
        return lci;
    }

}
