package com.caiwl.yungo.service;

import com.caiwl.yungo.bean.Body;
import com.caiwl.yungo.entity.Apply;
import com.caiwl.yungo.entity.ApplyAuth;
import com.caiwl.yungo.enums.ApplyAuthEnum;
import com.caiwl.yungo.mapper.ApplyAuthMapper;
import com.caiwl.yungo.mapper.ApplyMapper;
import com.caiwl.yungo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author caiwl
 * @date 2019/1/24 19:41
 */
@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private ApplyMapper applyMapper;
    @Autowired
    private ApplyAuthMapper applyAuthMapper;

    @Override
    public Body submitAuth(Long customerId, ApplyAuthEnum.DataType dataType, String ossKey) {
        Apply apply = applyMapper.getByCustomerId(customerId);
        if (apply == null) {
            apply = new Apply();
            apply.setCustomerId(customerId);
            // 该SQL语句的执行不需要事务控制
            applyMapper.insertSelective(apply);
        }
        switch (dataType) {
            case ID_CARD:
                apply.setIdCardStatus(true);
                break;
            case MX_CARRIER:
                apply.setMxCarrierStatus(true);
                break;
            case INFO:
                apply.setInfoStatus(true);
                apply.setFinishAuthTime(new Date());
                break;
        }

        ApplyAuth applyAuth = new ApplyAuth();
        applyAuth.setApplyId(apply.getId());
        applyAuth.setDataType(dataType.getDataType());
        applyAuth.setOssKey(ossKey);

        applyMapper.updateByPrimaryKeySelective(apply);
        applyAuthMapper.insertSelective(applyAuth);

        return Body.success();
    }
}
