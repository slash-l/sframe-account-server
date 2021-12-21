package com.sframe.app.config;

import lombok.val;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @ClassName JwtTokenFilter
 * @Description Jwt Filter
 * @Author mumu
 * @Date 2020/3/15 3:53 下午
 * @Version 1.0
 */
@Component
public class JwtTokenFilter extends GenericFilterBean {

    /**
     * 实现 SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
     * 实现接口 @PreAuthorize 权限认证
     *
     * @param request
     * @param response
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        val authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication instanceof JwtAuthenticationToken) {
            JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;
            Jwt jwt = (Jwt) jwtAuthenticationToken.getPrincipal();
            List<String> authoritiesList = (List<String>) (jwt.getClaims().get("authorities"));
            Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            for (String auth : authoritiesList) {
                authorities.add(new SimpleGrantedAuthority(auth));
            }

            UserDetails user = new User(jwt.getClaims().get("user_name").toString(), "", authorities);

            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken
                    (user, null, authorities);

            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }

        chain.doFilter(request, response);
    }
}
