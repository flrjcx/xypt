package com.flrjcx.xypt.controller;

import com.flrjcx.xypt.common.annotation.ApiRestController;
import com.flrjcx.xypt.common.annotation.Validation;
import com.flrjcx.xypt.common.enums.ResultCodeEnum;
import com.flrjcx.xypt.common.enums.ValidStatusEnum;
import com.flrjcx.xypt.common.model.param.bbs.BbsReward;
import com.flrjcx.xypt.common.model.result.ResponseData;
import com.flrjcx.xypt.common.utils.UserThreadLocal;
import com.flrjcx.xypt.mapper.MyWalletMapper;
import com.flrjcx.xypt.service.BbsService;
import com.flrjcx.xypt.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * 与论坛表相关的操作
 *
 * @author : aftermath
 * @date : 2022-11-03 19:48:43
 */
@Api(tags = "论坛")
@ApiRestController("/bbs")
@Log4j2
public class BbsController {

    @Resource
    private BbsService bbsService;

    @Resource
    private MyWalletMapper myWalletMapper;

    @Resource
    CommentService commentService;

    /**
     * 用户点赞帖子接口
     * <p>
     * 如果前端接收到错误信息, 不要更新点赞图标, 以免后续取消点赞出现bug
     * 点/踩接口都加了事务, 有错误会直接回滚
     * 点/踩接口都加了事务, 有错误会直接回滚,
     * @return 统一响应
     */
    @Validation
    @ApiOperation("点赞")
    @PostMapping("/praise")
    public ResponseData praise(@RequestParam("bbsId") Long bbsId) {
        Long userId = UserThreadLocal.get().getUserId();
        ResultCodeEnum resultCodeEnum = bbsService.praise(bbsId, userId);
        return ResponseData.buildResponse(resultCodeEnum);
    }

    @Validation
    @ApiOperation("取消点赞")
    @PostMapping("/cancelPraise")
    public ResponseData cancelPraise(@RequestParam("bbsId") Long bbsId) {
        Long userId = UserThreadLocal.get().getUserId();
        ResultCodeEnum resultCodeEnum = bbsService.cancelPraise(bbsId, userId);
        return ResponseData.buildResponse(resultCodeEnum);
    }

    /**
     * 用户点踩帖子接口
     *
     * @return 统一响应
     */
    @Validation
    @ApiOperation("点踩")
    @PostMapping("/no")
    public ResponseData no(@RequestParam("bbsId") Long bbsId) {
        Long userId = UserThreadLocal.get().getUserId();
        ResultCodeEnum resultCodeEnum = bbsService.no(bbsId, userId);
        return ResponseData.buildResponse(resultCodeEnum);
    }

    @Validation
    @ApiOperation("取消点踩")
    @PostMapping("/cancelNo")
    public ResponseData cancelNo(@RequestParam("bbsId") Long bbsId) {
        Long userId = UserThreadLocal.get().getUserId();
        ResultCodeEnum resultCodeEnum = bbsService.cancelNo(bbsId, userId);
        return ResponseData.buildResponse(resultCodeEnum);
    }

    /**
     * 打赏
     *
     * @param reward
     * @return
     */
    @Validation
    @ApiOperation("打赏作者")
    @PostMapping("/reward")
    public ResponseData reward(@RequestBody BbsReward reward) {
        if (Objects.equals(reward.getMoney(), new BigDecimal(0))) {
            return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_REWARD_NULL);
        }
        if (myWalletMapper.checkMoney(reward.getMoney(),UserThreadLocal.get().getUserId())) {
            bbsService.reward(reward);
            return ResponseData.buildResponse();
        }
            return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_REWARD_MAX);
    }
}