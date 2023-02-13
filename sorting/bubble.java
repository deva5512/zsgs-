package Sorting;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int[] a = { 3, 2, 1, 5 };
		bubbleSort(a);
		System.out.println(Arrays.toString(a));
	}

	public static void bubbleSort(int[] a) {
		boolean control = true;
		int len = a.length - 1;
		do {
			control = false;
			for (int i = 0; i < len; i++) {
				if (a[i] > a[i + 1]) {
					swap(a, i, i + 1);
					control = true;
				}
			}
			len--;

		} while (control);
	}

	public static void swap(int[] array, int first, int second) {
		array[first] = (array[second] + array[first]) - (array[second] = array[first]);
	}
}
