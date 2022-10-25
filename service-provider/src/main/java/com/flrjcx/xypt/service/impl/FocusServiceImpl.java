package com.flrjcx.xypt.service.impl;

import com.flrjcx.xypt.common.model.param.common.Users;
import com.flrjcx.xypt.common.model.param.focus.Attent;
import com.flrjcx.xypt.common.model.param.focus.UserPartList;
import com.flrjcx.xypt.mapper.FocusMapper;
import com.flrjcx.xypt.service.FocusService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: code muxiaoming
 * @Date Created in 2022/10/19 21:12
 * @Description:
 * @Modified By:
 * @version: $
 */
@Service
public class FocusServiceImpl implements FocusService {

    @Resource
    private FocusMapper focusMapper;

    /**
     * 粉丝关注
     *
     * @param ids
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean focus(long[] ids) {
        //粉丝即关注者 focus_num++
        //Users fansInfo = focusMapper.getById(fansId);
        List<Users> list = focusMapper.queryByArray(ids);
        Users fans = new Users();
        Users idol = new Users();
        //fansId和idolId是按前端传参的顺序,没有变化
        fans.setUserId(ids[0]);
        idol.setUserId(ids[1]);
        //为了减少调用getById的次数,经测试,查询结果不是按照id数组顺序
        //而是先查询id号小的,例如:64与919,919与64查询结果相等
        if (list.get(0).getUserId().equals(ids[0])) {
            fans.setFocusNum(list.get(0).getFocusNum() + 1);
            idol.setFansNum(list.get(1).getFansNum() + 1);
        } else {
            fans.setFocusNum(list.get(1).getFocusNum() + 1);
            idol.setFansNum(list.get(0).getFansNum() + 1);
        }
        /*
        ArrayList<Users> users = new ArrayList<>();
        users.add(fans);
        users.add(idol);
        //减少调用updateById次数
        //过于异想天开,动态批量更新,也许鱼和熊掌不可兼得
        int i = focusMapper.updateByList(users);*/

        int count = focusMapper.updateFocus(fans);
        int count1 = focusMapper.updateFocus(idol);

        Attent attent = new Attent();
        //fansId
        attent.setUserId(ids[0]);
        //idolId
        attent.setAttentUserId(ids[1]);
        //表中会更新时间
        //attent.setCreateTime(new Date());
        int count2 = focusMapper.addAttent(attent);
        if (count > 0 && count1 > 0 && count2 > 0) {
            return true;
        }
        return false;
    }

    /**
     * 查询用户的关注列表
     *
     * @param id
     * @return
     */
    @Override
    public List<UserPartList> focusList(Long id) {
        List<Long> userIdList = focusMapper.idolIdList(id);
        return focusMapper.getUserPartList(userIdList);
    }

    /**
     * 查询用户的粉丝列表
     *
     * @param id
     * @return
     */
    @Override
    public List<UserPartList> fansList(Long id) {
        List<Long> fansIdList = focusMapper.fansIdList(id);
        return focusMapper.getUserPartList(fansIdList);
    }
}
