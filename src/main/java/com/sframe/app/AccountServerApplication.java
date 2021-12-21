package com.sframe.app;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName AccountServerApplication
 * @Description AccountServer 启动类
 * @Author mumu
 * @Date 2020/3/4 9:03 下午
 * @Version 1.0
 */
@SpringBootApplication
@NacosPropertySource(dataId = "example", autoRefreshed = true)
public class AccountServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServerApplication.class, args);
    }
}
