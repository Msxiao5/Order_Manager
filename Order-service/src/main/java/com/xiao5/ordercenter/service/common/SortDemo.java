package com.xiao5.ordercenter.service.common;

import java.util.Arrays;

/**
 * @author Wu Tianbing
 * @version V1.0
 * @Description:
 * @className: SortDemo
 * @date 2020/8/4/004 10:22
 * @company:西安博达软件股份有限公司
 * @copyright: Copyright (c) 2020
 */
public class SortDemo {

    public static void main(String[] args) {
        int[] ints = {12,543,65,564,2,3245,433,6547,87};

        int[] sort = sort2(ints);
        Arrays.stream(sort).forEach(System.out::println);
    }

    /**
     * 冒泡排序
     * 原理：相邻元素两两比较，大的往后放，每一次完毕，最大值出现在了最大索引处
     */
    private static int[] sort(int[] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length - i; j++){
                if (arr[j] > arr[j + 1]){
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }

    /**
     * 选择排序：
     * 原理：每一次那一个元素,和剩余的元素挨个去比较,经过第一遍比较,那么最小的元素,或移动到最前面去
     */
    private static int[] sort2(int[] arr){
        for (int i = 0; i < arr.length -1; i++){
            for (int j = i + 1; j < arr.length; j ++){
                if (arr[i] > arr[j]){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }

    /**
     * 二分法查找：
     * 注：二分法查找的前提是元素有序；
     * 原理：每次都查中间的那个元素，比较大或者小就能减少一半的元素；
     */

    private static int  findIndex(int[] arr, int ele){
        int minIndex = 0;
        int maxIndex = arr.length - 1;
        int midIndex = (maxIndex + minIndex) / 2;
        while (minIndex < maxIndex){
            if (arr[minIndex] == ele){
                return midIndex;
            }else if (arr[minIndex] > ele){
                maxIndex = midIndex - 1;
            }else if (arr[minIndex] < ele){
                minIndex = midIndex + 1;
            }
            minIndex = (maxIndex + minIndex) / 2;
        }
        return -1;
    }
}
