package com.kq.algorithm.sort.bubble;

import java.util.Arrays;

/**
 * BubbleSort
 * 冒泡排序
 * @author kq
 * @date 2021/2/20 22:28
 * @since 1.0.0
 */
public class BubbleSort {

    /**
     * 456321(初始)
     * 453216(第1次)
     * 432156(第2次)
     * 321456(第3次)
     * 213456(第4次)
     * 123456(第4次)
     * @param array
     */
    public static void bubbleSort(int[] array) {

        // 外层控制循环次数
        for(int i=0;i<array.length-1;i++) {

            // 内层控制每1套排序，第1次找出最大值放最后，第2次找出第2大值，放倒数第2个位置，以此类推
            // 假设length=6 , i=0的时候  j最大=4  j+1=5
            // 假设length=6 , i=1的时候  j最大=3  j+1=4
            // 假设length=6 , i=2的时候  j最大=2  j+1=3
            for(int j=0;j<array.length-1-i;j++) {
//                System.out.println("i="+i);
                if(array[j]>array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }

            }

        }

    }

    public static void main(String[] args) {
        int[] array = {4,5,6,3,2,1};
        System.out.println(Arrays.toString(array));
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

}
