package com.sframe.app.clientapp.DTO;

import com.sframe.app.base.DTO.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassName OauthClientDetailsDTO
 * @Description OauthClientDetails DTO
 * @Author mumu
 * @Date 2020/3/16 10:28 下午
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OauthClientDetailsDTO extends BaseDTO {

    /**
     * 注册 app 的 client id
     */
    private String clientId;

    /**
     * oauth 认证的 scope
     */
    private String scope;

    /**
     * oauth 认证的 authorized_grant_types
     */
    private String authorizedGrantTypes;

    /**
     * oauth 认证的 web_server_redirect_uri
     */
    private String webServerRedirectUri;

    /**
     * token 有效期 access_token_validity
     */
    private String accessTokenValidity;

    /**
     * refresh token 有效期 refresh_token_validity
     */
    private String refreshTokenValidity;

    /**
     * 额外信息
     */
    private String additionalInformation;

}
