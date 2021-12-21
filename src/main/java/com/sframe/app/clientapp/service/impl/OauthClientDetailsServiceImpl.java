package com.sframe.app.clientapp.service.impl;

import com.sframe.app.clientapp.DO.OauthClientDetailsDO;
import com.sframe.app.clientapp.VO.OauthClientDetailsVO;
import com.sframe.app.clientapp.query.OauthClientDetailsQuery;
import com.sframe.app.clientapp.repository.OauthClientDetailsRepository;
import com.sframe.app.clientapp.service.OauthClientDetailsService;
import com.sframe.app.common.constant.ResultCode;
import com.sframe.app.common.exception.BusinessException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @ClassName OauthClientDetailsServiceImpl
 * @Description OauthClientDetails Service 实现类
 * @Author mumu
 * @Date 2020/3/16 10:29 下午
 * @Version 1.0
 */
@Service
public class OauthClientDetailsServiceImpl implements OauthClientDetailsService {

    @Autowired
    private OauthClientDetailsRepository oauthClientDetailsRepository;

    @Override
    public Optional<OauthClientDetailsVO> getOauthClientDetailsById(String oauthClientDetailsId) {
        Optional<OauthClientDetailsDO> oauthClientDetailsDO = oauthClientDetailsRepository.findById(oauthClientDetailsId);
        if (oauthClientDetailsDO.isEmpty()) {
            throw new BusinessException(ResultCode.CLIENT_APP_NOT_FOUND);
        }
        OauthClientDetailsVO oauthClientDetailsVO = new OauthClientDetailsVO();
        BeanUtils.copyProperties(oauthClientDetailsDO.get(), oauthClientDetailsVO);
        return Optional.of(oauthClientDetailsVO);
    }

    @Override
    public Page<OauthClientDetailsVO> pageQueryOauthClientDetails(Pageable pageable, OauthClientDetailsQuery oauthClientDetailsQuery) {
        Page<OauthClientDetailsDO> oauthClientDetailsDOPage = oauthClientDetailsRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicatesList = new ArrayList<>();
            // client id 模糊查询
            if (!StringUtils.isEmpty(oauthClientDetailsQuery.getClientId())) {
                predicatesList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.like(
                                        root.get("clientId"), "%" + oauthClientDetailsQuery.getClientId() + "%")));
            }

            return criteriaBuilder.and(
                    predicatesList.toArray(new Predicate[predicatesList.size()]));
        }, pageable);

        return oauthClientDetailsDOPage.map(this::convert);
    }

    @Override
    public String createClientDetail(OauthClientDetailsVO oauthClientDetailsVO) {
        OauthClientDetailsDO oauthClientDetailsDO = new OauthClientDetailsDO();
        BeanUtils.copyProperties(oauthClientDetailsVO, oauthClientDetailsDO);
        oauthClientDetailsDO = oauthClientDetailsRepository.save(oauthClientDetailsDO);
        return oauthClientDetailsDO.getId();
    }

    /**
     * 将 OauthClientDetailsDO 转换成 OauthClientDetailsVO
     *
     * @param oauthClientDetailsDO
     * @return
     */
    private OauthClientDetailsVO convert(OauthClientDetailsDO oauthClientDetailsDO) {
        OauthClientDetailsVO oauthClientDetailsVO = new OauthClientDetailsVO();
        BeanUtils.copyProperties(oauthClientDetailsDO, oauthClientDetailsVO);
        return oauthClientDetailsVO;
    }

}
