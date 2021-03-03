package com.kq.algorithm.tree.mytree;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author kq
 * @date 2021-03-03 9:10
 * @since 2020-0630
 */
public class IDUtil {

    public static AtomicLong ato = new AtomicLong();

    public static long getIncrementId(){
        return ato.incrementAndGet();
    }

    public static long getCurrentId(){
        return ato.get();
    }

}
