package com.sframe.app.permission.controller;

import com.sframe.app.common.response.RestResponse;
import com.sframe.app.common.response.RestResponseUtil;
import com.sframe.app.common.util.PageableUtil;
import com.sframe.app.permission.VO.UserVO;
import com.sframe.app.permission.query.UserQuery;
import com.sframe.app.permission.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author mumu
 * @Date 2020/4/12 8:56 下午
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/permission")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/user/pageByCondition")
    public RestResponse<Page<UserVO>> findUserListByCondition(
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            String sortDirection, String sortProperties,
            UserQuery userQuery) {

        Pageable pageable = PageableUtil.convertPageable(pageNum, pageSize, sortDirection, sortProperties);

        Page<UserVO> page = userInfoService.findUserListByCondition(pageable, userQuery);
        return RestResponseUtil.success(page);

//
//        List<UserVO> userVOList = new ArrayList<UserVO>();
//        UserVO userVO = new UserVO();
//        userVO.setKey("1");
//        userVO.setName("木木");
//        userVO.setAge("38");
//        userVO.setAddress("上海");
//        userVO.setTags(new String[]{"developer", "master"});
//
//        UserVO userVO2 = new UserVO();
//        userVO2.setKey("2");
//        userVO2.setName("小猪");
//        userVO2.setAge("35");
//        userVO2.setAddress("上海");
//        userVO2.setTags(new String[]{"owner"});
//
//        UserVO userVO3 = new UserVO();
//        userVO3.setKey("3");
//        userVO3.setName("果果");
//        userVO3.setAge("8");
//        userVO3.setAddress("上海");
//        userVO3.setTags(new String[]{"child", "student"});
//
//        UserVO userVO4 = new UserVO();
//        userVO4.setKey("4");
//        userVO4.setName("糖糖");
//        userVO4.setAge("4");
//        userVO4.setAddress("上海");
//        userVO4.setTags(new String[]{"baby"});
//
//        userVOList.add(userVO);
//        userVOList.add(userVO2);
//        userVOList.add(userVO3);
//        userVOList.add(userVO4);

    }
}
