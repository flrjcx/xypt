package com.flrjcx.xypt.mapper;

import com.flrjcx.xypt.common.model.param.comment.Comment;
import feign.Param;

import java.util.List;

/**
 * @author Yyyyyyy
 */
public interface CommentMapper {

    int insert(Comment comment);

    int batchAdd(@Param("list") List<Comment> userDOs);

    List<Comment> findAll();

    List<Comment> findByBbsId(@Param("bbsId") String bbsId);

    List<Comment> findByUserIds(@Param("userIds") List<Long> ids);

    int delete(@Param("commentId") long commentId);

}
