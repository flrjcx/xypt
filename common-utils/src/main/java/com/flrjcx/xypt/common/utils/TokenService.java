package com.flrjcx.xypt.common.utils;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.flrjcx.xypt.common.model.param.common.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author malaka
 */
@Component
public class TokenService {

    @Autowired
    private JWTUtils jwtUtils;

    /**
     * 令牌自定义标识
     */
    @Value("${token.header:Authorization}")
    private String header;

    /**
     * 令牌超时时间
     */
    @Value("${token.userExpireTime:1440}")
    private int userExpireTime;

    public String getHeader() {
        return header;
    }

    /**
     * 1秒
     */
    private static final long MILLIS_SECOND = 1000;
    /**
     * 1分钟
     */
    private static final long MILLIS_MINUTE = 60 * MILLIS_SECOND;
    /**
     * 1天
     */
    private static final long MILLIS_DAY = 24 * 60 * MILLIS_MINUTE;

    // 用户token
    public static final String USER_TAG = "CACHE_USER:";
    // 管理员
    public static final String ADMIN_TAG = "CACHE_ADMIN:";

    @Autowired
    private RedisCache redisCache;

    /**
     * 创建用户token缓存
     */
    public String createUserToken(UserVo userVo) {
        String token = jwtUtils.createToken(userVo.getUserId());
        redisCache.setCacheObject(getUserToken(token), JSON.toJSONString(userVo), userExpireTime, TimeUnit.MINUTES);
        return token;
    }

    /**
     * 删除用户缓存
     * @param token
     */
    public void removeUserToken(String token) {
        redisCache.deleteObject(getUserToken(token));
    }

    public UserVo getUserCache(String token) {
        String userVoJson = redisCache.getCacheObject(getUserToken(token));
        UserVo userVo = JSON.parseObject(userVoJson, UserVo.class);
        return userVo;
    }

    private String getUserToken(String s) {
        return getToken(USER_TAG , s);
    }

    private String getAdminToken(String s) {
        return getToken(ADMIN_TAG , s);
    }

    private String getToken(String pre, String s) {
        return pre + s;
    }



}
