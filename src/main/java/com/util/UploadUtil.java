package com.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

/**
 * Created by lvjianqing on 2017/9/14.
 */
public class UploadUtil {
    static Logger log = Logger.getLogger(UploadUtil.class);

    public static String uploadImg(MultipartFile file, HttpServletRequest request) throws IOException {
        String path = null;// 文件路径
        if (file != null) {// 判断上传的文件是否为空
            String fileName = file.getOriginalFilename();// 文件原名称
            log.info("上传的文件原名称:" + fileName);
            // 判断文件类型
            String type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
            if (type != null) {// 判断文件类型是否为空
                if ("GIF".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase()) || "JPEG".equals(type.toUpperCase())) {
                    // 项目在容器中实际发布运行的根路径 todo
                    String realPath = request.getSession().getServletContext().getRealPath("/");
//                    String realPath = Config.getString("upload.path");
                    // 自定义的文件名称
                    String trueFileName = String.valueOf(System.currentTimeMillis()) + "." + type;
                    // 设置存放图片文件的路径
                    path = "upload/" + new DateTime().toString("yyyyMM") + "/" + trueFileName;
                    log.info("存放图片文件的路径:" + path);
                    File f = new File(realPath + path);
                    if (!f.exists() && !f.isDirectory()) {
                        f.mkdirs();
                    }
                    // 转存文件到指定的路径
                    file.transferTo(f);
                    log.info("文件成功上传到指定目录下");
                } else {
                    log.info("不是我们想要的文件类型,请按要求重新上传");
                }
            } else {
                log.info("文件类型为空");
            }
        } else {
            log.info("没有找到相对应的文件");
        }
        return Config.getString("domain") + "/" + path;
    }

    /**
     * 保存缩略图
     *
     * @param file
     * @param request
     * @return
     * @throws IOException
     */
    public static String uploadSmallImg(MultipartFile file, HttpServletRequest request) throws IOException {
        String path = null;// 文件路径
        if (file != null) {// 判断上传的文件是否为空
            String fileName = file.getOriginalFilename();// 文件原名称
            log.info("上传的文件原名称:" + fileName);
            // 判断文件类型
            String type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
            if (type != null) {// 判断文件类型是否为空
                if ("GIF".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase()) || "JPEG".equals(type.toUpperCase())) {
                    // 项目在容器中实际发布运行的根路径 todo
                    String realPath = request.getSession().getServletContext().getRealPath("/");
//                    String realPath = Config.getString("upload.path");
                    // 自定义的文件名称
                    String trueFileName = String.valueOf(System.currentTimeMillis()) + "." + type;
                    // 设置存放图片文件的路径
                    path = "upload/" + new DateTime().toString("yyyyMM") + "/small_" + trueFileName;
                    log.info("存放图片文件的路径:" + path);
                    ByteArrayInputStream in = new ByteArrayInputStream(file.getBytes());
                    Thumbnails.of(in).size(200, 150).keepAspectRatio(false).toFile(realPath + path);
                    log.info("文件成功上传到指定目录下");
                } else {
                    log.info("不是我们想要的文件类型,请按要求重新上传");
                }
            } else {
                log.info("文件类型为空");
            }
        } else {
            log.info("没有找到相对应的文件");
        }
        return Config.getString("domain") + "/" + path;
    }


    /**
     * 用于存微信头像
     *
     * @param request
     * @param fileName
     * @param bytes
     * @throws IOException
     */
    public static void writeFile(HttpServletRequest request, String fileName, byte[] bytes) throws IOException {
        // 项目在容器中实际发布运行的根路径
        String realPath = request.getSession().getServletContext().getRealPath("/");
        // 设置存放图片文件的路径
        String path = realPath + "upload/" + fileName;
        log.info("存放图片文件的路径:" + path);
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        Thumbnails.of(in).sourceRegion(Positions.CENTER, 400, 400).size(200, 200).keepAspectRatio(false).toFile(path);
    }
}
