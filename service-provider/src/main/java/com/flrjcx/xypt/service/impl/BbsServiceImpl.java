package com.flrjcx.xypt.service.impl;

import com.flrjcx.xypt.mapper.BbsMapper;
import com.flrjcx.xypt.mapper.BbsNoMapper;
import com.flrjcx.xypt.mapper.BbsPraiseMapper;
import com.flrjcx.xypt.service.BbsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

    /**
     * 点赞
     *
     * @param bbsId  点赞贴子id
     * @param userId 点赞用户id
     * @return
     */
    @Override
    public boolean praise(Long bbsId, Long userId) {
        return bbsMapper.updatePraise(bbsId) && bbsPraiseMapper.insertPraise(bbsId, userId);
    }

    /**
     * 取消点赞
     *
     * @param bbsId  取消点赞贴子id
     * @param userId 取消点赞用户id
     * @return 点赞是否成功
     */
    @Override
    public boolean cancelPraise(Long bbsId, Long userId) {
        return bbsMapper.cancelPraise(bbsId) && bbsPraiseMapper.deletePraise(bbsId, userId);
    }

    /**
     * 点踩
     *
     * @param bbsId  点赞贴子id
     * @param userId 点赞用户id
     * @return 点踩是否成功
     */
    @Override
    public boolean no(Long bbsId, Long userId) {
        return bbsMapper.updateNo(bbsId) && bbsNoMapper.insertNo(bbsId, userId);
    }

    /**
     * 取消点踩
     *
     * @param bbsId  取消点踩贴子id
     * @param userId 取消点踩用户id
     * @return 点踩是否成功
     */
    @Override
    public boolean cancelNo(Long bbsId, Long userId) {
        return bbsMapper.cancelNo(bbsId) && bbsNoMapper.deleteNo(bbsId, userId);
    }
}
