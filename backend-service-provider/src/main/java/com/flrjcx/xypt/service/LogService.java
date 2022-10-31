package com.flrjcx.xypt.service;


import com.flrjcx.xypt.common.model.result.log.InterfaceLogResult;

import java.util.List;

/**
 * api接口访问日志
 *
 * @author Flrjcx
 */
public interface LogService {
    /**
     * 获取Api访问日志列表
     *
     * @return
     */
    List<InterfaceLogResult> getApiLogList();
}
