package com.flrjcx.xypt.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.flrjcx.xypt.common.enums.ResultCodeEnum;
import com.flrjcx.xypt.common.exception.WebServiceEnumException;
import com.flrjcx.xypt.service.FileService;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {



    // 设置好账号的ACCESS_KEY和SECRET_KEY
    String ACCESS_KEY ="-EfQVnR7p2FhyKVFbG26s4SUQ_65VumPI7s8MrR9";
    String SECRET_KEY = "ne4WwzKgeYI_4knrYczA3esge8ATvlUOj0EkS5HI";

    // 要上传的空间（创建空间的名称）
    String bucketname = "object-xypt-test";

    // 密钥配置
    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    // 构造一个带指定Zone对象的配置类,不同的七云牛存储区域调用不同的zone
    Configuration cfg = new Configuration(Zone.zone2());
    // ...其他参数参考类注释
    UploadManager uploadManager = new UploadManager(cfg);

    // 使用的是测试域名
    private static String QINIU_IMAGE_DOMAIN = "rk5lejjv4.hn-bkt.clouddn.com";

    // 简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public String getUpToken() {
        return auth.uploadToken(bucketname);
    }

    @Override
    public String uploadToQiNui(MultipartFile file, String fileExtName) throws Exception {
        //使用uuid作为文件名,防止重名
        String fileName = UUID.randomUUID().toString().replaceAll("-", "") + "." + fileExtName;
        //调用put方法上传
        Response res = uploadManager.put(file.getBytes(), fileName, getUpToken());
        //请求上传失败
        if (!(res.isOK() && res.isJson())) {

            //七牛云服务异常
            throw WebServiceEnumException.buildResponseData(ResultCodeEnum.ERR_CODE_QINIU_ERR);

        }

        //返回图片url
        return QINIU_IMAGE_DOMAIN +"/"+ JSONObject.parseObject(res.bodyString()).get("key");


    }


    }
