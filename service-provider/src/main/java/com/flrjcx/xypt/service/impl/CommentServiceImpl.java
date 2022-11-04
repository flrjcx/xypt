package com.flrjcx.xypt.service.impl;

import com.flrjcx.xypt.common.model.param.comment.Comment;
import com.flrjcx.xypt.common.model.result.ResponseData;
import com.flrjcx.xypt.mapper.CommentMapper;
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
    public ResponseData < List<Comment> > query(String bbsId) {

        ResponseData< List<Comment> > response = new ResponseData <>();
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

        response.setData(data);

        return response;
    }

    @Override
    public List < Comment > queryCommentsList() {
        return commentMapper.findAll();
    }

    @Override
    public Boolean delete(Long commentId) {
        return commentMapper.delete(commentId) > 0;
    }
}
