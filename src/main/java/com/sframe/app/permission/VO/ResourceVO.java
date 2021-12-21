package com.sframe.app.permission.VO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName ResourceVO
 * @Description 权限 VO
 * @Author mumu
 * @Date 2020/6/14 3:02 下午
 * @Version 1.0
 */
@ApiModel(value = "权限输入参数")
@Data
public class ResourceVO {

    @NotBlank
    @ApiModelProperty(value = "权限名称")
    private String name;

    @NotBlank
    @ApiModelProperty(value = "权限 code")
    private String code;

    @ApiModelProperty(value = "权限路径")
    private String path;

    @ApiModelProperty(value = "请求类型")
    private String requestType;

    @NotBlank
    @ApiModelProperty(value = "排序")
    private String sort;

    @NotBlank
    @ApiModelProperty(value = "权限 icon")
    private String icon;

    @ApiModelProperty(value = "权限描述")
    private String description;

}
