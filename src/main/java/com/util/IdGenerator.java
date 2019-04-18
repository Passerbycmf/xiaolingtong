package com.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by lvjianqing on 2017/8/4.
 */
public class IdGenerator {
    private Log log = LogFactory.getLog(IdGenerator.class);
    public static String preDateTime = "";
    public static String currentDateTime = "";
    public static int seq = 0;
    public static byte[] lock = new byte[0];
    private static String IdBz="";

    public static String getIdBz() {
        if(IdBz.equals("")){
            String ip= IpUtil.getLocalIp();
            int index=ip.lastIndexOf(".");
            IdBz=ip.substring(index+1);
            if(IdBz.length()>2){
                IdBz=IdBz.substring(1);
            }
        }
        return IdBz;
    }

    public static String getId(){
        String res = "";
        synchronized (lock) {
            currentDateTime =new DateTime().toString("yyMMddHHmmss");//String.valueOf(System.currentTimeMillis()); //StringUtil.getCurDate("yyMMddHHmmss");
            currentDateTime=getIdBz()+currentDateTime;
            if (currentDateTime.equals(preDateTime)) {
                if(seq%800==0){
                    try{
                        Thread.sleep(1);
                    }catch(Exception e){}
                }
                seq++;
                if (seq < 10) {
                    res = currentDateTime + "000" + seq;
                } else if (seq >= 10 && seq < 100) {
                    res = currentDateTime + "00" + seq;
                } else if (seq >= 100 && seq < 1000) {
                    res = currentDateTime + "0" + seq;
                } else if (seq >= 1000 && seq <= 10000) {
                    res = currentDateTime + seq;
                }else{
                    //throw new Exception("generante error");
                }
            } else {
                res = currentDateTime + "0001";
                seq = 1;
            }
            preDateTime=currentDateTime;
        }
        return res;
    }

    /**
     * 锁对象，可以为任意对象
     */
    private static Object lockObj = "lockerOrder";
    /**
     * 订单号生成计数器
     */
    private static long orderNumCount = 0L;
    /**
     * 每毫秒生成订单号数量最大值
     */
    private static int maxPerMSECSize=100;

    /**单号获取*/
    public static String getOrderNo(String startStr){
        // 最终生成的订单号
        String finOrderNum = "";
        try {
            synchronized (lockObj) {
                // 取系统当前时间作为订单号变量前半部分，精确到毫秒
                long nowLong = Long.parseLong(new SimpleDateFormat("yyMMddHHmmssSSS").format(new Date()));
                // 计数器到最大值归零，可扩展更大，目前1毫秒处理峰值1000个，1秒100万
                if (orderNumCount >= maxPerMSECSize) {
                    orderNumCount = 0L;
                }
                //组装订单号
                String countStr=maxPerMSECSize +orderNumCount+"";
                finOrderNum=nowLong+countStr.substring(1);
                orderNumCount++;
               // System.out.println(finOrderNum + "--" + Thread.currentThread().getName() + "::" + tname );
                // Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return finOrderNum;
    }

    /**单号获取*/
    public static String getOrderId(String startStr){
        currentDateTime =new DateTime().toString("yyMMddHHmmss");//String.valueOf(System.currentTimeMillis()); //StringUtil.getCurDate("yyMMddHHmmss");
        currentDateTime=startStr+currentDateTime;
        String res = "";
        synchronized (lock) {
            if (currentDateTime.equals(preDateTime)) {
                if(seq%800==0){
                    try{
                        Thread.sleep(1);
                    }catch(Exception e){}
                }
                seq++;
                if (seq < 10) {
                    res = currentDateTime + "000" + seq;
                } else if (seq >= 10 && seq < 100) {
                    res = currentDateTime + "00" + seq;
                } else if (seq >= 100 && seq < 1000) {
                    res = currentDateTime + "0" + seq;
                } else if (seq >= 1000 && seq <= 10000) {
                    res = currentDateTime + seq;
                }else{
                    //throw new Exception("generante error");
                }
            } else {
                res = currentDateTime + "0001";
                seq = 1;
            }
            preDateTime=currentDateTime;
        }
        return res;
    }

    public static String getUUID(){
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replaceAll("-", "");
        return uuid;
    }


    //public String get
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
      /*  for(int i=0;i<40;i++){
            System.out.println(IdGenerator.getId());
            System.out.println(IdGenerator.getId());
        }*/

    }

}
