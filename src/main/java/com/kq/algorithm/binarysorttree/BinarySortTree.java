package com.kq.algorithm.binarysorttree;

import com.kq.algorithm.binarysorttree.dto.Node;

/**
 * BinarySortTree
 *
 * @author kq
 * @date 2021/2/19 20:59
 * @since 1.0.0
 */
public class BinarySortTree {

    private Node root;

    public void addBST(int key) {
        Node p = root;
        /** 记录查找节点的前一个节点 */
        Node prev = null;
        /** 一直查找下去，直到到达满足条件的节点位置 */
        while (p!=null) {
            prev = p;

            if(key < p.getValue()) {
                p = p.getLeft();
            }else if (key > p.getValue()) {
                p = p.getRight();
            }else {
                // 如果相等，return后则不会执行下面语句
                return;
            }

        }
        // 如果相等，return后则不会执行下面语句
        /** prev是的待插入的节点的父节点 ，根据节点值的大小，被插入相应的位置 */

        if(root == null) {
            root = new Node(key);
        } else if (key < prev.getValue()) {
            prev.setLeft(new Node(key));
        } else {
            prev.setRight(new Node(key));
        }

    }

    public void printRoot(){
        System.out.println(root);
    }

}
