package com.flrjcx.xypt.controller;


import com.flrjcx.xypt.common.annotation.ApiRestController;
import com.flrjcx.xypt.common.enums.ResultCodeEnum;
import com.flrjcx.xypt.common.model.result.ResponseData;
import com.flrjcx.xypt.common.utils.FileUtil;
import com.flrjcx.xypt.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * 文件上传
 *
 * @author 疯了~
 */
@Api(tags = "文件上传")
@ApiRestController("/api/client/fileUploader")
@Log4j2
public class FileUploaderController {

    @Resource
    private FileService fileService;

    @ApiOperation(value = "上传用户头像")
    @PostMapping("uploadFace")
    public ResponseData uploadFace( MultipartFile file) throws Exception {

               String local = "C:/4948f96846dd411da7de3d034b5ca7b2!400x400.jpeg";
        File files = new File(local);
        InputStream inputStream = new FileInputStream(files);
        file = new MockMultipartFile(file.getName(), inputStream);


        String path = "";

        //判断文件是否为空
        if (!(ObjectUtils.isEmpty(file) || file.getSize() <= 0)) {
            //判断文件大小是否合适
            if(!FileUtil.isFileSizeOK(file)){
                return ResponseData.buildErrorResponse(ResultCodeEnum.ERR_CODE_FILE_SIZE_FAILED);
            }
            //获得文件上传的名称
            String filename = file.getOriginalFilename();
            //判断文件名不能为null
            if (StringUtils.isNoneBlank(filename)) {
                String[] split = filename.split("\\.");
                //获得后置名称
                String suffix = split[split.length - 1];

                //判断后缀符合我们的预定义规范
               if (!FileUtil.isFileAllowed(suffix)){
                   //文件图片格式不支持
                   return ResponseData.buildErrorResponse(ResultCodeEnum.ERR_CODE_FILE_FORMATTER_FAILED);
               }

                //上传
                path= fileService.uploadToQiNui(file, suffix);

            }

        }else {
            //文件不能为空
            return ResponseData.buildErrorResponse(ResultCodeEnum.ERR_CODE_FILE_NULL_ERROR);
        }

        //返回文件路径
        return ResponseData.buildResponse(path);
    }

    @ApiOperation(value = "上传多个图片文件")
    @PostMapping("uploadSomeFiles")
    public ResponseData uploadSomeFace( MultipartFile[] files) throws Exception {
        //声明一个list, 用于存放多个图片url路径 , 返回给前端
        ArrayList<String> imageUrlList = new ArrayList<>();
        for (MultipartFile file : files) {
            String path = "";
            //判断文件是否为空
            if (!(ObjectUtils.isEmpty(file) || file.getSize() <= 0)) {
                //判断文件大小是否合适
                if(!FileUtil.isFileSizeOK(file)){
//                    return ResponseData.buildErrorResponse(ResultCodeEnum.ERR_CODE_FILE_SIZE_FAILED);
                    continue;
                }
                //获得文件上传的名称
                String filename = file.getOriginalFilename();
                //判断文件名不能为null
                if (StringUtils.isNoneBlank(filename)) {
                    String[] split = filename.split("\\.");
                    //获得后置名称
                    String suffix = split[split.length - 1];

                    //判断后缀符合我们的预定义规范
                    if (!FileUtil.isFileAllowed(suffix)){
                        //文件图片格式不支持
                        //return ResponseData.buildErrorResponse(ResultCodeEnum.ERR_CODE_FILE_FORMATTER_FAILED);
                        continue;
                    }

                    //上传
                    path= fileService.uploadToQiNui(file, suffix);

                }

                if (StringUtils.isNotBlank(path)) {
                    //放入list集合中
                    //放入审核...
                    imageUrlList.add(path);

                } else {
                    continue;
                    //return ResponseData.buildErrorResponse(ResultCodeEnum.ERR_CODE_UPLOAD_FILE_FAILED);
                }

            }

        }
        //返回图片路径集合
        return ResponseData.buildResponse(imageUrlList);
    }
}
