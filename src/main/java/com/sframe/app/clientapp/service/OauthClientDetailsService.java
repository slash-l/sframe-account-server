package com.sframe.app.clientapp.service;

import com.sframe.app.clientapp.VO.OauthClientDetailsVO;
import com.sframe.app.clientapp.query.OauthClientDetailsQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * @ClassName OauthClientDetailsService
 * @Description OauthClientDetails Service
 * @Author mumu
 * @Date 2020/3/16 10:18 下午
 * @Version 1.0
 */
public interface OauthClientDetailsService {

    /**
     * 根据唯一主键 ID 查找注册的应用客户端 对象
     *
     * @param oauthClientDetailsId
     * @return
     */
    public Optional<OauthClientDetailsVO> getOauthClientDetailsById(String oauthClientDetailsId);

    /**
     * @return
     */
    public Page<OauthClientDetailsVO> pageQueryOauthClientDetails(Pageable pageable, OauthClientDetailsQuery oauthClientDetailsQuery);

    /**
     * @param oauthClientDetailsVO
     * @return
     */
    public String createClientDetail(OauthClientDetailsVO oauthClientDetailsVO);
}
