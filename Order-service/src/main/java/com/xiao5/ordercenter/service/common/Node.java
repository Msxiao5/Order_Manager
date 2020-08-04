package com.xiao5.ordercenter.service.common;

/**
 * @author Wu Tianbing
 * @version V1.0
 * @Description:
 * @className: Node
 * @date 2020/8/3/003 21:13
 * @company:西安博达软件股份有限公司
 * @copyright: Copyright (c) 2020
 */
public class Node {
    Object data;
    Node leftChild;
    Node rightChild;
    public Node(Object data, Node leftChild, Node rightChild) {
        super();
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
}
