package com.flrjcx.xypt.controller;

import com.flrjcx.xypt.common.annotation.ApiRestController;
import com.flrjcx.xypt.common.model.param.email.EmailSendParam;
import com.flrjcx.xypt.common.model.result.ResponseData;
import com.flrjcx.xypt.service.EmailService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * @author malaka
 * @Description TODO
 * @date 2022/10/26 0:43
 */
@Api(tags = "邮箱验证")
@ApiRestController("/api/email")
@Log4j2
public class EmailController {

    @Resource
    private EmailService emailService;

    @PostMapping("/sendRegister")
    public ResponseData sendRegister(@RequestBody EmailSendParam param) {
        return emailService.sendRegister(param);
    }

    @GetMapping("/verificationRegister")
    public ResponseData verificationRegister(@RequestParam("token") String token) {
        return emailService.verificationRegister(token);
    }

}
