package com.flrjcx.xypt.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @author : aftermath
 * @date : 2022-11-04 10:04:44
 */
public interface BbsMapper {
    /**
     * bbs_praise字段+1
     * @param bbsId 帖子id
     * @return 字段更新是否成功
     */
    boolean updatePraise(@Param("bbsId") Long bbsId);

    /**
     * bbs_praise字段-1
     * @param bbsId 帖子id
     * @return 字段更新是否成功
     */
    boolean cancelPraise(@Param("bbsId") Long bbsId);

    /**
     * bbs_no字段+1
     * @param bbsId 帖子id
     * @return 字段更新是否成功
     */
    boolean updateNo(@Param("bbsId") Long bbsId);

    /**
     * bbs_no字段-1
     * @param bbsId 帖子id
     * @return 字段更新是否成功
     */
    boolean cancelNo(@Param("bbsId") Long bbsId);
}
