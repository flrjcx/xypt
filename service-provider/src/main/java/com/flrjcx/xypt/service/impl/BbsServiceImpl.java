package com.flrjcx.xypt.service.impl;

import com.flrjcx.xypt.common.enums.ResultCodeEnum;
import com.flrjcx.xypt.common.exception.WebServiceEnumException;
import com.flrjcx.xypt.common.exception.WebServiceException;
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
     * 先查 bbs 表中是否有对应的 bbsId , 再向 bbs_praise 添加字段
     *
     * @param bbsId  点赞贴子id
     * @param userId 点赞用户id
     * @return
     */
    @Override
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
    public ResultCodeEnum cancelNo(Long bbsId, Long userId) throws WebServiceException {
        if (!bbsNoMapper.deleteNo(bbsId, userId)) {
            throw WebServiceEnumException.buildResponseData(ResultCodeEnum.ERROR_CODE_BBS_NO_DELETE_ERROR);
        }
        if (!bbsMapper.cancelNo(bbsId)) {
            throw WebServiceEnumException.buildResponseData(ResultCodeEnum.ERROR_CODE_BBS_UPDATE_ERROR);
        }
        return ResultCodeEnum.SUCCESS;
    }
}
