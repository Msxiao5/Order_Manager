package com.xiao5.ordercenter.service.common;

import java.util.LinkedList;

/**
 * @author Wu Tianbing
 * @version V1.0
 * @Description:
 * @className: TreeDemo
 * @date 2020/8/3/003 21:01
 * @company:西安博达软件股份有限公司
 * @copyright: Copyright (c) 2020
 */
public class TreeDemo {


    // 先序遍历
    public static void preOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }
    // 中序遍历
    public static void inOrderTraverse(Node node) {
        if (node == null){
            return;
        }
        inOrderTraverse(node.leftChild);
        System.out.print(node.data + " ");
        inOrderTraverse(node.rightChild);
    }
    // 后序遍历
    public static void postOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        postOrderTraverse(node.leftChild);
        postOrderTraverse(node.rightChild);
        System.out.print(node.data + " ");
    }


    /**
     * 前序递归排列
     * @author Wu Tianbing
     * @date 2020-08-03 21:18
     * @param root	树
     */
    public static void levelTraverse(Node root) {
        if (root == null) {
            return;
        }
        LinkedList<Node> queue = new LinkedList<Node>();
        Node current = null;
        // 根节点入队
        queue.offer(root);

        // 只要队列中有元素，就可以一直执行，非常巧妙地利用了队列的特性
        while (!queue.isEmpty()) {
            // 出队队头元素
            current = queue.poll();
            System.out.print("-->" + current.data);
            // 左子树不为空，入队
            if (current.leftChild != null) {
                queue.offer(current.leftChild);
            }
            // 右子树不为空，入队
            if (current.rightChild != null) {
                queue.offer(current.rightChild);
            }
        }
    }




}
