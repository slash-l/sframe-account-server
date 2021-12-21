package com.sframe.app.common.constant;

/**
 * @ClassName ResultCode
 * @Description Rest Api 返回码
 * @Author mumu
 * @Date 2020/3/26 5:27 下午
 * @Version 1.0
 */
public enum ResultCode {

    /**
     * 成功
     */
    SUCCESS,
    /**
     * 资源不存在
     */
    NOT_FOUND,
    /**
     * 业务异常
     */
    BUSINESS_ERROR,
    /**
     * 系统异常
     */
    SYSTEM_ERROR,

    /**
     * clent app 数据不存在
     */
    CLIENT_APP_NOT_FOUND
}
