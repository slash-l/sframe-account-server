package com.sframe.app.common.DTO;

import lombok.Data;

import java.util.List;

/**
 * @ClassName JWTClaimsDTO
 * @Description 当前登录人 JWT DTO 数据
 * @Author mumu
 * @Date 2020/3/14 7:32 下午
 * @Version 1.0
 */
@Data
public class JWTClaimsDTO {

    /**
     * 用户 ID
     */
    private String userId;

    /**
     * 用户登录名
     */
    private String loginName;

    /**
     * 用户权限集合
     */
    private List<String> authorities;
}
