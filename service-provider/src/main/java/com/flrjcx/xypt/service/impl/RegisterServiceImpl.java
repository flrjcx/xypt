package com.flrjcx.xypt.service.impl;

import com.flrjcx.xypt.common.model.param.common.UserVo;
import com.flrjcx.xypt.mapper.LoginMapper;
import com.flrjcx.xypt.mapper.RegisterMapper;
import com.flrjcx.xypt.service.LoginService;
import com.flrjcx.xypt.service.RegisterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 注册实现类
 *
 * @author Flrjcx
 */
@Service
public class RegisterServiceImpl implements RegisterService {
    @Resource
    private RegisterMapper registerMapper;

}
