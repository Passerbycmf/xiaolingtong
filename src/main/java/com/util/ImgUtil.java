package com.util;

import com.util.msg.DateUtil;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Iterator;

/**
 * Created by Administrator on 2017/10/12.
 */
public class ImgUtil {

    /**
     * @param srcFile 源图片、targetFile截好后图片全名、startAcross 开始截取位置横坐标、StartEndlong开始截图位置纵坐标、width截取的长，hight截取的高
     * @Description:截图
     * @author:liuyc
     * @time:2016年5月27日 上午10:18:23
     */
    public static void cutImage(String srcFile, String targetFile, int startAcross, int StartEndlong, int width,
                                int hight) throws Exception {
        // 取得图片读入器
        Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName("jpg");
        ImageReader reader = readers.next();
        // 取得图片读入流
        InputStream source = new FileInputStream(srcFile);
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        reader.setInput(iis, true);
        // 图片参数对象
        ImageReadParam param = reader.getDefaultReadParam();
        Rectangle rect = new Rectangle(startAcross, StartEndlong, width, hight);
        param.setSourceRegion(rect);
        BufferedImage bi = reader.read(0, param);
        ImageIO.write(bi, targetFile.split("\\.")[1], new File(targetFile));
    }

    /**
     * @param files 要拼接的文件列表
     * @param type  1 横向拼接， 2 纵向拼接
     * @Description:图片拼接 （注意：必须两张图片长宽一致哦）
     * @author:liuyc
     * @time:2016年5月27日 下午5:52:24
     */
    public static void mergeImage(String[] files, int type, String targetFile) {
        int len = files.length;
        if (len < 1) {
            throw new RuntimeException("图片数量小于1");
        }
        File[] src = new File[len];
        BufferedImage[] images = new BufferedImage[len];
        int[][] ImageArrays = new int[len][];
        for (int i = 0; i < len; i++) {
            try {
                src[i] = new File(files[i]);
                images[i] = ImageIO.read(src[i]);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            int width = images[i].getWidth();
            int height = images[i].getHeight();
            ImageArrays[i] = new int[width * height];
            ImageArrays[i] = images[i].getRGB(0, 0, width, height, ImageArrays[i], 0, width);
        }
        int newHeight = 0;
        int newWidth = 0;
        for (int i = 0; i < images.length; i++) {
            // 横向
            if (type == 1) {
                newHeight = newHeight > images[i].getHeight() ? newHeight : images[i].getHeight();
                newWidth += images[i].getWidth();
            } else if (type == 2) {// 纵向
                newWidth = newWidth > images[i].getWidth() ? newWidth : images[i].getWidth();
                newHeight += images[i].getHeight();
            }
        }
        if (type == 1 && newWidth < 1) {
            return;
        }
        if (type == 2 && newHeight < 1) {
            return;
        }

        // 生成新图片
        try {
            BufferedImage ImageNew = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
            int height_i = 0;
            int width_i = 0;
            for (int i = 0; i < images.length; i++) {
                if (type == 1) {
                    ImageNew.setRGB(width_i, 0, images[i].getWidth(), newHeight, ImageArrays[i], 0,
                            images[i].getWidth());
                    width_i += images[i].getWidth();
                } else if (type == 2) {
                    ImageNew.setRGB(0, height_i, newWidth, images[i].getHeight(), ImageArrays[i], 0, newWidth);
                    height_i += images[i].getHeight();
                }
            }
            //输出想要的图片
            ImageIO.write(ImageNew, targetFile.split("\\.")[1], new File(targetFile));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description:小图片贴到大图片形成一张图(合成)
     * @author:liuyc
     * @time:2016年5月27日 下午5:51:20
     */
    public static final void overlapImage(String bigPath, String smallPath, String outFile,int x,int y,int width,int height) {
        try {
            BufferedImage big = ImageIO.read(new File(bigPath));
            BufferedImage small = ImageIO.read(new File(smallPath));
            Graphics2D g = big.createGraphics();
            //x = big.getWidth()/15-8;
            //y = big.getHeight()/ 10-4;
            g.drawImage(small, x, y, width, height, null);
            g.dispose();
            ImageIO.write(big, outFile.split("\\.")[1], new File(outFile));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     *
     * @Title: drawStringForImage
     * @Description: 图片上加字
     * @param filePath
     * @param content
     * @param contentColor
     * @param qualNum   图片质量  0-1
     * @param targetFile
     */
    public static void drawStringForImage(String filePath, String content, Color contentColor, float qualNum, String targetFile,int w,int h) {
        ImageIcon imgIcon = new ImageIcon(filePath);
        Image theImg = imgIcon.getImage();
        int width = theImg.getWidth(null) == -1 ? 200 : theImg.getWidth(null);
        int height = theImg.getHeight(null) == -1 ? 200 : theImg.getHeight(null);
        BufferedImage bimage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bimage.createGraphics();
        g.setColor(contentColor);
        g.setBackground(Color.red);
        g.drawImage(theImg, 0, 0, null);
        // 设置字体、字型、字号
        g.setFont(new Font("微软雅黑", Font.BOLD, 36));
        // 写入文字
        g.drawString(content, w, h);
        g.dispose();
        FileOutputStream out = null;
        try {
            String formatName = targetFile.substring(targetFile.lastIndexOf(".") + 1);
            ImageIO.write(bimage, formatName , new File(targetFile));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    out = null;
                    throw new RuntimeException(e);
                }
            }
        }
    }


    /**
     * 根据地址获得数据的字节流
     * @param strUrl 网络连接地址
     * @return
     */
    public static byte[] getImageFromNetByUrl(String strUrl){
        try {
            URL url = new URL(strUrl);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            InputStream inStream = conn.getInputStream();//通过输入流获取图片数据
            byte[] btImg = readInputStream(inStream);//得到图片的二进制数据
            return btImg;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }




    /**
     * 从输入流中获取数据
     * @param inStream 输入流
     * @return
     * @throws Exception
     */
    public static byte[] readInputStream(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while( (len=inStream.read(buffer)) != -1 ){
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        return outStream.toByteArray();
    }

    /**
     *
     * @Title: buff2Image
     * @Description: 字节流生成图片
     * @param b
     * @param filePath
     * @throws Exception
     */
    public static void buff2Image(byte[] b,String filePath) throws Exception
    {
        FileOutputStream fout = new FileOutputStream(filePath);
        //将字节写入文件
        fout.write(b);
        fout.close();
    }



    /**
     *
     * @Title: buff2Image
     * @Description: 字节流生成图片
     * @param filePath
     * @throws Exception
     */
    public static void deleteImg(String filePath) throws Exception
    {
        File file=new File(filePath);
        file.delete();
    }

    public static String trsfAdviceImg(String headImg,String qrcodeImg,String nickName,String rootPath,String qrmodePath) throws Exception
    {
        byte[] byteHeadImg = ImgUtil.getImageFromNetByUrl(headImg);
        byte[] byteQrcodeImg = ImgUtil.getImageFromNetByUrl(qrcodeImg);
        try {
            String headImgPath=rootPath+DateUtil.dateToStr(new Date(),"yyMMddHHmmssSSS"+MathUtil.getRandomNum(10000,99999))+".jpg";
            String qrcodeImgPath=rootPath+DateUtil.dateToStr(new Date(),"yyMMddHHmmssSSS"+MathUtil.getRandomNum(10000,99999))+".jpg";;
            String resultImg1=rootPath+DateUtil.dateToStr(new Date(),"yyMMddHHmmssSSS"+MathUtil.getRandomNum(10000,99999))+".jpg";
            //String retImgPath=rootPath+DateUtil.dateToStr(new Date(),"yyMMddHHmmssSSS")+".jpg";
            String resultImg2=rootPath+DateUtil.dateToStr(new Date(),"yyMMddHHmmssSSS"+MathUtil.getRandomNum(10000,99999))+".jpg";
            String resultImg3=rootPath+DateUtil.dateToStr(new Date(),"yyMMddHHmmssSSS"+MathUtil.getRandomNum(10000,99999))+".jpg";
            String modelImgPath=qrmodePath;
            ImgUtil.buff2Image(byteHeadImg,headImgPath);
            ImgUtil.buff2Image(byteQrcodeImg,qrcodeImgPath);
            ImgUtil.overlapImage(modelImgPath,headImgPath,resultImg1,28,95,155,155);
            System.out.println(modelImgPath+"和"+headImgPath+"合成"+resultImg1);
            ImgUtil.overlapImage(resultImg1,qrcodeImgPath,resultImg2,173,289,258,258);
            System.out.println(resultImg1+"和"+qrcodeImgPath+"合成"+resultImg2);
            //ImgUtil.drawStringForImage(resultImgPath, "我是", new Color(1,68,165), 0.5f, retImgPath,210,130);
            ImgUtil.drawStringForImage(resultImg2, "我是    "+nickName, new Color(254,46,71), 0.5f, resultImg3,200,130);
            System.out.println(resultImg2+"和"+nickName+"合成"+resultImg3);
            //ImgUtil.deleteImg(retImgPath);
            ImgUtil.deleteImg(headImgPath);
            ImgUtil.deleteImg(qrcodeImgPath);
            ImgUtil.deleteImg(resultImg1);
            ImgUtil.deleteImg(resultImg2);
            return resultImg3;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
