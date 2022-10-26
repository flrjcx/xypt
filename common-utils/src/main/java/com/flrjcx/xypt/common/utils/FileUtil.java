package com.flrjcx.xypt.common.utils;

import org.springframework.web.multipart.MultipartFile;

/**
 * 图片上传工具类
 */
public class FileUtil {

    public static  long IMAGE_FILE_SIZE=1024 * 1024 * 2;

    // 图片允许的后缀扩展名
    public static String[] IMAGE_FILE_EXTD = new String[] { "jpg","jpeg","bmp","gif","png"};

    public static boolean isFileAllowed(String fileName) {
        for (String ext : IMAGE_FILE_EXTD) {
            if (ext.equals(fileName)) {
                return true;
            }
        }
        return false;
    }

    //判断文件大小不超过2M
    public static boolean fileSizeIsOK(MultipartFile multipartFile) {
        long size = multipartFile.getSize();
        if(size>IMAGE_FILE_SIZE){
            return false;
        }

        return true;
    }

}
