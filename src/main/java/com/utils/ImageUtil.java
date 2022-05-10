package com.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 照片工具类
 * 保存照片到本地
 */
public class ImageUtil {
    public static String saveLocal(MultipartFile file) throws IOException {
        if (file.isEmpty()){
            System.out.println("文件为空");
        }
        //获取文件名
        String fileName = file.getOriginalFilename();
        System.out.println("上传的文件名："+fileName);
        //获取文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        System.out.println("文件后缀名："+suffixName);
        //设置文件存储路径
        String filePath = "E:\\program\\JAVA\\lastHomework\\src\\main\\resources\\static\\images\\tp\\";
        String path = filePath+fileName;
        File dest = new File(path);
        //检测是否存在该目录
        if (!dest.getParentFile().exists()){
            System.out.println("目录不存在");
            dest.getParentFile().mkdirs();
        }
        //写入文件
        file.transferTo(dest);
        return fileName;
    }
}
