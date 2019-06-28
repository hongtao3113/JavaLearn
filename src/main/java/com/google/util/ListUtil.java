package com.google.util;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		list2.add(2);
		list.addAll(null);// 会报空指针
		System.out.println(list);

	}

}
