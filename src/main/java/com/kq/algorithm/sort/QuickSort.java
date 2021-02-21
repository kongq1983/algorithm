package com.kq.algorithm.sort;

import java.util.Arrays;

/**
 * QuickSort
 * 快速排序
 * 选择pivot = array[0]
 * left=array[0]  right=array[len-1]
 * 从high往左边先处理，如果 array[right] > pivot 则right-- (右边大) 如果array[right] < pivot  right停留在当前位置
 * 把right当前位置的值，赋给array[left] = array[right]  同时left++
 *
 * 然后处理从左往右，如果 array[left] < pivot 则left++ (左边小) 如果array[left] > pivot 则left停留在当前位置
 * 把left当前位置的值，赋给array[right] = array[left]  同时right--
 *
 * 最终left和right在同个位置的时候 把pivot赋给当前位置  array[left]=pivot
 *
 * 然后递归遍历
 * quickSort(array,low,left-1);  //pivot的左边
 * quickSort(array,left+1,high); //pivot的右边
 *
 * @author kq
 * @date 2021/2/20 23:17
 * @since 1.0.0
 */
public class QuickSort {


    private static void quickSort(int[] array,int low,int high) {

        if(low >= high ){
            return;
        }

        // 基准值
        int pivot = array[low];
        // 低位  左边
        int left = low;
        // 高位 右边
        int right = high;

        while (left<right) {
            // 高位大于基准值，则直接往左边移动
            while (left<right && array[right] > pivot) {
                right--;
            }
            // 6,1,25,16,2,8,18  第一次的时候 right=5  也就是 array[left] = array[right]  等于 array[0] = array[4] 等于 array[0]= 2 (第一次)
            if(left<right) {
                array[left] = array[right];  // 把小的值放到left位置
                left++;
            }
            System.out.println("right-to-left:"+Arrays.toString(array)+"  left="+left+",right="+right);
            // 低位小于基准值，则直接往右边移动
            while (left<right && array[left] < pivot) {
                left++;
            }

            if(left<right) {
                array[right] = array[left];
                right--;
            }
            System.out.println("left-to-right:"+Arrays.toString(array)+"  left="+left+",right="+right);
        }

        array[left] = pivot;
        System.out.println(Arrays.toString(array));
        quickSort(array,low,left-1);
        quickSort(array,left+1,high);

    }


    public static void main(String[] args) {
//        int[] array = {6,1,25,16,8,2,8,18};
        int[] array = {6,1,25,16,2,8,18};
        System.out.println(Arrays.toString(array)+"-----");
        quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array)+"-----");
    }

}
