package com.kq.algorithm.binarysorttree;

import com.kq.algorithm.binarysorttree.dto.Node;

/**
 * BinarySortTree
 * 二叉排序树(版本2)，加了parent
 * @author kq
 * @date 2021-02-20 10:00
 * @since 1.0.2
 */
public class BinarySortTreeV2 {

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
            prev.setLeft(new Node(prev,key));
        } else {
            prev.setRight(new Node(prev,key));
        }

    }


    public void deleteBST(int key) {
        deleteBST(root,key);
    }

    private boolean deleteBST(Node node,int key) {

        if(node==null) {
            // 未找到节点数据
            System.out.println("未找到key="+key);
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
     * 3.1 如果左右子树均不为空，则需要在右子树中寻找最小的节点，并将右子树中最小的节点接到当前节点 (取右子树-最小值) 删除节点的右子节点，然后一路往左-直接后继
     * 3.2 如果左右子树均不为空，则需要在左子树中寻找最大的节点，并将左子树中最大的节点接到当前节点 (取左子树-最大值) 删除节点的左子节点，然后一路往右-直接前驱
     * 3.1 和 3.2 只要取1個就好了 (其实就是直接前驱(或直接后继)替代p)
     * @param node  要删除的节点
     * @return
     */
    private boolean delete(Node node) {

        /** 右子树空，只需要重接它的左子树
         *  如果是叶子节点，则在这里也把叶子节点删除了
         * */
        boolean delete = false;

        // 左右节点 均不为空
        if(node.getLeft()!=null && node.getRight()!=null) { //叶子节点
            // 这个successor节点，不可能有2个左右节点，最多1个
            Node successor = getSuccessor(node);
            // 把直接后驱的值 替换当前的要删除节点的值
            node.setValue(successor.getValue());

            // 后面还要处理successor节点
            node = successor;

            if(!delete) {
                delete = true;
            }

        }

        Node parent = node.getParent();

        // 1.若p为叶子节点，直接删除
        if(node.getLeft()==null && node.getRight()==null) { //叶子节点

            if(parent == null){ // 只有根节点
                root = null;
                return true;
            }

            if (node == parent.getLeft()){ // 叶子节点是左节点
                parent.setLeft(null);
                return true;
            }
            else if (node == parent.getRight()) { // 叶子节点是右节点
                parent.setRight(null);
                return true;
            }
            return delete;
        }


        // 先得到子节点
        Node childNode = node.getLeft()!=null?node.getLeft():node.getRight();

        // 左右节点 有1个为空
        if(parent == null){ // 删除根节点，则把左/右节点，变为根节点
            root = childNode;
            return true;
        }

        // 判断node是左节点还是右节点
        if (node == parent.getLeft()){
            parent.setLeft(childNode);
            return true;
        }else {
            parent.setRight(childNode);
            return true;
        }


//        // 左右子树均不为空
//            temp = node;
//            Node s = node;
//            /** 转向左子树，然后向右走到尽头 */
//            s = s.getLeft();
//            while (s.getRight()!=null) {
//                temp = s;
//                s = s.getRight();
//            }
//            node.setValue(s.getValue());
//            if(temp!=node) {
//                temp.setRight(s.getLeft());
//            }else {
//                temp.setLeft(s.getLeft());
//            }
//        }

    }

    /**
     * 先得到右节点，然后一路往左
     * @param node
     * @return
     */
    private Node getSuccessor(Node node) {

//        if(node == null) {
//            return null;
//        }

        Node successor = node.getRight();

        if(successor!=null) {

            while(successor.getLeft()!=null) {
                successor = successor.getLeft();
            }
        }

        return successor;
    }

    public void middleIter(){
        if(root==null){
            System.out.println("root is null.");
        } else {
            middleIter(root);
        }
    }

    //前序遍历（递归实现）
    public void preIter(Node node) {
        if(node == null) {
            return;
        }
        System.out.print(node.getValue() + ",");
        preIter(node.getLeft());
        preIter(node.getRight());
    }

    //后序遍历（递归实现）
    public static void posIter(Node node) {
        if(node == null) {
            return;
        }
        System.out.print(node.getValue() + ",");
        posIter(node.getLeft());
        posIter(node.getRight());
    }

    /**
     * 中序遍历
     * 先左子树-根-右子树
     * 从root的最下面一层的左节点开始
     * root的左子树(从root左子树的最下面一层的左节点开始)
     * root的右子树(从root右子树的最下面一层的左节点开始)
     */
    //中序遍历（递归实现）
    private void middleIter(Node node) {
        if(node == null) {
            return;
        }
        middleIter(node.getLeft());
        System.out.print(node.getValue() + ",");
        middleIter(node.getRight());
    }

    public void printRoot(){
        System.out.println(root);
    }

}
