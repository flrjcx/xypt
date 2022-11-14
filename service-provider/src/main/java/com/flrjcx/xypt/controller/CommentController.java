package com.flrjcx.xypt.controller;

import com.flrjcx.xypt.common.annotation.ApiRestController;
import com.flrjcx.xypt.common.annotation.OpenPage;
import com.flrjcx.xypt.common.annotation.Validation;
import com.flrjcx.xypt.common.enums.ResultCodeEnum;
import com.flrjcx.xypt.common.model.param.comment.Comment;
import com.flrjcx.xypt.common.model.result.ResponseData;
import com.flrjcx.xypt.common.utils.SensitiveWordUtils;
import com.flrjcx.xypt.common.utils.TokenService;
import com.flrjcx.xypt.common.utils.UserThreadLocal;
import com.flrjcx.xypt.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * 评论
 *
 * @author Yyyyyyy
 *
 */

@Api(tags = "评论")
@ApiRestController("/comment")
@Log4j2
public class CommentController {

    @Resource
    private CommentService commentService;


    @Validation
    @ApiOperation(value = "进行评论")
    @PostMapping("/post")
    public Comment save(@RequestBody Comment comment) {

        commentService.post(comment.getCommentBbsId(), comment.getCommentUserId(), comment.getCommentParentId(),
                comment.getLevel(), comment.getCommentContext(), comment.getCommentFloor());

        return comment;
    }

    @Validation
    @ApiOperation(value = "删除评论")
    @GetMapping("/del")
    public Boolean delete(@RequestParam("commentId") Long commentId) {
        return commentService.delete(commentId);
    }

    @OpenPage
    @Validation
    @ApiOperation(value = "查询全部评论")
    @GetMapping("/pageQueryAll")
    public ResponseData< List <Comment> > query() {
        return ResponseData.buildPageResponse(commentService.queryCommentsList());
    }



    /**
     * 用户评论点赞接口
     * 如果前端接收到错误信息, 不要更新点赞评论图标, 以免后续取消点赞评论出现bug
     * 点赞品论接口添加了事务处理, 有错误会直接回滚
     *
     * @return 统一响应
     */
    @Validation
    @ApiOperation("点赞评论")
    @PostMapping("/praiseComment")
    @Transactional(rollbackFor = Exception.class)
    public ResponseData praiseComment(@RequestParam(value = "commentId") Long commentId,
                                      @RequestParam(value = "bbsId") Long bbsId) {
        Long userId = UserThreadLocal.get().getUserId();
        ResultCodeEnum resultCodeEnum = commentService.praiseComment(commentId, userId, bbsId);
        return ResponseData.buildResponse(resultCodeEnum);
    }

    @Validation
    @ApiOperation("取消点赞评论")
    @PostMapping("/cancelPraiseComment")
    @Transactional(rollbackFor = Exception.class)
    public ResponseData cancelPraiseComment(@RequestParam(value = "commentId") Long commentId,
                                            @RequestParam(value = "bbsId") Long bbsId) {
        Long userId = UserThreadLocal.get().getUserId();
        ResultCodeEnum resultCodeEnum = commentService.cancelPraiseComment(commentId, userId, bbsId);
        return ResponseData.buildResponse(resultCodeEnum);
    }


    @ApiOperation(value = "测试")
    @GetMapping("/test")
    public String test() {

        return "success";
    }

}
