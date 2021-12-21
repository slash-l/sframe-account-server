package com.sframe.app.common.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

/**
 * @ClassName SpringSecurityAuditorAware
 * @Description 获取当前登录用户相关信息类
 * @Author mumu
 * @Date 2020/3/14 7:16 下午
 * @Version 1.0
 */
@Slf4j
public class SpringSecurityAuditorAware {

    private static final String ANONYMOUS_USER = "anonymousUser";

    /**
     * 从当前登录人的 jwt 中获取相应信息
     *
     * @return
     */
    public static Optional<UserDetails> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            if (ANONYMOUS_USER.equals(authentication.getPrincipal())) {
                return Optional.empty();
            }
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return Optional.of(userDetails);
        }
        return Optional.empty();
    }
}
