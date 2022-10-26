package com.flrjcx.xypt.common.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author malaka
 * @Description ip地址工具类
 * @date 2022/10/26 0:48
 */
public class IPUtils {

    /**
     * 获取本机ip
     * @return
     */
    public static String getLocalIP() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }

}
