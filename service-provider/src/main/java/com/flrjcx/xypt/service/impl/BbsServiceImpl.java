package com.flrjcx.xypt.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.flrjcx.xypt.common.enums.KafkaTopicEnum;
import com.flrjcx.xypt.common.enums.ResultCodeEnum;
import com.flrjcx.xypt.common.exception.WebServiceEnumException;
import com.flrjcx.xypt.common.exception.WebServiceException;
import com.flrjcx.xypt.common.model.param.bbs.BbsEditParam;
import com.flrjcx.xypt.common.model.param.bbs.BbsReward;
import com.flrjcx.xypt.common.model.param.common.Users;
import com.flrjcx.xypt.common.utils.KafkaUtils;
import com.flrjcx.xypt.common.utils.OrderUtils;
import com.flrjcx.xypt.common.utils.UserThreadLocal;
import com.flrjcx.xypt.mapper.BbsMapper;
import com.flrjcx.xypt.mapper.BbsNoMapper;
import com.flrjcx.xypt.mapper.BbsPraiseMapper;
import com.flrjcx.xypt.mapper.MyWalletMapper;
import com.flrjcx.xypt.service.BbsService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author : aftermath
 * @date : 2022-11-04 09:36:39
 */
@Service
public class BbsServiceImpl implements BbsService {

    @Resource
    BbsMapper bbsMapper;

    @Resource
    BbsPraiseMapper bbsPraiseMapper;

    @Resource
    BbsNoMapper bbsNoMapper;

    @Resource
    private KafkaUtils kafkaUtils;

    @Resource
    private MyWalletMapper myWalletMapper;

    /**
     * 编辑帖子
     *
     * @param param 帖子更新对象
     * @param users 发送修改帖子请求的用户
     * @return 是否修改成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean editPost(BbsEditParam param, Users users) {
        Long bbsId = param.getBbsId();
        String bbsContext = param.getBbsContext();
        String bbsTitle = param.getBbsTitle();
        String bbsContextMd = param.getBbsContextMd();
        if (!StrUtil.isAllNotBlank(bbsContextMd, bbsContext) && StrUtil.isEmpty(bbsTitle)) {
            return false;
        }
        //检查该用户是否为帖子的发帖人
        Long userId = bbsMapper.selectBbsOwner(bbsId);
        if (ObjectUtil.isNull(userId)) {
            return false;
        }
        if (!userId.equals(users.getUserId())) {
            return false;
        }
        //编辑帖子
        int updatePost = bbsMapper.updatePost(param);
        return updatePost > 0;
    }

    /**
     * 根据id删除帖子
     *
     * @param bbsId 帖子id
     * @param users 发送删帖请求的用户
     * @return 是否删除成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deletePostById(Long bbsId, Users users) {
        //判断需要删帖的人与帖子的主人是否为同一个人
        Long ownerId = bbsMapper.selectBbsOwner(bbsId);
        if (users.getUserId().equals(ownerId)) {
            int deletePostById = bbsMapper.deletePostById(bbsId);
            return deletePostById > 0;
        }
        return false;
    }

    /**
     * 点赞
     * 先查 bbs 表中是否有对应的 bbsId , 再向 bbs_praise 添加字段
     *
     * @param bbsId  点赞贴子id
     * @param userId 点赞用户id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultCodeEnum praise(Long bbsId, Long userId) throws WebServiceException {
        if (!bbsMapper.updatePraise(bbsId)) {
            throw WebServiceEnumException.buildResponseData(ResultCodeEnum.ERROR_CODE_BBS_UPDATE_ERROR);
        }
        if (!bbsPraiseMapper.insertPraise(bbsId, userId)) {
            throw WebServiceEnumException.buildResponseData(ResultCodeEnum.ERROR_CODE_BBS_PRAISE_INSERT_ERROR);
        }
        return ResultCodeEnum.SUCCESS;
    }

    /**
     * 取消点赞
     * 先查 bbs_praise 表中是否有对应的 bbsId-userId 字段并删除, 再更新 bbs 表
     *
     * @param bbsId  取消点赞贴子id
     * @param userId 取消点赞用户id
     * @return 点赞是否成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultCodeEnum cancelPraise(Long bbsId, Long userId) throws WebServiceException {
        if (!bbsPraiseMapper.deletePraise(bbsId, userId)) {
            throw WebServiceEnumException.buildResponseData(ResultCodeEnum.ERROR_CODE_BBS_PRAISE_DELETE_ERROR);
        }
        if (!bbsMapper.cancelPraise(bbsId)) {
            throw WebServiceEnumException.buildResponseData(ResultCodeEnum.ERROR_CODE_BBS_UPDATE_ERROR);
        }
        return ResultCodeEnum.SUCCESS;
    }

    /**
     * 点踩
     * 先查 bbs 表中是否有对应的 bbsId , 再向 bbs_no 添加字段
     *
     * @param bbsId  点赞贴子id
     * @param userId 点赞用户id
     * @return 点踩是否成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultCodeEnum no(Long bbsId, Long userId) throws WebServiceException {
        if (!bbsMapper.updateNo(bbsId)) {
            throw WebServiceEnumException.buildResponseData(ResultCodeEnum.ERROR_CODE_BBS_UPDATE_ERROR);
        }
        if (!bbsNoMapper.insertNo(bbsId, userId)) {
            throw WebServiceEnumException.buildResponseData(ResultCodeEnum.ERROR_CODE_BBS_NO_INSERT_ERROR);
        }
        return ResultCodeEnum.SUCCESS;
    }

    /**
     * 取消点踩
     * 先查 bbs_no 表中是否有对应的 bbsId-userId 字段并删除, 再更新 bbs 表
     *
     * @param bbsId  取消点踩贴子id
     * @param userId 取消点踩用户id
     * @return 点踩是否成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultCodeEnum cancelNo(Long bbsId, Long userId) throws WebServiceException {
        if (!bbsNoMapper.deleteNo(bbsId, userId)) {
            throw WebServiceEnumException.buildResponseData(ResultCodeEnum.ERROR_CODE_BBS_NO_DELETE_ERROR);
        }
        if (!bbsMapper.cancelNo(bbsId)) {
            throw WebServiceEnumException.buildResponseData(ResultCodeEnum.ERROR_CODE_BBS_UPDATE_ERROR);
        }
        return ResultCodeEnum.SUCCESS;
    }

    /**
     * 打赏
     *
     * @param bbsReward
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void reward(BbsReward bbsReward) {
        BigDecimal balance = myWalletMapper.getBalance(UserThreadLocal.get().getUserId());
        BigDecimal subtractBalance = balance.subtract(bbsReward.getMoney());
        sendMessageAsync(KafkaTopicEnum.TOPIC_BBS_REWARD_SEND, JSONObject.toJSONString(OrderUtils.makeTransaction(bbsReward.getMoney(), UserThreadLocal.get().getUserId(),
                bbsReward.getBeUserId(), bbsReward.getContent(), bbsReward.getTransactionBeUserNick(), subtractBalance)));
    }


    /**
     * kafka生产者
     *
     * @param topic
     * @param s
     */
    @Async
    public void sendMessageAsync(String topic, String s) {
        kafkaUtils.sendMessage(topic, s);
    }
}
