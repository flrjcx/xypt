package com.flrjcx.xypt.service.impl;

import com.flrjcx.xypt.common.model.dto.UserInfoDto;
import com.flrjcx.xypt.common.model.param.common.Users;
import com.flrjcx.xypt.common.model.param.personal_center.RealNameParam;
import com.flrjcx.xypt.common.utils.EmailSendUtils;
import com.flrjcx.xypt.common.utils.RedisCache;
import com.flrjcx.xypt.common.utils.ValidateCodeUtils;
import com.flrjcx.xypt.mapper.PersonalCenterMapper;
import com.flrjcx.xypt.service.PersonalCenterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * 个人中心
 *
 * @author Flrjcx
 */
@Service
@Slf4j
public class PersonalCenterImpl implements PersonalCenterService {
    public static final String MAIL_PREFIX = "xypt:PersonalCenter:accountDeleteMail";

    @Resource
    private PersonalCenterMapper personalCenterMapper;
    @Resource
    private EmailSendUtils emailSendUtils;
    @Resource
    private RedisCache redisCache;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void realUser(RealNameParam realNameParam) {
        personalCenterMapper.realUser(realNameParam);
    }

    @Override
    public Integer getUserFansNum(Long userId) {
        return personalCenterMapper.getFansNum(userId);
    }

    @Override
    public Integer realRegisterUserCount(Long realRegisterUserId) {
        return personalCenterMapper.countByUserId(realRegisterUserId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)//添加事务
    public void updateUserFace(String picPath, Long userId) {

        personalCenterMapper.changeHeadPortrait(picPath,userId);

    }

    @Override
    public UserInfoDto getUserInfo(Long userId) {
        Users user = personalCenterMapper.getUserById(userId);
        UserInfoDto userInfo = new UserInfoDto();
        BeanUtils.copyProperties(user, userInfo);
        return userInfo;
    }

    @Override
    public boolean sendAccountDeleteMail(Long userId, String email) {
        Integer validateCode = ValidateCodeUtils.generateValidateCode(6);
        String mailPrefix = MAIL_PREFIX + ":" + userId;
        boolean flag = true;
        //邮件标题
        String subject = "账户注销操作验证码";
        //邮件内容
        String body = "您正在进行注销此账户操作，验证码有效期五分钟，请确认无误后填入：";
        try {
            //将验证码存入redis缓存，有效期5分钟
            redisCache.setCacheObject(mailPrefix, validateCode, 5, TimeUnit.MINUTES);
            emailSendUtils.sendMail(email, subject, body, validateCode);
            log.info("向用户ID{}发送账户注销验证码邮件成功，邮箱为{}，验证码为{}", userId, email, validateCode);
        } catch (Exception exception) {
            flag = false;
            //清楚缓存中的验证码
            redisCache.deleteObject(mailPrefix);
            log.info("向用户ID{}发送账户注销验证码邮件失败，邮箱为{}，验证码为{}", userId, email, validateCode);
        }
        return flag;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deletedAccount(Long userId, String validateCode) {
        String validateCode_cache = redisCache.getCacheObject(MAIL_PREFIX + ":" + userId).toString();
        if (validateCode_cache.equals(validateCode)){
            int count = personalCenterMapper.deletedAccount(userId);
            int result = personalCenterMapper.deletedRealAccount(userId);
            if (count == 1 && result == 1){
                return true;
            }
        }
        return false;
    }
}
