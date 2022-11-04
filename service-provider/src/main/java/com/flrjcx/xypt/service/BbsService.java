package com.flrjcx.xypt.service;

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
    boolean praise(Long bbsId, Long userId);

    /**
     * 取消点赞
     *
     * @param bbsId 取消点赞贴子id
     * @param userId 取消点赞用户id
     * @return 点赞是否成功
     */
    boolean cancelPraise(Long bbsId, Long userId);

    /**
     * 点踩
     *
     * @param bbsId 点赞贴子id
     * @param userId 点赞用户id
     * @return 点踩是否成功
     */
    boolean no(Long bbsId, Long userId);

    /**
     * 取消点踩
     *
     * @param bbsId 取消点踩贴子id
     * @param userId 取消点踩用户id
     * @return 点踩是否成功
     */
    boolean cancelNo(Long bbsId, Long userId);
}
