package com.flrjcx.xypt.log.controller;

import com.flrjcx.xypt.common.annotation.ApiRestController;
import com.flrjcx.xypt.common.annotation.Validation;
import com.flrjcx.xypt.common.model.result.InterfaceLogResult;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 所有接口的访问日志
 *
 * @author Flrjcx
 */
@Api(tags = "接口访问日志")
@ApiRestController("/api/log")
@Log4j2
public class InterfaceLogController {
    /**
     * 获取真实ip地址,不返回内网地址
     *
     * @param request
     * @return
     */
    @GetMapping("/interfaceLog")
    public InterfaceLogResult getIpAddr(HttpServletRequest request) {
        String ip = null;
        InterfaceLogResult interfaceLogResult = new InterfaceLogResult();
        try {
            ip = request.getHeader("x-forwarded-for");
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
                if (ip.equals("127.0.0.1")) {
                    // 根据网卡取本机配置的IP
                    InetAddress inet = null;
                    try {
                        inet = InetAddress.getLocalHost();
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    }
                    ip = inet.getHostAddress();
                }
            }
            // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
            if (ip != null && ip.length() > 15) { // "***.***.***.***".length()
                // = 15
                if (ip.indexOf(",") > 0) {
                    ip = ip.substring(0, ip.indexOf(","));
                }
            }
        } catch (Exception e) {
            ip="";
        }

        String uri = request.getRequestURI();
        int port = request.getServerPort();
        interfaceLogResult.setIp(ip);
        interfaceLogResult.setUri(uri);
        interfaceLogResult.setPort(port);

        return interfaceLogResult;
    }
}
