package com.sframe.app.common.exception;

import com.sframe.app.common.constant.ResultCode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * @ClassName BusinessException
 * @Description 业务异常
 * @Author mumu
 * @Date 2020/3/26 10:01 下午
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Component
public class BusinessException extends RuntimeException {

    private ResultCode resultCode;

    private static MessageSource messageSource;

    public MessageSource getMessageSource() {
        return messageSource;
    }

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        BusinessException.messageSource = messageSource;
    }

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(ResultCode resultCode) {
        super(messageSource.getMessage(resultCode.name(), null, LocaleContextHolder.getLocale()));
        this.resultCode = resultCode;
    }

    /**
     * @param message
     * @param cause
     */
    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public static BusinessException from(String code) {
        return new BusinessException(code);
    }
}
