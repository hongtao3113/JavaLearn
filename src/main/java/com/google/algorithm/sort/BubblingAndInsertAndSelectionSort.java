package com.google.algorithm.sort;

import java.util.Arrays;

/**
 * 极客时间-插入排序为什么比冒泡排序更受欢迎
 * 选择排序
 *
 * @author wk
 */
public class BubblingAndInsertAndSelectionSort {

    public static void main(String[] args) {
        int arr[] = productArray(10);
        System.out.println("原始数组：".concat(Arrays.toString(arr)));
        bubblingSort(arr);
        int array[] = {3, 2, 1};
        insertionSort(array);
        insertSort(array);
        selectionSort(arr);
    }

    /**
     * 随机生成N个数
     *
     * @param size
     * @return
     */
    private static int[] productArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 100);//Math.random() (0,1]
        }
        return arr;
    }

    /**
     * 冒泡排序（是原地排序、稳定排序 最坏时间复杂度，O(n²) 最好时间复杂度，O(n);
     * 比较相邻的元素，第一个比第二个大就交换位置
     */
    private static void bubblingSort(int arr[]) {
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
            }
            // 考虑已是有序数组的情况，只进行一次冒泡排序
            if (!flag) {
                break;
            }
        }
        System.out.println("冒泡排序：".concat(Arrays.toString(arr)));
    }

    /**
     * 插入排序（是原地排序、稳定排序;最好时间复杂度O(n)顺序,最坏时间复杂度O(n²)倒序也是
     *
     * @param arr
     */
    private static void insertionSort(int arr[]) {

        // 第一个元素作为已排序区，其他元素为未排序区
        //[3,2,1]
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];//未排序区的左边第一个元素
            int j = i - 1;//已排序区右边第一个元素
            // 查找插入的位置
            for (; j >= 0; j--) {
                if (arr[j] > current) {
                    arr[j + 1] = arr[j];// 若待排序元素小于已排序元素 则移动数据
                } else {
                    break;
                }
            }
            arr[j + 1] = current;// 插入数据
        }
        System.out.println("插入排序：".concat(Arrays.toString(arr)));
    }

    /**
     * 插入排序
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        if (arr.length == 0) {
            throw new RuntimeException("数组长度不能为0");
        }
        int current;
        for (int i = 0; i < arr.length - 1; i++) {
            current = arr[i + 1];//待排序区的第一个元素
            int preIndex = i;//已排序区最右边的元素
            while (preIndex >= 0 && current < arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;//将待排序元素插入到已排序区
        }
        System.out.println("插入排序2：" + Arrays.toString(arr));
    }

    /**
     * 选择排序（不稳定排序算法
     * 在未排序区找到最小（大）元素，放在数组起始位置
     * 最好、最坏、平均时间复杂度均为O（n²）
     *
     * @param arr
     */
    private static void selectionSort(int arr[]) {
        if (arr.length == 0) {
            throw new RuntimeException("数组长度不能为0");
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        System.out.println("选择排序：" + Arrays.toString(arr));
    }

}
