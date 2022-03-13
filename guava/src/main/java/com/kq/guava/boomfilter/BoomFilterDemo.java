package com.kq.guava.boomfilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * BoomFilterDemo
 *
 * @author kq
 * @date 2022-03-05 13:14
 * @since 1.0.0
 */
public class BoomFilterDemo {

    private static int size = 1000000;
    //fpp代表误判率控制在多少
    static double fpp = 0.01; // 误判10001-20000 之间  误判100个
//    static double fpp = 0.00001d; // 误判10001-20000 之间  误判0个
    private static BloomFilter<String> bf = BloomFilter.create(Funnels.stringFunnel(Charset.defaultCharset()), size,fpp);

    public static void main(String[] args) {

        // 初始化1000000条数据到过滤器中
        for (int i = 0; i < size; i++) {
            bf.put(String.valueOf(i)); // BloomFilterStrategies
        }

        int failCount = 0;

        // 匹配已在过滤器中的值，是否有匹配不上的
        for (int i = 0; i < size; i++) {
            if (!bf.mightContain(String.valueOf(i))) {
                System.out.println("未匹配上的数据");
                failCount++;
            }
        }
        System.out.println("未匹配上的正确数据量:"+failCount);

        // 匹配不在过滤器中的10000个值，有多少匹配出来
        int count = 0;
        // 误命中list
        List<String> errorList = new ArrayList<>();
        for (int i = size; i < size + 10000; i++) {
            if (bf.mightContain(String.valueOf(i))) {
                count++;
                errorList.add(String.valueOf(i));
            }
        }

        System.out.println("误命中的数量：" + count);
        System.out.println("误命中的数据：" + errorList.toString());

        // e是自然对数的底数，是一个无限不循环小数，其值是2.71828
        // Math.log 以e为底
        // Math.log10 以10为底
        System.out.println(Math.log(-1)); // -Infinity
        System.out.println(Math.log(0)); // -Infinity
        System.out.println(Math.log(2)); // 0.6931471805599453
        System.out.println(Math.log(4)); // 1.3862943611198906
        System.out.println(Math.log(16)); // 2.772588722239781
        System.out.println(Math.log(100));
        System.out.println(Math.log10(100)); // 2  10的平方 右上角是2
        System.out.println(Math.log10(1000)); // 3  10*10*10 右上角是3
        System.out.println(Math.log(0.00001));// -11.512925464970229

        // return (long) (-n * Math.log(p) / (Math.log(2) * Math.log(2)));


    }

}
