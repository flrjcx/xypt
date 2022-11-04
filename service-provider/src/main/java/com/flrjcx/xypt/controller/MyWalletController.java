package com.flrjcx.xypt.controller;

import com.flrjcx.xypt.common.annotation.ApiRestController;
import com.flrjcx.xypt.common.annotation.Validation;
import com.flrjcx.xypt.common.enums.ResultCodeEnum;
import com.flrjcx.xypt.common.model.result.ResponseData;
import com.flrjcx.xypt.service.MyWalletService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * 我的钱包
 *
 * @author Flrjcx
 */
@Api(tags = "我的钱包")
@ApiRestController("/myWallet")
@Log4j2
public class MyWalletController {
    @Resource
    private MyWalletService myWalletService;

    /**
     * 充值
     *
     * @param money
     * @return
     */
    @GetMapping("/recharge")
    @Validation
    public ResponseData recharge(@RequestParam BigDecimal money,@RequestParam Long userId){
        myWalletService.recharge(money,userId);
        return ResponseData.buildResponse(ResultCodeEnum.SUCCESS_RECHARGE.getMessage()+money);
    }
}
