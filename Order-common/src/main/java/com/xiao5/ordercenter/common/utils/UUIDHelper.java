package com.xiao5.ordercenter.common.utils;

import java.util.UUID;

/**
 * @auther: Wu Tianbing
 * @date: 2019/4/20 22:40
 */
public class UUIDHelper {

    /**
     *  获得一个32位的UUID
     * @author Wu TianBing
     * @date 2019/4/20 22:41
     * @param 	
     * @return java.lang.String
     */
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-", "");
    }

    
    /**
     *  获得指定数目的UUID数组
     * @author Wu TianBing
     * @date 2019/4/20 22:41
     * @param number	需要获得的UUID数量
     * @return java.lang.String[]
     */
    public static String[] getUUID(int number){
        if(number < 1){
            return null;
        }
        String[] retArray = new String[number];
        for(int i=0;i<number;i++){
            retArray[i] = getUUID();
        }
        return retArray;
    }
}
