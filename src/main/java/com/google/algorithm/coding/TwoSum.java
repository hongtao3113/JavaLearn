package com.google.algorithm.coding;

import java.util.HashMap;
import java.util.Map;

/**
 * 求一个数组中，两个数的和为x，取这两个数的索引
 * 
 * @author wk
 *
 */
public class TwoSum {

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 7, 11, 15 };
		int target = 9;
		System.out.println(test1(nums, target));
		System.out.println(test2(nums, target));
	}

	public static int[] test1(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] == target - nums[i]) {
					return new int[] { i, j };
				}
			}
		}
		throw new IllegalArgumentException("no result");
	}

	public static int[] test2(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);// key取值，value取索引
		}
		for (int i = 0; i < nums.length; i++) {
			int x = target - nums[i];
			if (map.containsKey(x) && map.get(x) != i) {
				return new int[] { i, map.get(x) };
			}
		}
		throw new IllegalArgumentException("no result");
	}

}
