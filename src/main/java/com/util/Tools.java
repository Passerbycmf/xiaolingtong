package com.util;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @classname: Tools
 * @description: 数字,日期转化工具类
 * @author: jocker
 * @date: 2018/4/13 21:37
 * @version: 1.0
 **/
public class Tools {
    /**
     * 随机生成六位数验证码
     * @return
     */
    public static int getRandomNum(){
        Random r = new Random();
        return r.nextInt(900000)+100000;//(Math.random()*(999999-100000)+100000)
    }
    /**
     * 随机生成8位的数字加字母的验证码
     */
    public static String pass(){
        List list = new ArrayList();
        // list.add(1);
        for (int i = 0; i < 10; i++)
            list.add(i+"");
        for (char c = 'A'; c <= 'Z'; c++)
            list.add(c+"");

        String randomStr = "";

        for (int i = 0; i < 8; i++) {
            int mathInt;
            mathInt=(int) (Math.random()*list.size());
            randomStr +=(String)list.get(mathInt);
            list.remove(mathInt);
        }

        return randomStr;
    }



    private static char randomChar(){
        Random r = new Random();
        String s = "ABCDEFGHJKLMNPRSTUVWXYZ123456789";
        return s.charAt(r.nextInt(s.length()));
    }

    public static String getRandomCode(int length){
        String code="";
        for(int i=0; i<length; i++){
            code += randomChar();
        }

        return code;
    }

    /**
     * 检测字符串是否不为空(null,"","null")
     * @param s
     * @return 不为空则返回true，否则返回false
     */
    public static boolean notEmpty(String s){
        return s!=null && !"".equals(s) && !"null".equals(s);
    }

    /**
     * 检测字符串是否为空(null,"","null")
     * @param s
     * @return 为空则返回true，不否则返回false
     */
    public static boolean isEmpty(String s){
        return s==null || "".equals(s) || "null".equals(s);
    }

    /**
     * 字符串转换为字符串数组
     * @param str 字符串
     * @param splitRegex 分隔符
     * @return
     */
    public static String[] str2StrArray(String str,String splitRegex){
        if(isEmpty(str)){
            return null;
        }
        return str.split(splitRegex);
    }

    /**
     * 用默认的分隔符(,)将字符串转换为字符串数组
     * @param str	字符串
     * @return
     */
    public static String[] str2StrArray(String str){
        return str2StrArray(str,",\\s*");
    }

    /**
     * 按照yyyy-MM-dd HH:mm:ss的格式，日期转字符串
     * @param date
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String date2Str(Date date){

        return date2Str(date,"yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 按照yyyy-MM-dd HH:mm:ss的格式，字符串转日期
     * @param date
     * @return
     */
    public static Date str2Date(String date){
        if(notEmpty(date)){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                return sdf.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return new Date();
        }else{
            return null;
        }
    }

    /**
     * 按照yyyy-MM-dd HH:mm:ss的格式，字符串转日期
     * @param date
     * @return
     */
    public static Date str3Date(String date){
        if(notEmpty(date)){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            try {
                return sdf.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return new Date();
        }else{
            return null;
        }
    }
    /**
     * 按照参数format的格式，日期转字符串
     * @param date
     * @param format
     * @return
     */
    public static String date2Str(Date date,String format){
        if(date!=null){
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        }else{
            return "";
        }
    }

    /**
     * 把时间根据时、分、秒转换为时间段
     * @param StrDate
     */
    public static String getTimes(String StrDate){
        String resultTimes = "";

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now;

        try {
            now = new Date();
            Date date=df.parse(StrDate);
            long times = now.getTime()-date.getTime();
            long day  =  times/(24*60*60*1000);
            long hour = (times/(60*60*1000)-day*24);
            long min  = ((times/(60*1000))-day*24*60-hour*60);
            long sec  = (times/1000-day*24*60*60-hour*60*60-min*60);

            StringBuffer sb = new StringBuffer();
            //sb.append("发表于：");
            if(hour>0 ){
                sb.append(hour+"小时前");
            } else if(min>0){
                sb.append(min+"分钟前");
            } else{
                sb.append(sec+"秒前");
            }

            resultTimes = sb.toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return resultTimes;
    }



    public static String newOrderId(){
        String orderId="";
        String dateStr= Tools.date2Str(new Date(),"yyyyMMddhhmmssSSS");
        String rds= Tools.getRandomNum()+"";
        orderId=dateStr+rds;
        return orderId;
    }



    public static void main(String[] args) {
        System.out.println(getRandomCode(6));
    }
    /**
     * 文件路径出错
     * @param fileP
     * @return
     */
    public static String readFilePath(String fileP) {
        String filePath=null;
        try {
            filePath = String.valueOf(Thread.currentThread().getContextClassLoader().getResource(""))+"../../";	//项目路径
            filePath = filePath.replaceAll("file:/", "");
            filePath = filePath.replaceAll("%20", " ");
            filePath = filePath.trim() + fileP.trim();
            if(filePath.indexOf(":") != 1){
                filePath = File.separator + filePath;
            }
        } catch (Exception e) {
            System.out.println("文件路径出错");
        }
        return filePath;
    }
    /**
     *
     * @Title: paseNo
     * @Description: 格式化推广员工号(补全8位)
     * @param no
     * @return
     */
    public static String paseNo(String no){
        int length=no.length();
        int dp=8-length;
        if(dp>=0){
            for(int i=0;i<dp;i++){
                if(i==dp-1){
                    no="1"+no;
                }else{
                    no="0"+no;
                }
            }
        }
        return no;
    }
    /**
     * xml解析转Map
     * @param xml
     * @return
     * @throws Exception
     */
    /*public static Map parseXml(String xml) throws Exception {
        Map map = new HashMap();
        Document document = DocumentHelper.parseText(xml);
        Element root = document.getRootElement();
        List<Element> elementList = root.elements();
        for (Element e : elementList)
            map.put(e.getName(), e.getText());
        return map;
    }*/
}
