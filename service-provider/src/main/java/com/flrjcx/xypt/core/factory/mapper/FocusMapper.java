package com.flrjcx.xypt.core.factory.mapper;

import com.flrjcx.xypt.common.model.param.common.UserVo;
import com.flrjcx.xypt.common.model.param.focus.Attent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: code muxiaoming
 * @Date Created in 2022/10/20 20:49
 * @Description:
 * @Modified By:
 * @version: $
 */
public interface FocusMapper {

    /**
     * 查询粉丝与偶像的信息
     *
     * @param ids
     * @return
     */
    public List<UserVo> queryByArray(long[] ids);

    /**
     * 根据id查询用户信息,主要是查询fansNum与focusNum
     *
     * @param UserId userId
     * @return
     */
    UserVo getById(Long UserId);

    /**
     * 根据id更新用户信息(动态sql,只更新users对象中非空字段)
     * 如果user为粉丝,则focusNum不为空,fansNum为空
     * 如果user为偶像(被关注者)则反之
     *
     * @param user 用户
     * @return
     */
    int updateFocus(@Param("user") UserVo user);

    /**
     * 动态批量更新
     *
     * @param users
     * @return
     */
    int updateByList(List<UserVo> users);

    /**
     * 生成关注记录:关注者与被关注者
     *
     * @param param
     * @return
     */
    int addAttent(@Param("param") Attent param);
}
