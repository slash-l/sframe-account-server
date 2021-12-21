package com.sframe.app.common.response;

import com.sframe.app.common.constant.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * @ClassName RestResponseUtil
 * @Description RestResponse Util 处理 Rest Api 响应结果
 * @Author mumu
 * @Date 2020/3/22 11:24 下午
 * @Version 1.0
 */
@Component
public class RestResponseUtil {

    private static MessageSource messageSource;

    public MessageSource getMessageSource() {
        return messageSource;
    }

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        RestResponseUtil.messageSource = messageSource;
    }

    /**
     * 接口调用成功（无返回对象）
     *
     * @return
     */
    public static RestResponse success() {
        String successMessage = messageSource.getMessage(ResultCode.SUCCESS.name(), null, LocaleContextHolder.getLocale());
        return new RestResponse(ResultCode.SUCCESS.name(), successMessage);
    }

    /**
     * 接口调用成功（有返回对象）
     *
     * @return
     */
    public static <T> RestResponse<T> success(T body) {
        String successMessage = messageSource.getMessage(ResultCode.SUCCESS.name(), null, LocaleContextHolder.getLocale());
        return new RestResponse(ResultCode.SUCCESS.name(), successMessage, body);
    }

    /**
     * 接口调用失败
     *
     * @return
     */
    public static RestResponse error(String errCode) {
        String errorMessage = messageSource.getMessage(errCode, null, LocaleContextHolder.getLocale());
        return new RestResponse(errCode, errorMessage);
    }
}
