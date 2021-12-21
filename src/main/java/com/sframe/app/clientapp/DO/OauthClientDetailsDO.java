package com.sframe.app.clientapp.DO;

import com.sframe.app.base.DO.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * @ClassName OauthClientDetails
 * @Description Oauth Client DO
 * @Author mumu
 * @Date 2020/3/14 11:18 上午
 * @Version 1.0
 */
@Entity
@Table(name = "oauth_client_details")
@Data
@EqualsAndHashCode(callSuper = false)
public class OauthClientDetailsDO extends BaseDO {

    /**
     * 注册 app 的 client id
     */
    @Column(name = "client_id")
    private String clientId;

    /**
     * resource_ids
     */
    @Column(name = "resource_ids")
    private String resourceIds;

    /**
     * 注册 app 的 client_secret
     */
    @Column(name = "client_secret")
    private String clientSecret;

    /**
     * oauth 认证的 scope
     */
    @Column(name = "scope")
    private String scope;

    /**
     * oauth 认证的 authorized_grant_types
     */
    @Column(name = "authorized_grant_types")
    private String authorizedGrantTypes;

    /**
     * oauth 认证的 web_server_redirect_uri
     */
    @Column(name = "web_server_redirect_uri")
    private String webServerRedirectUri;

    /**
     * 用户的 authorities
     */
    @Column(name = "authorities")
    private String authorities;

    /**
     * token 有效期 access_token_validity
     */
    @Column(name = "access_token_validity")
    private String accessTokenValidity;

    /**
     * refresh token 有效期 refresh_token_validity
     */
    @Column(name = "refresh_token_validity")
    private String refreshTokenValidity;

    /**
     * 额外信息
     */
    @Column(name = "additional_information")
    private String additionalInformation;

    /**
     * autoapprove
     */
    @Column(name = "autoapprove")
    private String autoapprove;

}
