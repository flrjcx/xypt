package com.flrjcx.xypt.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传服务
 */
public interface FileService {

    /**
     *
     * @param file  文件
     * @param fileExtName   文件后缀名
     * @return      文件url
     * @throws Exception
     */
    public String uploadToQiNui(MultipartFile file, String fileExtName) throws Exception;



}
