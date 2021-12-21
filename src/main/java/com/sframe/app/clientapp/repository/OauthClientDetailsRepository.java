package com.sframe.app.clientapp.repository;

import com.sframe.app.clientapp.DO.OauthClientDetailsDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @ClassName OauthClientDetailsRepository
 * @Description OauthClientDetails Repository
 * @Author mumu
 * @Date 2020/3/16 10:19 下午
 * @Version 1.0
 */
public interface OauthClientDetailsRepository extends JpaRepository<OauthClientDetailsDO, String>, JpaSpecificationExecutor<OauthClientDetailsDO> {
}
