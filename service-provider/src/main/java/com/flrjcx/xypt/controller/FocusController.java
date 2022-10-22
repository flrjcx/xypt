package com.flrjcx.xypt.controller;

import com.flrjcx.xypt.common.annotation.ApiRestController;
import com.flrjcx.xypt.common.enums.ResultCodeEnum;
import com.flrjcx.xypt.common.model.result.ResponseData;
import com.flrjcx.xypt.service.FocusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

/**
 * @Author: code muxiaoming
 * @Date Created in 2022/10/20 21:54
 * @Description:
 * @Modified By:
 * @version: $
 */
@Api(tags = "关注模块")
@ApiRestController("/api/client/focus")
@Log4j2
public class FocusController {

    @Resource
    private FocusService focusService;

    @ApiOperation("用户关注")
    @PostMapping
    //@UserValidation
    //@RequestParam(value="goodsId",defaultValue=“0”)
    // 需要有默认值required = true(默认)
    public ResponseData focus(@RequestBody long[] ids) {
        try {
            boolean focus = focusService.focus(ids);
            return ResponseData.buildResponse();
        } catch (Exception e) {
            log.error("/focus error {}", e);
            return ResponseData.buildErrorResponse(ResultCodeEnum.CODE_SYSTEM_ERROR.getCode(), e.getMessage());
        }
    }
}
