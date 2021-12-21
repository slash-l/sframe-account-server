package com.sframe.app.clientapp.VO;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @ClassName OauthClientDetailsVO
 * @Description OauthClientDetails VO
 * @Author mumu
 * @Date 2020/3/16 9:44 下午
 * @Version 1.0
 */
@Data
public class OauthClientDetailsVO {

    /**
     * 注册 app 的 client id
     */
    @NotBlank
    private String clientId;

    /**
     * client 密码
     */
    @NotBlank
    private String clientSecret;

    /**
     * oauth 认证的 scope
     */
    @NotBlank
    private String scope;

    /**
     * oauth 认证的 authorized_grant_types
     */
    @NotBlank
    private String authorizedGrantTypes;

    /**
     * oauth 认证的 web_server_redirect_uri
     */
    private String webServerRedirectUri;

    /**
     * token 有效期 access_token_validity
     */
    @Min(value = 0)
    private Integer accessTokenValidity;

    /**
     * refresh token 有效期 refresh_token_validity
     */
    @Min(value = 0)
    private Integer refreshTokenValidity;

    /**
     * 额外信息
     */
    private String additionalInformation;

}
