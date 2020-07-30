package com.xiao5.ordercenter.service.common;

import javax.sound.midi.Soundbank;
import java.util.LinkedList;

/**
 * @author Wu Tianbing
 * @version V1.0
 * @Description:
 * @className: QueueDemo
 * @date 2020/7/30/030 11:21
 * @company:西安博达软件股份有限公司
 * @copyright: Copyright (c) 2020
 */
public class QueueDemo {

    /**
     * 我们来看一个关于用队列解决约瑟夫环问题。
     * 约瑟夫环是一个数学的应用问题，具体为，已知 n 个人（以编号 1，2，3...n 分别表示）围坐在一张圆桌周围。
     * 从编号为 k 的人开始报数，数到 m 的那个人出列；
     * 他的下一个人又从 1 开始报数，数到 m 的那个人又出列；
     * 依此规律重复下去，直到圆桌周围的人全部出列。
     * 这个问题的输入变量就是 n 和 m，即 n 个人和数到 m 的出列的人。输出的结果，就是 n 个人出列的顺序。
     *
     * 这个问题，用队列的方法实现是个不错的选择。它的结果就是出列的顺序，恰好满足队列对处理顺序敏感的前提。
     * 因此，求解方式也是基于队列的先进先出原则。解法如下：
     *
     * 1、先把所有人都放入循环队列中。注意这个循环队列的长度要大于或者等于 n。
     * 2、从第一个人开始依次出队列，出队列一次则计数变量 i 自增。如果 i 比 m 小，则还需要再入队列。
     * 3、直到i等于 m 的人出队列时，就不用再让这个人进队列了。而是放入一个用来记录出队列顺序的数组中。
     * 4、直到数完 n 个人为止。当队列为空时，则表示队列中的 n 个人都出队列了，这时结束队列循环，输出数组内记录的元素。
     */

    public static void main(String[] args) {
        ring(10,5);
    }


    private static void ring(int n,int m){
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 1; i < n; i++){
            q.add(i);
        }
        int k = 2;
        int element = 0;
        int i = 0;
        for (; i < k; i++){
            element = q.poll();
            q.add(element);
        }
        i = 1;
        while (q.size() > 0){
            element = q.poll();
            if (i < m){
                q.add(element);
                i ++;
            }else {
                i = 1;
                System.out.println(element);
            }
        }
    }
}
