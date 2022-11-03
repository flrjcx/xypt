package com.flrjcx.xypt.service;

import com.flrjcx.xypt.common.model.param.comment.Comment;
import com.flrjcx.xypt.common.model.result.ResponseData;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 *
 * 评论服务
 *
 * @author Yyyyyyy
 *
 */

public interface CommentService {

    /**
     * 发布评论
     *
     * @param bbsId 帖子id
     * @param userId 用户id
     * @param parentId 父评论
     * @param level 评论等级
     * @param context 评论内容
     * @param commentFloor 评论楼层
     * @return
     */
    ResponseData < Comment > post(long bbsId, long userId, long parentId, int level,
                                  String context, int commentFloor, long commentParentId);

    Boolean delete(@RequestParam("id") Long commentId);

    /**
     * 查询评论
     *
     * @param bbsId
     * @return
     */
    ResponseData< List<Comment>> query(String bbsId);

    List<Comment> queryCommentsList();

}
