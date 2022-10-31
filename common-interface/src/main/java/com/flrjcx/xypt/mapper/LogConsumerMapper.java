package com.flrjcx.xypt.mapper;


import com.flrjcx.xypt.common.model.result.log.InterfaceLogResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 消费者mapper
 *
 * @author Flrjcx
 */
public interface LogConsumerMapper {
    /**
     * 将kafka数据写入数据库(apiLog)
     *
     * @param logResult
     */
    void insertApiMsg(@Param("logResult")InterfaceLogResult logResult);
}
