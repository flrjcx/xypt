package com.flrjcx.xypt.controller;

import com.flrjcx.xypt.common.annotation.ApiRestController;
import com.flrjcx.xypt.common.annotation.Validation;
import com.flrjcx.xypt.common.enums.ResultCodeEnum;
import com.flrjcx.xypt.common.model.result.ResponseData;
import com.flrjcx.xypt.service.BbsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

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
    BbsService bbsService;

    /**
     * 用户点赞帖子接口
     *
     * 如果前端接收到错误信息, 不要更新点赞图标, 以免后续取消点赞出现bug
     * @return 统一响应
     */
    @Validation
    @ApiOperation("点赞")
    @PostMapping("/praise")
    @Transactional(rollbackFor = Exception.class)
    public ResponseData praise(@RequestParam("bbsId") Long bbsId,
                               @RequestParam("userId") Long userId) {
        if (!bbsService.praise(bbsId, userId)) {
            return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_CODE_PRAISE_ERROR);
        }
        return ResponseData.buildSuccess();
    }

    @Validation
    @ApiOperation("取消点赞")
    @PostMapping("/cancelPraise")
    @Transactional(rollbackFor = Exception.class)
    public ResponseData cancelPraise(@RequestParam("bbsId") Long bbsId,
                                     @RequestParam("userId") Long userId) {
        if (!bbsService.cancelPraise(bbsId, userId)) {
            return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_CODE_CANCEL_PRAISE_ERROR);
        }
        return ResponseData.buildSuccess();
    }

    /**
     * 用户点踩帖子接口
     *
     * @return 统一响应
     */
    @Validation
    @ApiOperation("点踩")
    @PostMapping("/no")
    @Transactional(rollbackFor = Exception.class)
    public ResponseData no(@RequestParam("bbsId") Long bbsId,
                           @RequestParam("userId") Long userId) {
        if (!bbsService.no(bbsId, userId)) {
            return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_CODE_NO_ERROR);
        }
        return ResponseData.buildSuccess();
    }

    @Validation
    @ApiOperation("取消点踩")
    @PostMapping("/cancelNo")
    @Transactional(rollbackFor = Exception.class)
    public ResponseData cancelNo(@RequestParam("bbsId") Long bbsId,
                                 @RequestParam("userId") Long userId) {
        if (!bbsService.cancelNo(bbsId, userId)) {
            return ResponseData.buildErrorResponse(ResultCodeEnum.ERROR_CODE_CANCEL_NO_ERROR);
        }
        return ResponseData.buildSuccess();
    }
}
