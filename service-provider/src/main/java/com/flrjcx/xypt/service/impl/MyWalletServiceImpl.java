package com.flrjcx.xypt.service.impl;

import com.alibaba.fastjson.JSON;
import com.flrjcx.xypt.common.enums.KafkaTopicEnum;
import com.flrjcx.xypt.common.enums.ValidStatusEnum;
import com.flrjcx.xypt.common.model.param.common.Users;
import com.flrjcx.xypt.common.utils.KafkaUtils;
import com.flrjcx.xypt.common.utils.OrderUtils;
import com.flrjcx.xypt.common.utils.UserThreadLocal;
import com.flrjcx.xypt.mapper.MyWalletMapper;
import com.flrjcx.xypt.service.MyWalletService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Objects;

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
     * 充值/提现
     *
     * @param money:金额
     * @param type:类型
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int recharge(BigDecimal money, int type) {
        Users users = UserThreadLocal.get();
        if (Objects.equals(ValidStatusEnum.InValidStatus.getCode(), type)) {
//            充值
            myWalletMapper.recharge(money, users.getUserId());
        } else {
            if (myWalletMapper.checkMoney(money, users.getUserId())) {
//            提现
                myWalletMapper.deposit(money, users.getUserId());
//        写入资金明细和平台交易额
                sendMessageAsync(KafkaTopicEnum.TOPIC_MONEY_SEND_DETAIL, JSON.toJSONString(OrderUtils.makeTransaction(money, users.getUserId(), type)));
                return ValidStatusEnum.ValidStatus.getCode();
            }else {
                return ValidStatusEnum.MinusStatus.getCode();
            }

        }
//        写入资金明细和平台交易额
        sendMessageAsync(KafkaTopicEnum.TOPIC_MONEY_SEND_DETAIL, JSON.toJSONString(OrderUtils.makeTransaction(money, users.getUserId(), type)));

        return ValidStatusEnum.InValidStatus.getCode();
    }

    /**
     * 获取用户S币
     *
     * @return
     */
    @Override
    public BigDecimal getBalance() {
        Users users = UserThreadLocal.get();
        return myWalletMapper.getBalance(users.getUserId());
    }

    @Async
    public void sendMessageAsync(String topic, String s) {
        kafkaUtils.sendMessage(topic, s);
    }
}
