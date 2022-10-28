package com.flrjcx.xypt.log.controller;

import com.flrjcx.xypt.common.annotation.ApiRestController;
import com.flrjcx.xypt.common.utils.QiniuUtils;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 错误日志
 *
 * @author Flrjcx
 */
@Api(tags = "错误日志")
@ApiRestController("/api/log")
@Log4j2
public class ErrorLogController {



}
