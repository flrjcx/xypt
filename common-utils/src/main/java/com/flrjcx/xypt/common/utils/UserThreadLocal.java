package com.flrjcx.xypt.common.utils;

import com.flrjcx.xypt.common.model.param.common.UserVo;

public class UserThreadLocal {

    private UserThreadLocal(){}

    private static final  ThreadLocal<UserVo> LOCAL = new ThreadLocal<>();

    public static void put(UserVo userVo) {
        LOCAL.set(userVo);
    }

    public static void remove() {
        LOCAL.remove();
    }


}
