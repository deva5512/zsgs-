package Sorting;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] a = { 1, 6, 5, 1, 6 };
		quickSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}

	public static void quickSort(int[] a, int start, int end) {
		// Check the start in less than end then only the sorting will proceed
		if (start < end) {
			int pivot = pivot(a, start, end);

			// quick sort the pivot point minus one
			quickSort(a, start, pivot - 1);

			// quick sort the pivot point plus one
			quickSort(a, pivot + 1, end);
		}
	}

	public static int pivot(int[] a, int start, int end) {

		// Take the ending point value as pivot point
		int pivot = a[end];

		// Consider i as the starting point
		int i = start;

		for (int j = start; j <= end; j++) {
			// Swap the values according to the pivot
			// Lesser values will be in left side and higher values will be in right side
			if (a[j] < pivot)
				swap(a, i++, j);
		}

		// Finally swap the end point with the i'th index
		swap(a, i, end);

		return i;
	}

	public static void swap(int[] a, int i, int j) {
		// Swap using XOR
//		a[i] = a[i] ^ a[j];
//		a[j] = a[j] ^ a[i];
//		a[i] = a[i] ^ a[j];
		a[i] = (a[i] + a[j]) - (a[j] = a[i]);
	}
}
