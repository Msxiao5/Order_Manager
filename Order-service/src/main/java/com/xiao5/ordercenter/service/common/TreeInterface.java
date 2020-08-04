package com.xiao5.ordercenter.service.common;

/**
 * @author Wu Tianbing
 * @version V1.0
 * @Description:
 * @className: TreeInterface
 * @date 2020/8/3/003 21:21
 * @company:西安博达软件股份有限公司
 * @copyright: Copyright (c) 2020
 */
public interface TreeInterface {

   int size();

    boolean isEmpty();

    int getHeight();

    void preTraversal();

    void middleTraversal();

    void postTraversal();

    /**
     * 借助队列实现层次遍历
     */
    void orderByQueue();

    /**
     * 借助栈实现非递归遍历二叉树,使用先序进行遍历
     */
    void preTraByStack();

    /**
     * 借助栈实现非递归遍历二叉树,使用中序进行遍历
     */
    void inOrderByStack();
    /**
     * 借助栈实现非递归遍历二叉树,使用后序进行遍历
     */
    void postTraByStack();


}
