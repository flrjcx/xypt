package com.flrjcx.xypt.common.config;

import cn.hutool.dfa.SensitiveUtil;
import org.apache.commons.codec.Charsets;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author: aftermath
 * @Date: 2022-11-02 13:42:37
 * @Desc:
 */
@Component
public class SensitiveWordConfig implements InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(SensitiveWordConfig.class);

    /**
     * 初始化敏感词汇
     */
    @Override
    public void afterPropertiesSet() throws IOException {
        InputStream in = getClass().getClassLoader().getResourceAsStream("dict/harmonious_dictionary/chinese_dictionary.txt");
        List<String> list = null;
        if (in != null) {
            list = IOUtils.readLines(in, Charsets.toCharset("UTF-8"));
            in.close();
            System.out.println("SensitiveWordConfig read lines successfully!");
        } else {
            System.out.println("SensitiveWordConfig real lines failed");
        }
        SensitiveUtil.init(list);
        logger.info("initialize bean:{}", SensitiveWordConfig.class.getName());
    }

}