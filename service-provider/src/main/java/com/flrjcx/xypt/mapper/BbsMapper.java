package com.flrjcx.xypt.mapper;

import com.flrjcx.xypt.common.model.param.bbs.Bbs;
import com.flrjcx.xypt.common.model.param.bbs.BbsEditParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : aftermath
 * @date : 2022-11-04 10:04:44
 */
public interface BbsMapper {
    /**
     * bbs_praise字段+1
     *
     * @param bbsId 帖子id
     * @return 字段更新是否成功
     */
    boolean updatePraise(@Param("bbsId") Long bbsId);

    /**
     * bbs_praise字段-1
     *
     * @param bbsId 帖子id
     * @return 字段更新是否成功
     */
    boolean cancelPraise(@Param("bbsId") Long bbsId);

    /**
     * bbs_no字段+1
     *
     * @param bbsId 帖子id
     * @return 字段更新是否成功
     */
    boolean updateNo(@Param("bbsId") Long bbsId);

    /**
     * bbs_no字段-1
     *
     * @param bbsId 帖子id
     * @return 字段更新是否成功
     */
    boolean cancelNo(@Param("bbsId") Long bbsId);

    /**
     * 更新帖子
     *
     * @param param 更新帖子对象
     * @return 影响行数
     */
    int updatePost(BbsEditParam param);

    /**
     * 获得发帖人
     *
     * @param bbsId 帖子id
     * @return 发帖人id
     */
    Long selectBbsOwner(Long bbsId);

    /**
     * 根据id删除帖子
     *
     * @param bbsId 帖子id
     * @return 影响行数
     */
    int deletePostById(Long bbsId);

    /**
     * 根据关键词搜索帖子 标题模糊查询
     *
     * @param searchKeys 关键词List
     * @return 帖子集合
     */
    List<Bbs> searchPostByKeys(List<String> searchKeys);
}
