package com.sframe.app.permission.repository;

import com.sframe.app.permission.DO.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @ClassName UserInfoRepository
 * @Description user repository
 * @Author mumu
 * @Date 2020/3/3 12:03 上午
 * @Version 1.0
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, Long>, JpaSpecificationExecutor<UserInfo> {

    /**
     * 根据用户名查找用户信息
     *
     * @param userName 用户名
     * @return
     */
    public UserInfo findByUserName(String userName);
}
