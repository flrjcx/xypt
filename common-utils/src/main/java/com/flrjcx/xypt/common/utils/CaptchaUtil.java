package com.flrjcx.xypt.common.utils;

import cn.hutool.core.lang.UUID;
import com.flrjcx.xypt.common.model.dto.VerifyCodeDto;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Encoder;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


/**
 * @author malaka
 * 验证码生成工具类
 */
@Component
public class CaptchaUtil {
    @Autowired
    private DefaultKaptcha producer;

    @Autowired
    private RedisCache redisCache;

    private final static int CACHE_TIME_MINUTES = 2;

    private final static String KEY_PRE = "VERIFICATION_CODE:";

    /**
     * 验证
     * @param uuid uuid唯一标识
     * @param code 输入验证码
     * @return 验证通过
     */
    public boolean verification(String uuid, String code) {
        String key = getKey(uuid);
        if (redisCache.verifyKey(key)) {
            // 获取缓存的验证码
            String cacheCode = redisCache.getCacheObject(key);
            // 删除验证码
            redisCache.deleteObject(key);
            // 验证输入
            return cacheCode.equalsIgnoreCase(code);
        }else {
            return false;
        }
    }


    /**
     * 生成 VerifyCodeDto对象
     * @return 返回验证码对象
     * @throws IOException 流异常
     */
    public VerifyCodeDto catchaImgCreator() throws IOException {
        //生成文字验证码
        String text = producer.createText();
        System.out.println(text);
        //生成文字对应的图片验证码
        BufferedImage image = producer.createImage(text);
        //将图片写出
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", outputStream);
        //对写出的字节数组进行Base64编码 ==> 用于传递8比特字节码
        BASE64Encoder encoder = new BASE64Encoder();
        //生成token
        String uuid = UUID.fastUUID().toString();
        createToken(uuid, text);
        VerifyCodeDto verifyCodeDto = new VerifyCodeDto();
        verifyCodeDto.setImg(encoder.encode(outputStream.toByteArray()));
        verifyCodeDto.setUuid(uuid);
        return verifyCodeDto;
    }

    /**
     * 创建token
     * @param uuid uuid
     * @param text 验证码
     */
    private void createToken(String uuid, String text) {
        String key = getKey(uuid);
        redisCache.setCacheObject(key, text, CACHE_TIME_MINUTES, TimeUnit.MINUTES);
    }


    /**
     * 使用uuid返回组装好的key
     * @param uuid uuid
     * @return key
     */
    private String getKey(String uuid) {
        return KEY_PRE + uuid;
    }
}