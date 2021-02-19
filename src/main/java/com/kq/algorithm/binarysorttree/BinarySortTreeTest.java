package com.kq.algorithm.binarysorttree;

/**
 * BinarySortTreeTest
 *
 * @author kq
 * @date 2021/2/19 21:11
 * @since 1.0.0
 */
public class BinarySortTreeTest {

    public static void main(String[] args) {
//        testAdd();
        testDelete();
    }

    public static void testAdd(){
        BinarySortTree tree = new BinarySortTree();
        tree.addBST(1);
        tree.addBST(3);
        tree.addBST(5);
        tree.addBST(5);
        tree.addBST(7);
        tree.addBST(9);

        tree.printRoot();
    }

    public static void testDelete(){
        BinarySortTree tree = new BinarySortTree();
        tree.addBST(1);
        tree.addBST(3);
        tree.addBST(5);
        tree.addBST(7);
        tree.addBST(9);
        tree.printRoot();
        tree.deleteBST(7);

        tree.printRoot();
    }



}
