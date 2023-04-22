package PreparationQuestions;

import java.util.Scanner;

/*
   1.	two sorted arrays nums1 and nums2 return the median of the two sorted arrays.
		
		Input: nums1 = [1,3], nums2 = [2]
		Output: 2.00000
		Explanation: merged array = [1,2,3] and median is 2.
		
		Input: nums1 = [1,2], nums2 = [3,4]
		Output: 2.50000
		Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */

public class MedianOfTwoSortedArray_22_04_2023 {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

//		System.out.println("Enter the size of the array one : ");
//		int size = scanner.nextInt();
//
//		int[] arr = new int[size];
//
//		for (int i = 0; i < size; i++) {
//			System.out.print("Enter the element " + i + " : ");
//			arr[i] = scanner.nextInt();
//		}
//
//		System.out.println("Enter the size of the array two : ");
//		int size1 = scanner.nextInt();
//
//		int[] arr1 = new int[size1];
//
//		for (int i = 0; i < size1; i++) {
//			System.out.print("Enter the element " + i + " : ");
//			arr1[i] = scanner.nextInt();
//		}

		int arr[] = { 1, 3, 6 };
		int arr1[] = { 7, 8 };

		medianOfSortedArray(arr, arr1);
	}

	private static void medianOfSortedArray(int[] arr1, int[] arr2) {
		int len = arr1.length + arr2.length;

		boolean even = len % 2 == 0;
		int mid = len / 2;

		if (even) {
			mid--;
		}
		int i = 0, j = 0;
		while (mid > 0 && i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				i++;
			} else {
				j++;
			}
			mid--;
		}

		if (mid != 0) {
			while (mid > 0 && i < arr1.length) {
				i++;
				mid--;
			}
			while (mid >= 0 && j < arr2.length) {
				j++;
				mid--;
			}
		}

		double res = 0;
		if (even) {
			if (i < arr1.length && j < arr2.length) {
				res = arr1[i] < arr2[j] ? arr1[i++] : arr2[j++];
			} else {
				res = i < arr1.length ? arr1[i++] : arr2[j++];
			}
			if (i < arr1.length && j < arr2.length) {
				res += arr1[i] < arr2[j] ? arr1[i] : arr2[j];
			} else {
				res += i < arr1.length ? arr1[i] : arr2[j];
			}
			res /= 2.0;
		} else {
			if (i < arr1.length && j < arr2.length) {
				res = arr1[i] < arr2[j] ? arr1[i] : arr2[j];
			} else {
				res = i < arr1.length ? arr1[i] : arr2[j];
			}
		}
		System.out.println(res);
	}

}
