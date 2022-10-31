package com.flrjcx.xypt.service.impl;

import com.flrjcx.xypt.common.model.result.log.InterfaceLogResult;
import com.flrjcx.xypt.mapper.LogMapper;
import com.flrjcx.xypt.service.LogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * api接口访问日志
 *
 * @author Flrjcx
 */
@Service
public class LogServiceImpl implements LogService {

    @Resource
    private LogMapper LogMapper;
    /**
     * 获取Api访问日志列表
     *
     * @return
     */
    @Override
    public List<InterfaceLogResult> getApiLogList() {
//        Mapper.getApiLogList();
        return null;
    }
}
