package com.xiao5.ordercenter.service.common;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * @author Wu Tianbing
 * @version V1.0
 * @Description:
 * @className: StringDemo
 * @date 2020/8/3/003 15:57
 * @company:西安博达软件股份有限公司
 * @copyright: Copyright (c) 2020
 */
@Slf4j
public class StringDemo {

    public void s1(String[] args) {
        String old = "goodgoogle";
        String  eh = "google";
        int index = 0;

        for (int i = 0; i < old.length(); i++ ){
            if (old.charAt(i) == eh.charAt(0)){
                int jc = 0;
                for (int j = 0; j < eh.length(); j++){
                    if (old .charAt(i +j) == eh.charAt(j)){
                        break;
                    }
                    jc = j;
                }
                if (jc  == eh.length() -1){
                    index = 1;
                }
            }
        }
        System.out.println(index);
    }


    public void s2() {
        String a = "123456";
        String b = "13452439";
        String maxSubStr = "";
        int max_len = 0;

        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++){
                if (a.charAt(i) == b.charAt(j)){
                    for (int m=i, n=j; m<a.length()&&n<b.length(); m++,n++) {
                        if (a.charAt(m) != b.charAt(n)){
                            break;
                        }
                        if (max_len < m-i+1){
                            max_len = m-i+1;
                            maxSubStr = a.substring(i, m+1);
                        }
                    }
                }
            }
        }
        System.out.println(maxSubStr);
    }

    public static void main(String[] args) {
//        s3();
    }

    private static void s3() {
//        给定一个字符串，逐个翻转字符串中的每个单词。例如，输入: "the sky is blue"，输出: "blue is sky the"。
        String str = "the sky is blue";
        String[] split = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = split.length -1; i != -1; i--){
            stringBuilder.append(split[i]).append(" ");
        }
        System.out.println(stringBuilder.toString());
    }



}
