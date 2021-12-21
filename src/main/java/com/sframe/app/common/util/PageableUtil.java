package com.sframe.app.common.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;

/**
 * @ClassName PageableUtil
 * @Description pageable 分页参数组合
 * @Author mumu
 * @Date 2020/10/8 10:45 下午
 * @Version 1.0
 */
public class PageableUtil {

    /**
     * 组合 pageable 参数
     *
     * @param pageNum
     * @param pageSize
     * @param sortDirection
     * @param sortProperties
     * @return
     */
    public static Pageable convertPageable(Integer pageNum, Integer pageSize, String sortDirection, String sortProperties) {
        Pageable pageable;
        if (StringUtils.isEmpty(sortProperties)) {
            pageable = PageRequest.of(pageNum - 1, pageSize, Sort.Direction.DESC, "cstCreate");
        } else {
            pageable = PageRequest.of(pageNum - 1, pageSize, Sort.Direction.ASC.name().equalsIgnoreCase(sortDirection) ? Sort.Direction.ASC : Sort.Direction.DESC, sortProperties);
        }
        return pageable;
    }
}
