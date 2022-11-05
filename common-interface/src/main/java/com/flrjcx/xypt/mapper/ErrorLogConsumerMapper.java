package com.flrjcx.xypt.mapper;

import com.flrjcx.xypt.common.model.domain.log.ErrorLog;

/**
 * @author malaka
 * @Description TODO
 * @date 2022/11/5 18:38
 */
public interface ErrorLogConsumerMapper {

    void insertErrorLog(ErrorLog errorLog);

}
