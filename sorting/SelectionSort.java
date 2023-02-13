package Sorting;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] a = { 3, 2, 1 };
		selectionSort(a);
		System.out.println(Arrays.toString(a));
	}

	public static void selectionSort(int[] a) {

		for (int i = 0; i < a.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[min] > a[j]) {
					min = j;
				}
			}
			swap(a, i, min);
		}

	}

	public static void swap(int[] array, int first, int last) {
		array[first] = (array[last] + array[first]) - (array[last] = array[first]);
	}
}
