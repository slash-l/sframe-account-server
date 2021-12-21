package com.sframe.app.demo.controller;

import com.sframe.app.common.util.SpringSecurityAuditorAware;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

/**
 * @ClassName HelloController
 * @Description Demo
 * @Author mumu
 * @Date 2020/3/1 9:13 下午
 * @Version 1.0
 */
@Slf4j
@Api(tags = "Demo 接口", description = "一个 Spring Boot Demo 的 Rest API")
@RestController
@RequestMapping("/hello")
public class HelloController {

    @ApiOperation("hello Get 接口，无权限限制")
    @GetMapping
    public String hello() {
        return "hello, Account Server";
    }

    @ApiOperation("helloAdmin Get 接口，只有拥有 admin 权限的才可访问")
    @GetMapping("/helloAdmin")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String helloAdmin() {
        return "hello,admin";
    }

    @ApiOperation("helloUser Get 接口，只有拥有 normal 权限的才可访问")
    @GetMapping("/helloUser")
    @PreAuthorize("hasAnyRole('NORMAL', 'ADMIN')")
    public String helloUser() {
        return "hello,user";
    }

    @ApiOperation("获取登录用户的 jwt 信息")
    @GetMapping("/jwt")
    public String getJWT() {
        val authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<GrantedAuthority> authorities = (List<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            log.info("Authority" + grantedAuthority.getAuthority());
        }

        UserDetails userDetails = SpringSecurityAuditorAware.getCurrentUser().orElse(null);

        String user = String.format("Hello, %s!", userDetails);
        return user;
    }

}
