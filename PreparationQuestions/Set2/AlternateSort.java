package PreparationQuestions;

import java.util.Arrays;

public class AlternateSort {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		int[] arr1 = { 1, 2, 3, 4, 5, 6, 7 };
		sortAlternately(arr);
		sortAlternately1(arr1);
	}

	public static void sortAlternately(int[] arr) {
		int max = 0;
		for (int i : arr)
			max = Math.max(max, i);
		max += 1;

		int l = 0, r = arr.length - 1;
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0)
				arr[i] += (arr[r--] % max) * max;
			else
				arr[i] += (arr[l++] % max) * max;
		}
		for (int i : arr)
			System.out.print(i / max + " ");
		System.out.println();
	}

	// using bit manupulation
	public static void sortAlternately1(int[] arr) {
		int l = 0, r = arr.length - 1;
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				int val = arr[r];
				if (i > r) {
					val >>= 15;
				}
				arr[i] <<= 15;
				arr[i] |= val;
				r--;
			} else {
				int val = arr[l++] >> 15;
				arr[i] <<= 15;
				arr[i] |= val;
			}
		}
		int mask = (~0) >>> 17;
		for (int i = 0; i < arr.length; i++)
			arr[i] &= mask;
		System.out.println(Arrays.toString(arr));
	}

}
