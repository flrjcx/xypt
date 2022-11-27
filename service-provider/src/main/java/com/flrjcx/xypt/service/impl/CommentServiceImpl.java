package com.flrjcx.xypt.service.impl;

import com.flrjcx.xypt.common.enums.ResultCodeEnum;
import com.flrjcx.xypt.common.exception.WebServiceEnumException;
import com.flrjcx.xypt.common.model.param.comment.Comment;
import com.flrjcx.xypt.common.model.result.ResponseData;
import com.flrjcx.xypt.mapper.CommentMapper;
import com.flrjcx.xypt.mapper.CommentPraiseMapper;
import com.flrjcx.xypt.service.CommentService;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yyyyyyy
 */

@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Resource
    private CommentPraiseMapper commentPraiseMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseData < Comment > post(long bbsId, long userId,long parentId,
                                         int level, String context, int commentFloor) {
        ResponseData<Comment> response = new ResponseData <>();

        if (bbsId == 0 || userId == 0 || StringUtils.isEmpty(context) || level == 0) {
            response.setCode(500);
            response.setMessage("BbsId, userId, level, context不能为空");
        }

        String body = StringEscapeUtils.escapeHtml(context);

        Comment comment = new Comment();
        comment.setCommentBbsId(bbsId);
        comment.setCommentUserId(userId);
        comment.setLevel(level);
        comment.setCommentFloor(commentFloor);
        comment.setCommentContext(body);
        comment.setCommentParentId(parentId);
        commentMapper.insert(comment);

        response.setData(comment);

        return response;
    }


    @Override
    public List<Comment> query(String bbsId) {

//        查询所有的评论记录包含回复的
        List < Comment > comments = commentMapper.findByBbsId(bbsId);
//        构建map结构
        Map<Long, Comment> commentMap = new HashMap <>();
//        初始化一个虚拟根节点，0可以对应的是所有一级评论的父亲
        commentMap.put(0L, new Comment());
//        把所有的评论转化为map数据
        comments.forEach(comment -> commentMap.put(comment.getCommentId(), comment));
//        再次遍历评论数据
        comments.forEach(comment -> {
//            得到父评论
            Comment parent = commentMap.get(comment.getCommentParentId());
            if (parent != null) {
//                初始化 children变量
                if (parent.getChildren() == null) {
                    parent.setChildren(new ArrayList <>());
                }
//                在父评论里添加回复数据
                parent.getChildren().add(comment);
            }
        });

//        得到所有的一级评论
        List<Comment> data = commentMap.get(0L).getChildren();

        return data;
    }

    @Override
    public List < Comment > queryCommentsList() {
        return commentMapper.findAll();
    }


    @Override
    public Boolean delete(String bbsId) {
        return commentMapper.delete(bbsId) > 0;
    }


    /**
     * 先查询comment表中是否有对应commentId
     * if 有 -> 往comment_praise填入数据 返回成功信息
     * else 返回错误信息
     *
     * @param commentId 评论id
     * @param userId 用户id
     * @param bbsId 帖子id
     * @return
     */
    @Override
    public ResultCodeEnum praiseComment(Long commentId, Long userId, Long bbsId) {
        if (!commentMapper.updateComment(commentId, bbsId, userId)) {
            throw WebServiceEnumException.buildResponseData(ResultCodeEnum.ERROR_CODE_COMMENT_UPDATE_ERROR);
        }
        if (!commentPraiseMapper.insertPraiseComment(commentId, userId)) {
            throw WebServiceEnumException.buildResponseData(ResultCodeEnum.ERROR_CODE_COMMENT_PRAISE_INSERT_ERROR);
        }
        return ResultCodeEnum.SUCCESS;
    }

    /**
     * 先查询comment_praise表中是否有对应userId
     * if 有 -> 删除comment_praise表中相应字段, 同时更新comment表中点赞数量
     * else 返回错误信息
     *
     * @param commentId 评论id
     * @param userId 用户id
     * @param bbsId 帖子id
     * @return
     */
    @Override
    public ResultCodeEnum cancelPraiseComment(Long commentId, Long userId, Long bbsId) {
        if (!commentPraiseMapper.deletePraiseComment(commentId, userId)) {
            throw WebServiceEnumException.buildResponseData(ResultCodeEnum.ERROR_CODE_COMMENT_PRAISE_DELETE_ERROR);
        }
        if (!commentMapper.cancelComment(commentId, bbsId, userId)) {
            throw WebServiceEnumException.buildResponseData(ResultCodeEnum.ERROR_CODE_COMMENT_UPDATE_ERROR);
        }
        return ResultCodeEnum.SUCCESS;
    }


}
