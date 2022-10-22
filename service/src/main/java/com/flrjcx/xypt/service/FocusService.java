package com.flrjcx.xypt.service;

/**
 * @Author: code muxiaoming
 * @Date Created in 2022/10/19 21:09
 * @Description:
 * @Modified By:
 * @version: $
 */
public interface FocusService {

    /**
     * 粉丝关注
     *
     * @param ids ids[0] fansId
     *            ids[1] idolId
     */
    boolean focus(long[] ids);
}
