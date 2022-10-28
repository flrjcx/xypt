package com.flrjcx.xypt.common.utils;

import com.flrjcx.xypt.common.enums.ResultCodeEnum;
import com.flrjcx.xypt.common.exception.WebServiceEnumException;
import com.qiniu.common.QiniuException;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * 七牛云工具类
 */
@Component
public class QiniuUtils {
    @Value("${qiniu.accessKey}")
    private static String accessKey;

    @Value("${qiniu.accessSecretKey}")
    private static String accessSecretKey;

    @Value("${qiniu.bucket}")
    private static String bucket;

    @Value("${qiniu.domain}")
    private static String domain;


    /**
     * @param multipartFile 上传文件
     * @param finalFilename 文件最终名字    qiNui路径+文件名
     * @return 图片访问路径
     */
    public static String uploadImage2Qiniu(MultipartFile multipartFile, String finalFilename) {
        try {

            //1.构造一个带指定 Region 对象的配置类
            Configuration cfg = new Configuration(Region.huanan());
            UploadManager uploadManager = new UploadManager(cfg);

            //2.获取七牛云提供的 token
            Auth auth = Auth.create(accessKey, accessSecretKey);
            String upToken = auth.uploadToken(bucket);
            uploadManager.put(multipartFile.getBytes(), finalFilename, upToken);

            return domain + "/" + finalFilename;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //文件条件判断
    public static void checkImage(MultipartFile multipartFile) {
        //文件不为空
        if (ObjectUtils.isEmpty(multipartFile)) {
            throw WebServiceEnumException.buildResponseData(ResultCodeEnum.ERR_CODE_FILE_NULL_ERROR);
        }
        //文件大小不超过阈值
        if (!FileUtil.isFileSizeOK(multipartFile)) {
            throw WebServiceEnumException.buildResponseData(ResultCodeEnum.ERR_CODE_FILE_SIZE_FAILED);
        }
        //文件名不能为空
        if (StringUtils.isBlank(multipartFile.getOriginalFilename())) {
            System.out.println("1111");
            throw WebServiceEnumException.buildResponseData(ResultCodeEnum.ERR_CODE_FILE_NAME_NULL_ERROR);
        }

        //文件类型符合条件
        if (!FileUtil.isFileAllowed(multipartFile.getOriginalFilename())) {
            throw WebServiceEnumException.buildResponseData(ResultCodeEnum.ERR_CODE_FILE_FORMATTER_FAILED);
        }

    }

    //删除文件
    public static void deleteFileFromQiniu(String fileName) {
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Region.huanan());
        String key = fileName;
        Auth auth = Auth.create(accessKey, accessSecretKey);
        BucketManager bucketManager = new BucketManager(auth, cfg);
        try {
            bucketManager.delete(bucket, key);
        } catch (QiniuException ex) {
            //如果遇到异常，说明删除失败
            System.err.println(ex.code());
            System.err.println(ex.response.toString());
        }
    }
}
