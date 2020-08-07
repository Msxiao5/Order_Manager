package com.xiao5.ordercenter.service.common;

/**
 * @author Wu Tianbing
 * @version V1.0
 * @Description:
 * @className: Recursion
 * @date 2020/8/5/005 18:07
 * @company:西安博达软件股份有限公司
 * @copyright: Copyright (c) 2020
 */
public class Recursion {


    public static void main(String[] args) {
        hanio(3, "x", "y", "z");
    }


    private static void hanio(int n, String x, String y, String z){
        if (n < 1 ){
            System.out.println("汉诺塔层数不小于 1 ");
        }else if (n == 1){
            System.out.println("移动 " + x + " ->> " + z);
            return;
        }else {
            hanio(n -1 , x, z, y);
            System.out.println("移动 " + x + " ->> " + z);
            hanio(n -1, y, x, z);
        }


    }

}
