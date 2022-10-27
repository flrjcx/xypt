package com.flrjcx.xypt.common.utils;

import com.flrjcx.xypt.common.enums.ResultCodeEnum;
import com.flrjcx.xypt.common.exception.WebServiceEnumException;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

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
     * 处理多文件
     * @param multipartFiles
     * @return
     */
    public Map<String, List<String>> uploadImage2Qiniu(MultipartFile[] multipartFiles){
        try {
            Map<String,List<String>> map = new HashMap<>();
            List<String> imageUrls = new ArrayList<>();
            for(MultipartFile file : multipartFiles){
                checkImage(file);
                imageUrls.add(uploadImage2Qiniu(file));
            }
            map.put("imageUrl",imageUrls);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 上传图片到七牛云
     * @param multipartFile
     * @return
     */
    private String uploadImage2Qiniu(MultipartFile multipartFile){
        try {
            //1、获取文件上传的流
            byte[] fileBytes = multipartFile.getBytes();
            //2、创建日期目录分隔
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            String datePath = dateFormat.format(new Date());

            //3、获取文件名
            String originalFilename = multipartFile.getOriginalFilename();
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            String filename = datePath+"/"+UUID.randomUUID().toString().replace("-", "")+ suffix;

            //4.构造一个带指定 Region 对象的配置类
            Configuration cfg = new Configuration(Region.huanan());
            UploadManager uploadManager = new UploadManager(cfg);

            //5.获取七牛云提供的 token
            Auth auth = Auth.create(accessKey, accessSecretKey);
            String upToken = auth.uploadToken(bucket);
            uploadManager.put(fileBytes,filename,upToken);

            return domain+filename;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void checkImage(MultipartFile multipartFile) {
        if (ObjectUtils.isEmpty(multipartFile)) {
            throw WebServiceEnumException.buildResponseData(ResultCodeEnum.ERR_CODE_FILE_NULL_ERROR);
        }
        if (!FileUtil.isFileSizeOK(multipartFile)) {
            throw WebServiceEnumException.buildResponseData(ResultCodeEnum.ERR_CODE_FILE_SIZE_FAILED);
        }
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
