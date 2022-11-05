package com.flrjcx.xypt.common.model.domain.log;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.flrjcx.xypt.common.handler.filter.XssFilter;
import com.flrjcx.xypt.common.utils.HttpPoolUtils;
import com.flrjcx.xypt.common.utils.IPUtils;
import com.flrjcx.xypt.common.utils.RequestUtils;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.apache.catalina.authenticator.AuthenticatorBase;
import org.apache.catalina.connector.CoyoteAdapter;
import org.apache.catalina.core.ApplicationFilterChain;
import org.apache.catalina.valves.ErrorReportValve;
import org.apache.coyote.AbstractProcessorLight;
import org.apache.coyote.AbstractProtocol;
import org.apache.coyote.http11.Http11Processor;
import org.apache.tomcat.util.http.RequestUtil;
import org.apache.tomcat.util.net.NioEndpoint;
import org.apache.tomcat.util.net.SocketProcessorBase;
import org.apache.tomcat.util.threads.TaskThread;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.FormContentFilter;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.filter.RequestContextFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * @author malaka
 * @Description 异常日志实体类
 * @date 2022/11/4 21:11
 */
@Data
@ToString
public class ErrorLog implements Serializable {
    private static final long serialVersionUID = -1604602175836707866L;

    public ErrorLog() {}
    public ErrorLog(@NotNull Exception e, HttpServletRequest request) {
        // 异常信息
        this.errorName = e.getClass().getName();
        //  获取抛出异常的方法栈
        Throwable rootCause = ExceptionUtil.getRootCause(e);
        StackTraceElement rootStackTrace = rootCause.getStackTrace()[0];
        if (!Objects.isNull(rootStackTrace)) {
            this.errorClass = rootStackTrace.getClassName();
            this.errorLineNumber = rootStackTrace.getLineNumber();
            this.errorMethod = rootStackTrace.getMethodName();
        }

        this.errorMessage = ExceptionUtil.getMessage(e);

        //  全部方法栈
        StackTraceElement[] stackTraces = e.getStackTrace();
        if (!Objects.isNull(stackTraces)) {
            StringBuilder sb = new StringBuilder();
            for (StackTraceElement trace : stackTraces) {
                sb.append(trace).append(",").append("\n");
            }
            this.errorStackTrace = sb.toString();
        }

        // 请求信息
        if (!Objects.isNull(request)) {
            Map<String, Object> requestInfo = RequestUtils.getRequestInfo(request);
            this.errorParam = JSONObject.toJSONString(requestInfo);
            this.errorUri = request.getRequestURI();
            this.errorServiceIp = IPUtils.getLocalIP();
        }
    }

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "id自增，注意保持连续", name = "errorId")
    private Long errorId;

    @ApiModelProperty(value = "异常名", name = "errorName")
    private String errorName;

    @ApiModelProperty(value = "异常类", name = "errorClass")
    private String errorClass;

    @ApiModelProperty(value = "异常方法", name = "errorMethod")
    private String errorMethod;

    @ApiModelProperty(value = "异常行数", name = "errorLineNumber")
    private int errorLineNumber;

    @ApiModelProperty(value = "跟踪栈列表", name = "errorStackTrace")
    private String errorStackTrace;


    @ApiModelProperty(value = "异常消息", name = "errorMessage")
    private String errorMessage;

    @ApiModelProperty(value = "服务名", name = "errorServiceHost")
    private String errorServiceHost;

    @ApiModelProperty(value = "服务器ip", name = "errorServiceIp")
    private String errorServiceIp;

    @JsonSerialize
    @ApiModelProperty(value = "网络参数", name = "errorParam")
    private String errorParam;

    @ApiModelProperty(value = "操作地址", name = "errorUri")
    private String errorUri;

    @ApiModelProperty(value = "创建时间", name = "errorCreateTime")
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss",locale = "zh",timezone = "GMT+8")
    private Date errorCreateTime;


}
