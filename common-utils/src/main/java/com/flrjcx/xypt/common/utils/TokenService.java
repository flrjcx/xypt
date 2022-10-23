package com.flrjcx.xypt.common.utils;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.flrjcx.xypt.common.model.param.common.ManagerVo;
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

    @Value("${token.userExpireTime:1440}")
    private int managerExpireTime;

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
    public static final String MANAGER_TAG = "CACHE_MANAGER:";


    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private RedisCache redisCache;

    /**
     * 创建token缓存
     */
    public String createToken(UserVo userVo) {
        String token = jwtUtils.createToken(userVo.getUserId());
        //CACHE_USER:eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NjY1MjI2MTMsInVzZXJJZCI6NjQsImlhdCI6MTY2NjQzNjIxM30.EpaSpXP2EriwHugC_51tvpaLA9I5JgBBFdLWjxtkNY8:userVo{}
        redisCache.setCacheObject(getUserToken(token), JSON.toJSONString(userVo), userExpireTime, TimeUnit.MINUTES);
        return token;
    }

    public String createToken(ManagerVo managerVo) {
        String token = jwtUtils.createToken(managerVo.getManagerId());
        redisCache.setCacheObject(getManagerToken((token)), JSON.toJSONString(managerVo), managerExpireTime, TimeUnit.MINUTES);
        return token;
    }

    /**
     * 删除用户缓存
     * @param token
     */
    public void removeUserToken(String token) {
        redisCache.deleteObject(getUserToken(token));
    }
    public void removeManagerToken(String token) {
        redisCache.deleteObject(getManagerToken(token));
    }

    /**
     * 获取用户缓存
     * @param token
     * @return
     */
    public UserVo getUserCache(String token) {
        String userVoJson = redisCache.getCacheObject(getUserToken(token));
        UserVo userVo = JSON.parseObject(userVoJson, UserVo.class);
        return userVo;
    }

    public ManagerVo getManagerCache(String token) {
        String managerVoJson = redisCache.getCacheObject(getManagerToken(token));
        ManagerVo managerVo = JSON.parseObject(managerVoJson, ManagerVo.class);
        return managerVo;
    }

    public void updateCache(String token, UserVo userVo) {
        redisCache.setCacheObject(getUserToken(token), userVo);
    }

    public void updateCache(String token, ManagerVo managerVo) {
        redisCache.setCacheObject(getUserToken(token), managerVo);
    }

    private String getUserToken(String s) {
        return getToken(USER_TAG , s);
    }

    private String getManagerToken(String s) {
        return getToken(MANAGER_TAG , s);
    }

    private String getToken(String pre, String s) {
        return pre + s;
    }



}
