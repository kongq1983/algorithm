package com.kq.algorithm.binarysorttree;

import com.kq.algorithm.binarysorttree.dto.Node;

/**
 * BinarySortTree
 * 二叉排序树(本版本刪除有bug)
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

    public void deleteBST(int key) {
        deleteBST(root,key);
    }

    private boolean deleteBST(Node node,int key) {

        if(node==null) {
            // 未找到节点数据
            return false;
        }else {
            if(key == node.getValue()) {
                return delete(node);
            }else if(key < node.getValue()) {
                return deleteBST(node.getLeft(),key);
            }else {
                return deleteBST(node.getRight(),key);
            }
        }

    }

    /**
     * 1. 如果右子树为空，则只需将它的左子树接到该节点
     * 2. 如果左子树为空，则只需将它的右子树接到该节点
     * 3. 如果左右子树均不为空
     * 3.1 如果左右子树均不为空，则需要在右子树中寻找最小的节点，并将右子树中最小的节点接到当前节点 (取右子树-最小值)
     * 3.2 如果左右子树均不为空，则需要在左子树中寻找最大的节点，并将左子树中最大的节点接到当前节点 (取左子树-最大值)
     * 3.1 和 3.2 只要取1個就好了
     * @param node  要删除的节点
     * @return
     */
    private boolean delete(Node node) {

        Node temp = null;
        /** 右子树空，只需要重接它的左子树
         *  如果是叶子节点，则在这里也把叶子节点删除了
         * */

        if(node.getRight()==null) {
            temp = node;
            // 这里是直接给node赋值
            node = node.getLeft();
        }
        // 左子树空，重接它的右子树
        else if(node.getLeft()==null) {
            temp = node;
            // 这里是直接给node赋值
            node = node.getRight();
        }
        // 左右子树均不为空
        else {
            temp = node;
            Node s = node;
            /** 转向左子树，然后向右走到尽头 */
            s = s.getLeft();
            while (s.getRight()!=null) {
                temp = s;
                s = s.getRight();
            }
            node.setValue(s.getValue());
            if(temp!=node) {
                temp.setRight(s.getLeft());
            }else {
                temp.setLeft(s.getLeft());
            }
        }

        return true;
    }


    public void printRoot(){
        System.out.println(root);
    }

}
