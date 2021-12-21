package com.sframe.app.common.response;

import lombok.Data;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName RestResponse
 * @Description Rest Api 响应对象
 * @Author mumu
 * @Date 2020/3/22 11:12 下午
 * @Version 1.0
 */
@Data
public class RestResponse<T> {

    /**
     * 返回码
     */
    private String code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回对象
     */
    private T body;

    /**
     * 接口耗时
     */
    private Long cost;

    public RestResponse(String code, String message) {
        this.code = code;
        this.message = message;

        if (RequestContextHolder.getRequestAttributes() != null) {
            HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            this.cost = System.currentTimeMillis() - (long) req.getAttribute("starttime");
        } else {
            this.cost = 99999L;
        }
    }

    public RestResponse(String code, String message, T body) {
        this.code = code;
        this.message = message;
        this.body = body;

        if (RequestContextHolder.getRequestAttributes() != null) {
            HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            this.cost = System.currentTimeMillis() - (long) req.getAttribute("starttime");
        } else {
            this.cost = 99999L;
        }
    }

}
