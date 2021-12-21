package com.sframe.app.permission.service;

import com.sframe.app.permission.DO.UserInfo;
import com.sframe.app.permission.VO.UserVO;
import com.sframe.app.permission.query.UserQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @ClassName UserInfoService
 * @Description 用户接口
 * @Author mumu
 * @Date 2020/3/2 11:54 下午
 * @Version 1.0
 */
public interface UserInfoService {

    /**
     * 根据用户名查找用户信息
     *
     * @param userName 用户名
     * @return
     */
    public UserInfo findByUserName(String userName);

    /**
     * 查询用户信息分页列表信息
     *
     * @param pageable  分页参数对象
     * @param userQuery 查询条件对象
     * @return
     */
    public Page<UserVO> findUserListByCondition(Pageable pageable, UserQuery userQuery);

}
