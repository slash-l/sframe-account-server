package com.sframe.app.permission.controller;

import com.sframe.app.common.exception.ArgumentValidationException;
import com.sframe.app.common.response.RestResponse;
import com.sframe.app.common.response.RestResponseUtil;
import com.sframe.app.permission.VO.ResourceVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName ResourceController
 * @Description 权限 controller
 * @Author mumu
 * @Date 2020/6/14 2:51 下午
 * @Version 1.0
 */
@Api(tags = "权限 api", description = "权限相关接口")
@RestController
@RequestMapping(value = "/permission")
public class ResourceController {

    /**
     * 更新权限数据
     *
     * @param id
     * @param bindingResult
     * @return
     */
    @ApiOperation("更新权限信息")
    @PutMapping("/resource/{id}")
    public RestResponse updateResource(@PathVariable String id, ResourceVO resourceVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ArgumentValidationException(bindingResult.getFieldError().getDefaultMessage());
        }
        return RestResponseUtil.success(id);
    }
}
