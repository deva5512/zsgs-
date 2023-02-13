package Sorting;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		int[] a = { 3, 2, 1, 1 };
		insertion(a);
		System.out.println(Arrays.toString(a));
	}

	public static void insertion(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int temp = i;
			for (int j = i - 1; j >= 0; j--) {
				if (array[temp] < array[j])
					swap(array, temp--, j);
				else
					break;
			}
		}
	}

	public static void swap(int[] array, int first, int second) {
		array[first] = (array[second] + array[first]) - (array[second] = array[first]);
	}
}
