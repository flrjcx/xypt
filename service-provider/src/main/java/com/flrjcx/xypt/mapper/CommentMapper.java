package com.flrjcx.xypt.mapper;

import com.flrjcx.xypt.common.model.param.comment.Comment;
import feign.Param;

import java.util.List;

/**
 * @author Yyyyyyy
 */
public interface CommentMapper {

    /**
     * 添加评论
     * @param comment
     * @return
     */
    int insert(Comment comment);

    /**
     * 查询全部评论
     * @return
     */
    List<Comment> findAll();

    /**
     * 根据评论id查询评论
     * @param bbsId
     * @return
     */
    List<Comment> findByBbsId(@Param("bbsId") String bbsId);

    /**
     * 删除评论
     * @param commentId
     * @return
     */
    int delete(@Param("commentId") long commentId);

}
