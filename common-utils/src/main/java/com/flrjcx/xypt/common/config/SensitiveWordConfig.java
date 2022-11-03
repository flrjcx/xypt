package com.flrjcx.xypt.common.config;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.dfa.FoundWord;
import cn.hutool.dfa.SensitiveUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URL;
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
    public void afterPropertiesSet() {
        URL path = ResourceUtil.getResource("dict/harmonious_dictionary/chinese_dictionary.txt");
        File file = FileUtil.file(path);
        FileReader reader = new FileReader(file);
        SensitiveUtil.init(reader.readLines());
        logger.info("initialize bean:{}", SensitiveWordConfig.class.getName());
    }

}