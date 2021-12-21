package com.sframe.app.common.exception;

import com.sframe.app.common.constant.ResultCode;
import com.sframe.app.common.response.RestResponse;
import com.sframe.app.common.response.RestResponseUtil;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @ClassName RestExceptionHandler
 * @Description Rest Api Exception 统一处理类
 * @Author mumu
 * @Date 2020/3/26 9:48 下午
 * @Version 1.0
 */
@Slf4j
@ControllerAdvice
public class RestExceptionHandler {

    /**
     * 处理资源不存在，返回404
     *
     * @param e
     * @return
     */
    @ExceptionHandler(NotFoundException.class)
    @Order(1)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public RestResponse<Void> handleNotFoundException(NotFoundException e) {
        log.error(e.getMessage(), e);
        return RestResponseUtil.error(ResultCode.NOT_FOUND.name());
    }

    /**
     * 处理其他业务异常，返回409
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    @Order(99)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    @ResponseBody
    public RestResponse<Void> handleBusinessException(BusinessException e) {
        log.error(e.getMessage(), e);
        if (e.getResultCode() != null) {
            return RestResponseUtil.error(e.getResultCode().name());
        } else {
            return RestResponseUtil.error(ResultCode.BUSINESS_ERROR.name());
        }
    }

    /**
     * 处理其余异常，返回500
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @Order(100)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public RestResponse<Void> handleExecption(Exception e) {
        log.error(e.getMessage(), e);
        return RestResponseUtil.error(ResultCode.SYSTEM_ERROR.name());
    }

}
