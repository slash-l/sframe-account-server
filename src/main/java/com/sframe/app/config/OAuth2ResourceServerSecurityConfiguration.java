package com.sframe.app.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import java.security.interfaces.RSAPublicKey;

/**
 * @ClassName WebSecurityConfig
 * @Description Resource Server jwt 认证的配置类
 * @Author mumu
 * @Date 2020/3/1 9:13 下午
 * @Version 1.0
 */
@Configuration
@Slf4j
@EnableWebSecurity // 启用 Spring Security
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class OAuth2ResourceServerSecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * 配置客户端请求的权限控制规则
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests(authorizeRequests ->
                        {
                            try {
                                authorizeRequests
                                        .and().requestMatchers().and().authorizeRequests().antMatchers("/console/**").permitAll() // 允许 h2console 通过security 认知
                                        .and().requestMatchers().and().authorizeRequests().antMatchers("/actuator/**", "/favicon.ico").permitAll()  // 允许 actuator 健康检查接口通过认证
                                        .and().requestMatchers().and().authorizeRequests().antMatchers("/swagger-ui.html", "/swagger-resources/**", "/webjars/**", "/*/api-docs").permitAll()      // 允许jenkins通知 通过认证
                                        .and().requestMatchers().and().authorizeRequests().antMatchers("/").permitAll()
//                                        .antMatchers(HttpMethod.GET, "/message/**").hasAuthority("SCOPE_message:read")        // 配置接口全校要求,作为案例保留
//                                        .antMatchers(HttpMethod.POST, "/message/**").hasAuthority("SCOPE_message:write")
                                        .anyRequest().authenticated();
                            } catch (Exception e) {
                                log.error(e.getMessage(), e);
                                throw new RuntimeException(e);
                            }
                        }
                )
                .oauth2ResourceServer()
                .jwt().decoder(jwtDecoder());
    }

    @Value("${spring.security.oauth2.resourceserver.jwt.public-key-location}")
    RSAPublicKey key;

    @Bean
    JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withPublicKey(this.key).build();
    }

    /**
     * 自定义密码加密的方式
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
