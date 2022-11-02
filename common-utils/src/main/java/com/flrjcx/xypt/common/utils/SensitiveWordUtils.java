package com.flrjcx.xypt.common.utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.dfa.FoundWord;
import cn.hutool.dfa.SensitiveUtil;
import com.flrjcx.xypt.common.config.SensitiveWordConfig;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URL;
import java.util.List;

/**
 * @Author: aftermath
 * @Date: 2022-11-02 13:53:54
 * @Desc:
 */
@Component
public class SensitiveWordUtils {
    /**
     * 敏感词过滤, 用'*'替换
     * 目前只支持中文, 英文词库没找到合适的, 暂时搁置
     *
     * @param text 需要检查的文本
     * @return 返回替换掉敏感词的文本
     */
    public static String sensitiveWordFiltering(String text) {
        List<FoundWord> matchAll = SensitiveUtil.getFoundAllSensitive(text, false, false);
        if (matchAll.size() > 0) {
            for (FoundWord match : matchAll) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < StrUtil.length(match.getFoundWord()); i++) {
                    sb.append("*");
                }
                text = StrUtil.replace(text, match.getFoundWord(), sb.toString());
            }
        }
        return text;
    }
}
