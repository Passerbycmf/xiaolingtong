package com.util;

import java.util.Random;

public class MathUtil {
	/** 
	 *  
	 * @Description: 产生随机的六位数 
	 * @param @return   
	 * @return String  
	 * @throws
	 * @author yehao
	 * @date 2015-10-12
	 */
    public static String getSix(){  
        Random rad=new Random();  
        String result  = rad.nextInt(1000000) +"";  
          
        if(result.length()!=6){  
            return getSix();  
        }  
        return result;  
    }
    
    /**
     * 
     * @Description: 获得区间随机数
     * @param @param max
     * @param @return   
     * @return Integer  
     * @throws
     * @author yehao
     * @date 2015-10-13
     */
    public static Integer getRandomNum(int min,int  max){
    	int Min = min;
    	int Max = max;
    	int result = Min + (int)(Math.random() * ((Max - Min) + 1));
    	return result;
    }
    
}
