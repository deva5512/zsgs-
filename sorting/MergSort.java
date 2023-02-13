package Sorting;

import java.util.Arrays;

public class MergSort {
	public static void main(String[] args) {
		int[] arr = { 5, 1, 6, 4, 7, 8, 9, 1, 2, 3 };
		msort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void msort(int[] arr) {
		if (arr.length == 1) {
			return;
		}
		int len = arr.length;
		int[] left = Arrays.copyOfRange(arr, 0, len / 2);
		msort(left);
		int[] right = Arrays.copyOfRange(arr, len / 2, len);
		msort(right);

		merg(arr, left, right);
	}

	public static void merg(int[] org, int left[], int right[]) {

		int l = 0, r = 0, ind = 0;

		while (l < left.length && r < right.length) {
			if (left[l] < right[r]) {
				org[ind++] = left[l++];
			} else {
				org[ind++] = right[r++];
			}
		}

		while (l < left.length) {
			org[ind++] = left[l++];
		}

		while (r < right.length) {
			org[ind++] = right[r++];
		}
	}
}
