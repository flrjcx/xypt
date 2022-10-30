package com.flrjcx.xypt.service;

import com.flrjcx.xypt.common.model.param.focus.UserPartList;

import java.util.List;

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

    /**
     * 查询用户的关注列表
     *
     * @param id
     * @return
     */
    List<UserPartList> focusList(Long id);

    /**
     * 查询用户的粉丝列表
     *
     * @param id
     * @return
     */
    List<UserPartList> fansList(Long id);
}
