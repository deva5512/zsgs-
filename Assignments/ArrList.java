package assignment;

import java.util.Arrays;

import LinkedList.LocalList;

public class ArrList implements LocalList {

	private int len;
	private int arr[];

	// Constructors
	ArrList() {
		this(5);
	}

	ArrList(int size) {
		arr = new int[size];
	}

	// Functional methods
	@Override
	public long size() {
		return len;
	}

	@Override
	public void add(int index, int value) {
		int temp[] = arr;
		arr = new int[arr.length + 1];
		for (int i = 0, j = 0; i < arr.length; i++) {
			if (index == i)
				arr[i] = value;
			else
				arr[i] = temp[j++];
		}
		len++;
	}

	// Method to sort the array used built in function
	public void sort() {
		int extra_len = arr.length - len - 1;
		arr = Arrays.copyOf(arr, len);
		Arrays.sort(arr);
		arr = Arrays.copyOf(arr, len + extra_len);
	}

	// The method which tells the original size of the array
	public int OrgSize() {
		return arr.length;
	}

	@Override
	public void add(int value) {
		arr[len++] = value;
		if (len == arr.length) {
			growing();
		}
	}

	@Override
	public void remove() {
		if (arr.length == 0) {
			return;
		}
		arr[len--] = 0;
	}

	@Override
	public void remove(int index) {
		for (; index < len; index++) {
			arr[index] = arr[index + 1];
		}
		len--;
	}

	@Override
	public void clear() {
		arr = new int[0];
		len = 0;
	}

	@Override
	public boolean isEmpty() {
		return len == 0;
	}

	// Helper methods
	private void growing() {
		int temp[] = arr;
		arr = new int[arr.length + 5];
		copy(temp);
	}

	private void copy(int[] temp) {
		for (int i = 0; i < temp.length; i++) {
			arr[i] = temp[i];
		}
	}

	@Override
	public String toString() {
		System.out.print("[");
		for (int i = 0; i < len; i++) {
			if (i > 0)
				System.out.print(" , " + arr[i]);
			else
				System.out.print(arr[i]);
		}
		System.out.print("]");
		return "";
	}

	@Override
	public void print() {
		System.out.print("[ ");
		for (int i = 0; i < len; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println("]\n");
	}
}
