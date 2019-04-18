package com.util;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Hashtable;

/**
 * Created by lvjianqing on 2017/9/13.
 */
public class QRcodeUtil {
    //生成二维码
    public static void write(String str, int width, int height, String path) throws IOException {
        String format = "png";
        Hashtable hints = new Hashtable();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hints.put(EncodeHintType.MARGIN, 2);
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(str, BarcodeFormat.QR_CODE, width, height, hints);
            Path file = new File(path).toPath();
            MatrixToImageWriter.writeToPath(bitMatrix, format, file);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }

    //生成二维码
    public static byte[] write(String str, int width, int height) throws IOException {
        String format = "png";
        Hashtable hints = new Hashtable();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hints.put(EncodeHintType.MARGIN, 2);
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(str, BarcodeFormat.QR_CODE, width, height, hints);
            ByteArrayOutputStream bs = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, format, bs);
            byte[] bytes = bs.toByteArray();
            bs.flush();
            bs.close();
            return bytes;
        } catch (WriterException e) {
            e.printStackTrace();
        }
        return null;
    }

    //解析二维码：
    public static String read(BufferedImage image) throws NotFoundException {
        MultiFormatReader formatReader = new MultiFormatReader();
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
        Hashtable hints = new Hashtable();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        Result result = formatReader.decode(binaryBitmap, hints);
        System.err.println("解析结果：" + result.toString());
        System.out.println(result.getBarcodeFormat());
        System.out.println(result.getText());
        return result.toString();
    }

    public static void main(String[] args) {
        try {
            byte[] b = write("http://www.baidu.com", 600, 600);
            System.out.println(b.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
