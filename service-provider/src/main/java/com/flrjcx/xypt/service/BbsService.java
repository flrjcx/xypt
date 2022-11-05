package com.flrjcx.xypt.service;

import com.flrjcx.xypt.common.enums.ResultCodeEnum;

/**
 * @author : aftermath
 * @date : 2022-11-04 09:36:20
 */
public interface BbsService {
    /**
     * 点赞
     *
     * @param bbsId 点赞贴子id
     * @param userId 点赞用户id
     * @return 点赞是否成功
     */
    ResultCodeEnum praise(Long bbsId, Long userId);

    /**
     * 取消点赞
     *
     * @param bbsId 取消点赞贴子id
     * @param userId 取消点赞用户id
     * @return 点赞是否成功
     */
    ResultCodeEnum cancelPraise(Long bbsId, Long userId);

    /**
     * 点踩
     *
     * @param bbsId 点赞贴子id
     * @param userId 点赞用户id
     * @return 点踩是否成功
     */
    ResultCodeEnum no(Long bbsId, Long userId);

    /**
     * 取消点踩
     *
     * @param bbsId 取消点踩贴子id
     * @param userId 取消点踩用户id
     * @return 点踩是否成功
     */
    ResultCodeEnum cancelNo(Long bbsId, Long userId);
}
