package com.xiao5.ordercenter.service.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 * @author Wu Tianbing
 * @version V1.0
 * @Description:
 * @className: TreeDemo
 * @date 2020/8/3/003 21:01
 * @company:西安博达软件股份有限公司
 * @copyright: Copyright (c) 2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeDemo2 implements TreeInterface{

    private Node root;

    @Override
    public int size() {
        return this.size(root);
    }

    private int size(Node root){
        if (root == null){
            return 0;
        }else {
            int left = size(root.leftChild);
            int right = size(root.rightChild);
            return left + right + 1;
        }
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int getHeight() {
        return this.getHeight(root);
    }

    private int getHeight(Node root){
        if (root == null ){
            return 0;
        }else {
            int left = getHeight(root.leftChild);
            int right = getHeight(root.rightChild);
            return left > right ? left + 1 : right + 1;
        }
    }

    @Override
    public void preTraversal() {
        if (root != null){
            System.out.println("先序遍历");
            pre(root);
            System.out.println();
        }else {
            System.out.println("此二叉树为空");
        }
    }

    private void pre(Node root) {
        if (root != null){
            System.out.println(root.data + " ");
            this.pre(root.leftChild);
            this.pre(root.rightChild);
        }
    }

    @Override
    public void middleTraversal() {
        if (root != null){
            System.out.println("中序遍历");
            middle(root);
            System.out.println();
        }else {
            System.out.println("此二叉树为空");
        }
    }

    private void middle(Node root) {
        if (root != null){
            this.middle(root.leftChild);
            System.out.println(root.data + " ");
            this.middle(root.rightChild);
        }
    }

    @Override
    public void postTraversal() {
        if (root != null){
            System.out.println("后序遍历");
            post(root);
            System.out.println();
        }else {
            System.out.println("此二叉树为空");
        }

    }

    private void post(Node root) {
        if (root != null){
            this.post(root.leftChild);
            this.post(root.rightChild);
            System.out.println(root.data + " ");
        }
    }

    @Override
    public void orderByQueue() {
        Queue queue = new LinkedList();
        Node node = root;
        queue.add(node);
        while (queue.size() != 0){
            for (int i = 0; i < queue.size(); i++){
                Node poll = (Node) queue.poll();
                System.out.println(poll.data + " ");
                if (poll.leftChild != null){
                    queue.add(poll.leftChild);
                }
                if (poll.rightChild != null){
                    queue.add(poll.rightChild);
                }
            }
        }
        System.out.println();
    }

    @Override
    public void preTraByStack() {
        System.out.println("不采用递归，实现先序遍历，借助栈");
        Deque<Node> stack = new LinkedList<Node>();
        Node node = root;
        stack.push(root);
        while (node != null && stack.size() > 0){
            Node pop = stack.pop();
            System.out.println(pop.data + " ");
            if (pop.leftChild != null && pop.rightChild != null){
                stack.push(pop.leftChild);
                stack.push(pop.rightChild);
            }else if (pop.leftChild != null && pop.rightChild == null){
                stack.push(pop.leftChild);
            } else if (pop.leftChild == null && pop.rightChild != null){
                stack.push(pop.rightChild);
            }
        }
        System.out.println();
    }

    @Override
    public void inOrderByStack() {
        System.out.println("中序非递归遍历:");
        // 创建栈,和先序遍历类似，直接入栈直到没有最左左子树可以 入栈
        Deque<Node> deque = new LinkedList<Node>();
        Node node = root;
        //添加暂时完毕，开始pop元素
        while (node != null && deque.size() > 0){
            while (node != null){
                deque.push(node);
                node = node.leftChild;
            }
            //一边pop并且一边进行判断，右结点不会null的，右子树，继续按照添加方法，将最左结点全部添加进去
            if (deque.size() > 0){
                Node pop = deque.pop();
                System.out.println(pop.data + " ");
                if (pop.rightChild != null){
                    node = pop.rightChild;
                }
            }
        }
        System.out.println();
    }

    @Override
    public void postTraByStack() {
        System.out.println("后序非递归遍历，借助栈");
        //新建栈，先进后出,将根结点入栈,双端队列
        Deque<Node> stack = new LinkedList<>();
        //新建一个list，记录结点的状态是否已经被访问过
        ArrayList<Node> list = new ArrayList<>();

        Node node = root;
        //首先检查完树的左子树，再右子树，最后将根节点输出
        while (node != null && stack.size() > 0){
            //将最左子树添加完毕
            while (node != null){
                stack.push(node);
                node = node.leftChild;
            }
            //和中序遍历相似，为先输出左结点，但是做结点输出完毕之后，不能直接将根结点弹出，而是必须先将右结点弹出，
            //最后再将根结点弹出来，就会牵扯到一个根结点的访问状态的问题，是否已经被遍历过了
            //利用一个list集合记录已将被遍历过的根结点，防止产生死循环
            if (stack.size() > 0){
                Node peek = stack.peek();
                if (peek.rightChild != null){
                    boolean contains = list.contains(peek);
                    if (contains){
                        Node pop = stack.pop();
                        System.out.println(pop.data + " ");
                    }else {
                        list.add(peek);
                        node = peek.rightChild;
                    }
                }else {
                    Node pop = stack.pop();
                    System.out.println(pop.data + "");
                }
            }
        }


    }
}
