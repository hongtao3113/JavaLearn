package com.google.algorithm.geek.sort;

import java.util.Arrays;

/**
 * 极客时间-插入排序为什么比冒泡排序更受欢迎
 *
 * @author wk
 *
 */
public class BubblingAndInsertSort {

	public static void main(String[] args) {
		int arr[] = productArray(10);
		System.out.println("原始数组�?".concat(Arrays.toString(arr)));
		bubblingSort(arr);
		insertionSort(arr);
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
			arr[i] = (int) (Math.random() * 100);
		}
		return arr;
	}

	/**
	 * 冒泡排序（是原地排序、稳定排�?; �?坏时间复杂度，O(n²) �?好时间复杂度，O(n);
	 * 比较相邻的元素，第一个比第二个大就交换位�?;
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
			// 考虑已是有序数组的情况，只进行一次冒泡排�?
			if (!flag) {
				break;
			}
		}
		System.out.println("冒泡排序�?".concat(Arrays.toString(arr)));
	}

	/**
	 * 插入排序（是原地排序、稳定排�?;�?好时间复杂度O(n)顺序,�?坏时间复杂度O(n²)倒序�?
	 *
	 * @param arr
	 */
	private static void insertionSort(int arr[]) {

		// 第一个元素作为已排序区间，其他元素为未排序区�?
		for (int i = 1; i < arr.length; i++) {
			int value = arr[i];
			int j = i - 1;
			// 查找插入的位�?

			for (; j >= 0; j--) {
				if (arr[j] > value) {
					arr[j + 1] = arr[j];// 移动数据
				} else {
					break;
				}
			}
			arr[j + 1] = value;// 插入数据
		}
		System.out.println("插入排序�?".concat(Arrays.toString(arr)));
		// 1.取未排序区间的第�?个元�?
		// 2.取已排序区间的最后一个元�?
		// 3.未排序区间的第一个元素与已排序区间的元素进行比较，若小于就进行移动元素，否则继续比较。循环比较完成后�?
		// 4.插入数据
	}

	/**
	 * 选择排序（不稳定排序算法�?
	 *
	 * @param arr
	 */
	private static void selectionSort(int arr[]) {
		if (arr.length == 0) {
			return;
		}

	}

}
