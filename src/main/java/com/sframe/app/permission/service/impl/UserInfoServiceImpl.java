package com.sframe.app.permission.service.impl;

import com.sframe.app.permission.DO.UserInfo;
import com.sframe.app.permission.VO.UserVO;
import com.sframe.app.permission.query.UserQuery;
import com.sframe.app.permission.repository.UserInfoRepository;
import com.sframe.app.permission.service.UserInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserInfoServiceImpl
 * @Description 用户接口实现类
 * @Author mumu
 * @Date 2020/3/3 12:08 上午
 * @Version 1.0
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findByUserName(String userName) {
        return userInfoRepository.findByUserName(userName);
    }

    @Override
    public Page<UserVO> findUserListByCondition(Pageable pageable, UserQuery userQuery) {

        Specification<UserInfo> specification = (Specification<UserInfo>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();
            // loginName 登录名 模糊查询
            if (!StringUtils.isEmpty(userQuery.getLoginName())) {
                predicateList.add(criteriaBuilder.and(criteriaBuilder.like(root.get("loginName"), "%" + userQuery.getLoginName() + "%")));
            }
            return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
        };

        Page<UserInfo> userInfoPage = userInfoRepository.findAll(specification, pageable);

        return userInfoPage.map(this::convert);
    }

    /**
     * 将 UserInfo 转换成 UserVO
     *
     * @param userInfo
     * @return
     */
    private UserVO convert(UserInfo userInfo) {
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userInfo, userVO);
        return userVO;
    }
}
