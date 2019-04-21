package com.xiao5.ordercenter.common.utils;

/**
 *  String 工具类
 * @author Wu TianBing
 * @date 2019/4/20 22:49
 */
public class StringHelper {

    public static Boolean isEmpty(Object param) {
        if (null == param || "".equals(param.toString().trim()) || "null".equalsIgnoreCase(param.toString().trim()))
            return true;
        return false;
    }

    public static boolean equal(Object o1, Object o2) {
        if (isEmpty(o1) && isEmpty(o2)) {
            return true;
        } else if (isEmpty(o1) || isEmpty(o2)) {
            return false;
        } else if (valueOf(o1).equals(valueOf(o2)))
            return true;
        else {
            return false;
        }
    }

    public static String valueOf(Object object) {
        if (isEmpty(object)) {
            return null;
        }
        String returnStr = object.toString();
        if (isEmpty(returnStr)) {
            return null;
        }
        return returnStr.trim();
    }

    public static String concatToString(Object... arrays) {
        StringBuffer sb = new StringBuffer();
        for (Object obj : arrays) {
            if (isEmpty(obj)) {
                continue;
            } else {
                sb.append(obj);
            }
        }
        return sb.toString();
    }

}
