package com.sframe.app.config;

import com.sframe.app.permission.DO.UserInfo;
import com.sframe.app.permission.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CustomUserDetailService
 * @Description 重写 UserDetailsService loadUserByUsername 方法
 * @Author mumu
 * @Date 2020/3/2 11:28 下午
 * @Version 1.0
 */
@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 通过自定义的用户表来获取用户，Spring Security 拦截器会执行此方法
     *
     * @param userName
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoService.findByUserName(userName);
        if (userInfo == null) {
            throw new UsernameNotFoundException("not found");
        }

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + userInfo.getRole().name()));
        User userDetails = new User(userInfo.getUserName(), userInfo.getPassword(), authorities);

        return userDetails;
    }
}
