package com.sframe.app.permission.query;

import lombok.Data;

/**
 * @ClassName UserQuery
 * @Description TODO
 * @Author mumu
 * @Date 2020/10/1 12:52 上午
 * @Version 1.0
 */
@Data
public class UserQuery {

    private String loginName;

    private String userName;

    private String email;

    private Integer phoneNumber;

}
