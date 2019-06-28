package com.google.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Vector;

/**
 * ArrayList和LinkedList的区别
 * 
 * @author wk
 *
 */
@SuppressWarnings("unused")
public class ArrayListAndLinkedList {
	
	public static void main(String[] args) {
		//基于数组 Object[] Vector线程安全
		ArrayList<Object> arrayList = new ArrayList<>();
		Vector<Object> vector = new Vector<>();
		
		//基于链表
		LinkedList<Object> linkedList = new LinkedList<>();
		//本质上是数组与链表的区别，是否线程安全
		HashMap<Object, Object> hashMap = new HashMap<>();
	}

}
