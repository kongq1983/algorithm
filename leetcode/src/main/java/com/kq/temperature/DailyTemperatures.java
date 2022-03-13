package com.kq.temperature;

import java.util.Deque;
import java.util.LinkedList;

/**
 * DailyTemperatures
 * 每日温度
 *  @description ：(LeetCode-739) 每日温度
 *  请根据每日气温列表 temperatures ，请计算在每一天需要等几天才会有更高的温度
 *  如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * @author kq
 * @date 2022-03-13 23:22
 * @since 1.0.0
 */
public class DailyTemperatures {


    /*标准栈的解法*/
    public static int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<Integer>(); // 存的是位置 从0开始
        int[] ret = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {

            // 当前i的位置  和  栈顶的值比较，
            // 比如大于栈顶的值，则进入条件 ，说明温度升高了
            // 依次循环 和 下一个栈顶比较，如果还是大于，继续循环
            // 如果小于，则入栈
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop(); // 弹出的是值  当前stack的值
                ret[idx] = i - idx;
            }
            stack.push(i);
        }
        return ret;
    }


    public static void main(String[] args) {
        // 需要几天温度升高
        int arrays[] = {10,12,9,6,7,5,15,13,18};

        int[] result = dailyTemperatures(arrays);

        for(int i : result) {
            System.out.print(i+" ");
        }

    }

}
