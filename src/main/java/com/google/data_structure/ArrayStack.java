package com.google.data_structure;

/**
 * ���������ջʵ��-˳��ջ�� ˼�����漰һ����̬���ݵ�˳��ջ
 * 
 * @author wk
 *
 */
public class ArrayStack {

	private String[] array;// ����һ���ַ�������
	private int count;// ����ջ�е����ݸ���
	private int size;// ջ�Ĵ�С

	private ArrayStack() {

	}

	private ArrayStack(int size) {
		this.array = new String[size];
		this.count = 0;
		this.size = size;
	}

	/**
	 * ��ջ
	 * 
	 * @param item
	 * @return
	 */
	public void push(String item) {
		// ջ��������ջʧ��
		if (count == size) {
			throw new RuntimeException("ջ����");
		}
		array[count] = item;
		++count;
	}

	public void pushD(String item) {
		// ջ��������ջʧ��
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
		// ջΪ�գ���ֱ�ӷ���null
		if (count == 0)
			return null;
		// �����±�Ϊcount-1������Ԫ�أ�����ջ��Ԫ�ظ���count��һ
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
