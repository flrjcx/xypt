package com.flrjcx.xypt.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传服务
 */
public interface FileService {

    /**
     *
     * @param file  上传文件
     * @param fileExtName   文件后缀名
     * @param QiNuiPath 文件储存目录
     * @return  文件访问地址
     * @throws Exception
     */
    public String uploadToQiNui(MultipartFile file, String fileExtName, String QiNuiPath) throws Exception;



}
