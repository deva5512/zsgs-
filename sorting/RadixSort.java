package Sorting;

import java.util.Arrays;

public class RadixSort {
	public static void main(String[] args) {
		int[] arr = { 70, 6, 31, 28, 52, 555, 12, 989, 2, 1000, 65, 12 };
		radix(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void radix(int[] arr) {

		// To find the maximum value of the array
		int max = Arrays.stream(arr).max().getAsInt();

		int i = 1;
		while (max > 0) {
			// i is the multiple based on index
			countSort(arr, i);

			// Increase the multiple factor based on requirement
			i *= 10;
			max /= 10;
		}

	}

	public static void countSort(int[] arr, int div) {

		// Create a copy of the original array to avoid disturbing the original array
		int temp[] = arr.clone();

		// Create the 10 buckets which will store count of the value according to
		// multiplication factors
		int count[] = new int[10];
		int i = 0;
		int index = 0;

		for (i = 0; i < temp.length; i++) {
			// Index is generated based on value / by divisible factor and mod it with 10 to
			// find the index in the count array
			index = (temp[i] / div) % 10;

			// And store it to its respective buckets
			count[index]++;
		}

		// Find the cumulative counts of the values
		for (i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		// Reinitialize in the original array in reverse order
		// By starting from reverse we can maintain the order
		for (i = arr.length - 1; i >= 0; i--) {
			index = (temp[i] / div) % 10;
			arr[count[index] - 1] = temp[i];
			count[index]--;
		}

	}
}
