package com.flrjcx.xypt.service.impl;

import com.alibaba.fastjson.JSON;
import com.flrjcx.xypt.common.enums.KafkaTopicEnum;
import com.flrjcx.xypt.common.utils.KafkaUtils;
import com.flrjcx.xypt.common.utils.OrderUtils;
import com.flrjcx.xypt.mapper.MyWalletMapper;
import com.flrjcx.xypt.service.MyWalletService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
/**
 * 我的钱包
 *
 * @author Flrjcx
 */
@Service
public class MyWalletServiceImpl implements MyWalletService {

    @Resource
    private MyWalletMapper myWalletMapper;

    @Resource
    private KafkaUtils kafkaUtils;

    /**
     * 充值
     *
     * @param money
     * @param userId
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void recharge(BigDecimal money,Long userId) {
//        充值
        myWalletMapper.recharge(money,userId);
//        写入资金明细和平台交易额
        kafkaUtils.sendMessage(KafkaTopicEnum.TOPIC_MONEY_SEND_DETAIL, JSON.toJSONString(OrderUtils.makeTransaction(money,userId,0)));

    }
}
