package com.flrjcx.xypt.service.impl;

import com.flrjcx.xypt.common.utils.QiniuUtils;
import com.flrjcx.xypt.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {


    @Override
    public String uploadToQiNiu(MultipartFile file, String fileExtName, String QiNiuPath) {

        //使用uuid作为文件名,防止重名
        String fileName = UUID.randomUUID().toString().replaceAll("-", "") + "." + fileExtName;

        //调用工具类上传文件
        return QiniuUtils.uploadImage2Qiniu(file, QiNiuPath + fileName);


    }


}
