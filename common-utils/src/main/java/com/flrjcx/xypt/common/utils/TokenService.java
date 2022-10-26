package com.flrjcx.xypt.common.utils;

import com.alibaba.fastjson.JSON;
import com.flrjcx.xypt.common.enums.CacheTokenEnum;
import com.flrjcx.xypt.common.model.param.common.Manager;
import com.flrjcx.xypt.common.model.param.common.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author malaka
 */
@Component
public class TokenService {


    // 用户token
    public static final String USER_TAG = "CACHE_USER:";
    // 管理员
    public static final String MANAGER_TAG = "CACHE_MANAGER:";
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
    @Value("${token.managerExpireTime:30}")
    private int managerExpireTime;
    @Autowired
    private JWTUtils jwtUtils;
    @Autowired
    private RedisCache redisCache;

    public String getHeader() {
        return header;
    }


    /**
     * 通过枚举创建token缓存
     */
    public String createToken(CacheTokenEnum tokenEnum, Object data) {
        String token = UUID.randomUUID().toString();
        String key = tokenEnum.getKey() + token;
        Long cacheTime = tokenEnum.getCacheTime();
        TimeUnit timeUnit = tokenEnum.getTimeUnit();
        redisCache.setCacheObject(key, data, cacheTime, timeUnit);
        return token;
    }

    /**
     * 创建token缓存
     */
    public String createToken(Users users) {
        String token = jwtUtils.createToken(users.getUserId());
        //CACHE_USER:eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NjY1MjI2MTMsInVzZXJJZCI6NjQsImlhdCI6MTY2NjQzNjIxM30.EpaSpXP2EriwHugC_51tvpaLA9I5JgBBFdLWjxtkNY8:users{}
        redisCache.setCacheObject(getUserToken(token), JSON.toJSONString(users), userExpireTime, TimeUnit.MINUTES);
        return token;
    }

    public String createToken(Manager manager) {
        String token = jwtUtils.createToken(manager.getManagerId());
        redisCache.setCacheObject(getManagerToken((token)), JSON.toJSONString(manager), managerExpireTime, TimeUnit.MINUTES);
        return token;
    }

    /**
     * 删除用户缓存
     *
     * @param token
     */
    public void removeUserToken(String token) {
        redisCache.deleteObject(getUserToken(token));
    }

    public void removeManagerToken(String token) {
        redisCache.deleteObject(getManagerToken(token));
    }

    public<T> T getCache(String key) {
        return redisCache.getCacheObject(key);
    }

    /**
     * 获取用户缓存
     *
     * @param token
     * @return
     */
    public Users getUserCache(String token) {
        String userVoJson = redisCache.getCacheObject(getUserToken(token));
        Users users = JSON.parseObject(userVoJson, Users.class);
        return users;
    }

    public Manager getManagerCache(String token) {
        String managerVoJson = redisCache.getCacheObject(getManagerToken(token));
        Manager manager = JSON.parseObject(managerVoJson, Manager.class);
        return manager;
    }

    public void updateCache(String token, Users users) {
        redisCache.setCacheObject(getUserToken(token), users);
    }

    public void updateCache(String token, Manager manager) {
        redisCache.setCacheObject(getManagerToken(token), manager);
    }

    private String getUserToken(String s) {
        return getToken(USER_TAG, s);
    }

    private String getManagerToken(String s) {
        return getToken(MANAGER_TAG, s);
    }

    private String getToken(String pre, String s) {
        return pre + s;
    }


    public void removeToken(String key) {
        redisCache.deleteObject(key);
    }
}
