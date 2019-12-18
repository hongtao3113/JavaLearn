package com.google.util;

/**
 * @author wk
 * @Description:Math相关的工具类
 * @date 2019/7/12 18:43
 **/
public class MathUtil {

    /**
     * 随机生成N个数
     *
     * @param size
     * @return
     */
    public static int[] productArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 100);//Math.random() (0,1]
        }
        return arr;
    }
}
