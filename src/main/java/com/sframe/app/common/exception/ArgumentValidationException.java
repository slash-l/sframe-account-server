package com.sframe.app.common.exception;

/**
 * @ClassName ArgumentValidationException
 * @Description TODO
 * @Author mumu
 * @Date 2020/3/26 11:22 下午
 * @Version 1.0
 */
public class ArgumentValidationException extends BusinessException {

    public ArgumentValidationException(String message) {
        super(message);
    }

    public ArgumentValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
