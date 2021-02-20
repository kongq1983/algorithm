package com.kq.algorithm.binarysorttree;

import org.junit.Before;
import org.junit.Test;

/**
 * @author kq
 * @date 2021-02-20 10:16
 * @since 2020-0630
 */
public class BinarySortTreeV2Test {

    int[] array = {8,6,50,3,7,15,9,25,20,30,19,32};

    BinarySortTreeV2 tree = null;

    /**
     * 每个@Test都会调用1次
     */
    @Before
    public void init(){
        System.out.println("========================================");
        tree = new BinarySortTreeV2();

        for(int i : array) {
            tree.addBST(i);
        }
    }

    @Test
    public void testAdd(){
        BinarySortTreeV2 tree = new BinarySortTreeV2();
        tree.addBST(1);
        tree.addBST(3);
        tree.addBST(5);
        tree.addBST(5);
        tree.addBST(7);
        tree.addBST(9);

        tree.printRoot();
    }

    @Test
    public void testDeleteHasBothNode(){

        tree.printRoot();
        tree.middleIter();

        System.out.println();
//        tree.deleteBST(20);
        tree.deleteBST(15);
        tree.printRoot();

        tree.middleIter();
    }


    /**
     * 观察20的左节点
     */
    @Test
    public void testDeleteLeafNode(){

        tree.printRoot();
        tree.middleIter();

        System.out.println();
        tree.deleteBST(19);
        tree.printRoot();

        tree.middleIter();
    }

    /**
     * 观察25的左节点
     * 本来25的左节点是20，后来左节点是19
     */
    @Test
    public void testDeleteHasOneNode(){

        tree.printRoot();
        tree.middleIter();

        System.out.println();
        tree.deleteBST(20);
        tree.printRoot();

        tree.middleIter();
    }

}
