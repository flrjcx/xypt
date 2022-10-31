package com.flrjcx.xypt.mapper;

import com.flrjcx.xypt.common.annotation.OpenPage;
import com.flrjcx.xypt.common.model.result.log.InterfaceLogResult;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 日志服务
 *
 * @author Flrjcx
 */
public interface LogMapper {
    /**
     * 获取访问日志列表
     *
     * @param beforeTime
     * @param afterTime
     * @return
     */
    @OpenPage
    List<InterfaceLogResult> getApiLogList(@Param("beforeTime") Date beforeTime, @Param("afterTime") Date afterTime);
}
