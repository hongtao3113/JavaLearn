package com.google.data_structure;

/**
 * 基于数组的栈实现-顺序栈， 思考：涉及一个动态扩容的顺序栈
 *
 * @author wk
 *
 */
public class ArrayStack {

	private String[] array;// 定义一个字符串数组
	private int count;// 定义栈中的数据个数
	private int size;// 栈的大小

	private ArrayStack() {

	}

	private ArrayStack(int size) {
		this.array = new String[size];
		this.count = 0;
		this.size = size;
	}

	/**
	 * 入栈
	 *
	 * @param item
	 * @return
	 */
	public void push(String item) {
		// 栈已满，入栈失败
		if (count == size) {
			throw new RuntimeException("栈已满");
		}
		array[count] = item;
		++count;
	}

	public void pushD(String item) {
		// 栈已满，入栈失败
		if (count == size) {
			size = size * 2;
			String s[] = new String[size];
			for (int i = 0; i < count; i++)
				s[i] = this.array[i];
			this.array = s;
		}
		this.array[count] = item;
		++count;
	}

	public String pop() {
		// 栈为空，则直接返回null
		if (count == 0)
			return null;
		// 返回下标为count-1的数组元素，并且栈中元素个数count减一
		String tmp = array[count - 1];
		array[count - 1] = null;
		--count;
		return tmp;
	}

	public static void main(String[] args) {
		ArrayStack arrayStack = new ArrayStack(5);
		for (int i = 0; i < 5; i++) {
			System.out.println(arrayStack.array[i]);
		}
		for (int i = 0; i < 6; i++) {
			arrayStack.pushD(i + "");
		}
		for (int i = 0; i < 5; i++) {
			System.out.println(arrayStack.pop());
		}
		for (int i = 0; i < 5; i++) {
			System.out.println(arrayStack.array[i]);
		}
		System.out.println(arrayStack.size);
	}
}
