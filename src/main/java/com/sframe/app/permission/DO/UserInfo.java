package com.sframe.app.permission.DO;

import com.sframe.app.base.DO.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * @ClassName UserInfo
 * @Description
 * @Author mumu
 * @Date 2020/3/2 11:54 下午
 * @Version 1.0
 */
@Entity
@Table(name = "t_user")
@Data
@EqualsAndHashCode(callSuper = false)
public class UserInfo extends BaseDO {

    private String loginName;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * email
     */
    private String email;

    /**
     * 电话号码
     */
    private Integer phoneNumber;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 地址
     */
    private String address;

    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        ADMIN, NORMAL
    }

}
