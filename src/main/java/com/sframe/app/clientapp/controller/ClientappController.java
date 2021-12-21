package com.sframe.app.clientapp.controller;

import com.sframe.app.clientapp.VO.OauthClientDetailsVO;
import com.sframe.app.clientapp.query.OauthClientDetailsQuery;
import com.sframe.app.clientapp.service.OauthClientDetailsService;
import com.sframe.app.common.exception.ArgumentValidationException;
import com.sframe.app.common.response.RestResponse;
import com.sframe.app.common.response.RestResponseUtil;
import com.sframe.app.common.util.PageableUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @ClassName ClientappController
 * @Description Client app 注册类
 * @Author mumu
 * @Date 2020/3/14 8:22 下午
 * @Version 1.0
 */
@Api(tags = "")
@RestController
@RequestMapping("/clientapp")
public class ClientappController {

    @Autowired
    private OauthClientDetailsService oauthClientDetailsService;

    /**
     * 根据唯一 ID 查找客户端注册应用
     *
     * @param oauthClientDetailsId
     * @return
     */
    @GetMapping("/clientDetail/{id}")
    public RestResponse<OauthClientDetailsVO> getOauthClientDetails(@PathVariable("id") String oauthClientDetailsId) {
        // 调用 Service
        Optional<OauthClientDetailsVO> optionalOauthClientDetailsVO = oauthClientDetailsService.getOauthClientDetailsById(oauthClientDetailsId);
        return RestResponseUtil.success(optionalOauthClientDetailsVO.orElseGet(OauthClientDetailsVO::new));
    }

    /**
     * 根据条件查询客户端注册应用列表
     *
     * @param pageNum  页码
     * @param pageSize 每页显示条数
     * @return
     */
    @GetMapping("/clientDetail/pageByCondition")
    public RestResponse<Page<OauthClientDetailsVO>> pageQueryOauthClientDetails(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                                String sortDirection, String sortProperties,
                                                                                OauthClientDetailsQuery oauthClientDetailsQuery) {
        Pageable pageable = PageableUtil.convertPageable(pageNum, pageSize, sortDirection, sortProperties);
        Page<OauthClientDetailsVO> page = oauthClientDetailsService.pageQueryOauthClientDetails(pageable, oauthClientDetailsQuery);
        return RestResponseUtil.success(page);
    }

    /**
     * @return
     */
    @PostMapping("/clientDetail")
    public RestResponse createClientDetail(OauthClientDetailsVO oauthClientDetailsVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ArgumentValidationException(bindingResult.getFieldError().getDefaultMessage());
        }
        return RestResponseUtil.success();
    }

}
